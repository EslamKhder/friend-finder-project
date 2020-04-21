package servlets.Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class LoginNewaccFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse r = (HttpServletResponse) response;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email == null || password == null) {
            r.sendRedirect("View/friend-finder/Log_In.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }
}
