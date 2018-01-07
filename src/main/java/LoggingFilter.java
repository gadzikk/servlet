import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

/**
 * Created by gadzik on 06.01.18.
 */
public class LoggingFilter implements Filter {
    private static Logger LOGGER = Logger.getLogger(LoggingFilter.class.toString());

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest servletRequest, ServletResponse  servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        LOGGER.info("URI: " + request.getRequestURI());
        Enumeration<String> paramsPrint = request.getParameterNames();
        while (paramsPrint.hasMoreElements()) {
            String paramName = paramsPrint.nextElement();
            LOGGER.info("Parameter Name - " + paramName + ", Value - " + request.getParameter(paramName));
        }
        chain.doFilter(request, servletResponse);
    }

    public void destroy() {}


}
