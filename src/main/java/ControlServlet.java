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

        RestGet(request.getParameter("rest"), request.getParameter("method"), params);
        forward(request.getParameter("page"), request, response);
    }

    private void RestGet(String rest, String method, Parameters params) {
        if ("account".equals(rest)) {
            FrontData data = new AccountDB().getConnection(method, params);
            if(data.getAccount() !=null){
                LOGGER.info(data.getAccount().toString());
            }
            if(data.getAccounts() !=null){
                LOGGER.info(data.getAccounts().toString());
            }
//            LOGGER.info(data.getAccounts().toString());
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