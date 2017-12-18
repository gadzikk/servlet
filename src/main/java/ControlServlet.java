import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by gadzik on 14.12.17.
 */
public class ControlServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Parameters params = new Parameters.Builder()
                .id(2L)
                .build();

        System.out.println(request.getParameter("rest") + request.getParameter("method"));
        RestGet(request.getParameter("rest"),request.getParameter("method"),params);

        FrontData data = new MyBean().connectionWithDB("getbyid", params);

//        for (String g : data.accounts) {
//            System.out.println("------------");
//            System.out.println(g);
//        }

        System.out.println("------------");
        System.out.println(data.account);

        String message = "passing";
        request.setAttribute("message", message); // This will be available as ${message}
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void RestGet(String rest, String method, Parameters params) {
        if ("account".equals(rest)) {
            new MyBean().connectionWithDB(method, params);

        }
    }

}