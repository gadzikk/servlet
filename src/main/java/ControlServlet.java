import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by gadzik on 14.12.17.
 */
public class ControlServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logParameters(request);
        if (request.getParameter("rest") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        Parameters params = new Parameters.Builder()
                .id(Long.valueOf(request.getParameter("id")))
                .build();

        RestGet(request.getParameter("rest"), request.getParameter("method"), params);
        forward(request.getParameter("page"), request, response);
    }

    private void RestGet(String rest, String method, Parameters params) {
        if ("account".equals(rest)) {
            FrontData data = new MyBean().connectionWithDB(method, params);
            System.out.println("------------");
            System.out.println(data.account);
        }
    }

    private void forward(String page, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (page != null) {
            response.sendRedirect(request.getParameter("page"));
        }
    }

    private void logParameters(HttpServletRequest request) {
        Logger LOGGER = Logger.getLogger(ControlServlet.class.toString());
        Enumeration<String> paramsPrint = request.getParameterNames();
        while (paramsPrint.hasMoreElements()) {
            String paramName = paramsPrint.nextElement();
            LOGGER.info("Parameter Name - " + paramName + ", Value - " + request.getParameter(paramName));
        }
    }

}