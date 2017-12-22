import db.AccountDB;
import db.Parameters;
import db.PersonDB;
import front.FrontData;
import front.PersonData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by gadzik on 14.12.17.
 */
public class ControlServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(ControlServlet.class.toString());

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logParameters(request);

        Parameters params = new Parameters.Builder()
                .id(request.getParameter("id"))
                .build();

        RestGet(request, request.getParameter("rest"), request.getParameter("method"), params);
        forward(request.getParameter("page"), request, response);
    }

    private void RestGet(HttpServletRequest request, String rest, String method, Parameters params) {
        if ("account".equals(rest)) {
            FrontData data = new AccountDB().getConnection(method, params);
            if (data.getAccount() != null) {
                LOGGER.info(data.getAccount().toString());
            }
            if (data.getAccounts() != null) {
                LOGGER.info(data.getAccounts().toString());
            }
        } else if ("person".equals(rest)) {
            PersonData data = new PersonDB().getConnection(method, params);
            LOGGER.info(data.getPersons().toString());
            request.getSession().setAttribute("persondata",data);

        }
    }

    private void forward(String page, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (page != null) {
            response.sendRedirect(request.getParameter("page"));
        }
    }

    private void logParameters(HttpServletRequest request) {
        Enumeration<String> paramsPrint = request.getParameterNames();
        while (paramsPrint.hasMoreElements()) {
            String paramName = paramsPrint.nextElement();
            LOGGER.info("Parameter Name - " + paramName + ", Value - " + request.getParameter(paramName));
        }
    }

}