import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by gadzik on 14.12.17.
 */
public class ControlServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> list =  new MyBean().connectionWithDB();
        for(String g:list){
            System.out.println("------------");
            System.out.println(g);
        }

        String message = "passing";
        request.setAttribute("message", message); // This will be available as ${message}
//        request.setAttribute("boo", boo);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}