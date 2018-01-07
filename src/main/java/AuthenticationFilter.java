import model.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gadzik on 06.01.18.
 */
public class AuthenticationFilter implements Filter {
    private static String[] EXCLUDEDVIEWS = {"index.jsp", "unauthorized.jsp", "control", "style.css"};

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Account account = (Account) request.getSession().getAttribute("auth");
        if (account != null || excluded(request)) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect("unauthorized.jsp");
        }
    }

    private boolean excluded(HttpServletRequest request) {
        String uri = request.getRequestURI();
        for (String view : EXCLUDEDVIEWS) {
            if (uri.contains(view)) {
                return true;
            }
        }
        return false;
    }

    public void destroy() {
    }
}
