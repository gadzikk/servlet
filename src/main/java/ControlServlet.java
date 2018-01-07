import db.AccountDaoImp;
import db.Parameters;
import db.PersonDaoImp;
import front.AccountData;
import front.PersonData;
import model.Account;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by gadzik on 14.12.17.
 */
public class ControlServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(ControlServlet.class.toString());

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Parameters params = new Parameters.Builder()
                .name(request.getParameter("search"))
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();

        RestGet(request, request.getParameter("rest"), request.getParameter("method"), params);
        forward(request.getParameter("view"), request, response);
    }

    private void RestGet(HttpServletRequest request, String rest, String method, Parameters params) {
        if ("account".equals(rest)) {
            AccountService accountService = new AccountServiceImp();
            if ("getbyid".equals(method)) {
                AccountData accountData = new AccountData();
                accountData.setAccount(accountService.getById(params));
                LOGGER.info(accountData.getAccount().toString());
            }
        } else if ("person".equals(rest)) {
            PersonService personService = new PersonServiceImp();
            PersonData data = new PersonData();
            data.setPersons(personService.getAll());
            LOGGER.info(data.getPersons().toString());
            request.getSession().setAttribute("persondata", data);
        } else if ("authentication".equals(rest)) {
            AuthenticationService service = new AuthenticationServiceImp();
            if ("login".equals(method)) {
                request.getSession().setAttribute("auth", service.login(params));
            }
        }
    }

    private void forward(String view, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (view != null) {
            response.sendRedirect(request.getParameter("view"));
        }
    }
}