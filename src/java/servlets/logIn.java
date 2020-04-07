package servlets;

import DataBaseFiles.ServicesImplementation.UserServices;
import Model.User;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You must fill All flieds", "invalid", JOptionPane.ERROR_MESSAGE);
            response.sendRedirect("View/friend-finder/Log_In.html");
        } else {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            UserServices userservices = new UserServices();
            userservices.setConnection(connection);
            user = userservices.getUser(user);
            if (user.getId() == 0) {
                response.sendRedirect("View/friend-finder/Log_In.html");
            } else if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("View/friend-finder/newsfeed.jsp");
            }
        }
    }
}