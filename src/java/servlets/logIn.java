package servlets;

import Controller.Control_DB;
import Model.User;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Eng Eslam khder
 */
public class logIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email").trim(),
                password = request.getParameter("password").trim();
        Connection connection = (Connection) getServletContext().getAttribute("Connect");
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Control_DB control = new Control_DB();
        control.setConnecion(connection);
        user = control.getUser(user);
        if (user.getId() == 0) {
            response.sendRedirect("View/friend-finder/Log_In.html");
        } else if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("View/friend-finder/newsfeed.jsp");
        }
    }
}
