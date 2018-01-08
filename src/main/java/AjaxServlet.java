import com.google.gson.Gson;
import db.Parameters;
import front.PersonData;
import service.PersonService;
import service.PersonServiceImp;
import service.TransferService;
import service.TransferServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by gadzik on 24.12.17.
 */
public class AjaxServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(AjaxServlet.class.toString());

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Parameters parameters = new Parameters.Builder()
                .name(request.getParameter("search"))
                .page(request.getParameter("page"))
                .orderby(request.getParameter("orderby"))
                .ordering(request.getParameter("ordering"))
                .senderId(request.getParameter("sender_id"))
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
            if ("outgoing".equals(method)) {
                transferService.outgoingTransfer(params);
                transferService.incomingTransfer(params);
                String json = new Gson().toJson(1);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
        }
    }
}