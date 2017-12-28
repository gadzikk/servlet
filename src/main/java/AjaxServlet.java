import com.google.gson.Gson;
import db.Parameters;
import front.PersonData;
import service.AccountService;
import service.AccountServiceImp;
import service.PersonService;
import service.PersonServiceImp;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchCriteria = request.getParameter("search");

        PersonService personService = new PersonServiceImp();
        PersonData data = new PersonData();
        Parameters parameters = new Parameters.Builder().name(searchCriteria).build();
        data.setPersons(personService.getPersonsBySurname(parameters));

        LOGGER.info(data.getPersons().toString());

        String json = new Gson().toJson(data.getPersons());
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
