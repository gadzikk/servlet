import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gadzik on 14.12.17.
 */
public class ControlServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "passing";
        request.setAttribute("message", message); // This will be available as ${message}
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
