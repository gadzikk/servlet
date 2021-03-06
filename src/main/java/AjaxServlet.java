import com.google.gson.Gson;
import db.Parameters;
import front.PersonData;
import front.TransferData;
import model.Account;
import model.Customer;
import model.Transfer;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by gadzik on 24.12.17.
 */
public class AjaxServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(AjaxServlet.class.toString());

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Parameters parameters = new Parameters.Builder()
                .id(request.getParameter("id"))
                .name(request.getParameter("search"))
                .page(request.getParameter("page"))
                .orderby(request.getParameter("orderby"))
                .ordering(request.getParameter("ordering"))
                .receiverId(request.getParameter("receiver_id"))
                .money(request.getParameter("money"))
                .build();

        Rest(request, response, request.getParameter("rest"), request.getParameter("method"), parameters);
    }

    private void Rest(HttpServletRequest request, HttpServletResponse response, String rest, String method, Parameters params) throws IOException {
        if ("person".equals(rest)) {
            if ("getbysurnamewithpagination".equals(method)) {
                PersonService personService = new PersonServiceImp();
                PersonData data = new PersonData();
                data.setPersons(personService.getPersonsBySurnameWithPagination(params));

                String json = new Gson().toJson(data);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
            if ("gettotalbysurname".equals(method)) {
                PersonService personService = new PersonServiceImp();
                int total = personService.countPersonsBySurname(params);

                String json = new Gson().toJson(total);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
        } else if ("transfer".equals(rest)) {
            TransferService transferService = new TransferServiceImp();
            AccountService accountService = new AccountServiceImp();
            ValidationService validationService = new ValidationServiceImp();
            OperationService operationService = new OperationServiceImp();
            if ("outgoing".equals(method)) {
                Account sender = accountService.getById(params.getId());
                if (!validationService.validateOutgoingMoney(sender.getMoney(), params.getMoney())) {
                    response.sendRedirect("error_outgoingmoney.jsp");
                    return;
                }
                Account receiver = accountService.getById(params.getReceiverId());
                if (receiver == null) {
                    response.sendRedirect("error_404notfound.jsp");
                    return;
                }
                transferService.outgoingTransfer(params);
                transferService.incomingTransfer(params);
                transferService.saveTransfer(params);
                operationService.saveOperation(params.getId(), "OUTGOING_TRANSFER", params.getMoney());
                operationService.saveOperation(params.getReceiverId(), "INCOMING_TRANSFER", params.getMoney());

                TransferData data = new TransferData.Builder()
                        .sender(new Customer(sender.getId(), sender.getEmail()))
                        .receiver(new Customer(receiver.getId(), receiver.getEmail()))
                        .money(params.getMoney())
                        .build();

                String json = new Gson().toJson(data);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } else if("getbyaccountwithpagination".equals(method)) {
                List<Transfer> transfers = transferService.getByAccountWithPagination(params);

                String json = new Gson().toJson(transfers);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }else if("gettotalbyaccount".equals(method)){
                int total = transferService.countByAccount(params);

                String json = new Gson().toJson(total);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
        }
    }
}