import com.google.gson.Gson;
import db.Parameters;
import front.PersonData;
import service.PersonService;
import service.PersonServiceImp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

/**
 * Created by gadzik on 24.12.17.
 */
public class AjaxServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(AjaxServlet.class.toString());

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logParameters(request);

        Parameters parameters = new Parameters.Builder()
                .name(request.getParameter("search"))
                .page(request.getParameter("page"))
                .build();

        RestGet(request, response, request.getParameter("rest"), request.getParameter("method"), parameters);
    }

    private void RestGet(HttpServletRequest request, HttpServletResponse response, String rest, String method, Parameters params) throws IOException {
        if ("person".equals(rest)) {
            if ("getbysurnamewithpagination".equals(method)) {
                PersonService personService = new PersonServiceImp();
                PersonData data = new PersonData();
                data.setPersons(personService.getPersonsBySurnameWithPagination(params));
                data.setTotal(personService.countPersonsBySurname(params));

                String json = new Gson().toJson(data);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }
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