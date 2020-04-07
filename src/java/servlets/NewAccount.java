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
public class NewAccount extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("fullname").trim(),
                    email = request.getParameter("email").trim(),
                    password = request.getParameter("password").trim(),
                    job = request.getParameter("job").trim();
            int distance = 0;
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || job.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You must fill all Flied", "invalid",
                        JOptionPane.ERROR_MESSAGE);
                response.sendRedirect("View/friend-finder/New_logIn.html");
            } else {
                
                distance = Integer.parseInt(request.getParameter("distance").trim());
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setJob(job);
                user.setDistance(distance);
                UserServices userservices = new UserServices();
                userservices.setConnection((Connection) getServletContext().getAttribute("Connect"));
                if (userservices.add(user) == 1) {
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("View/friend-finder/newsfeed.jsp");
                } else {
                    response.sendRedirect("View/friend-finder/New_logIn.html");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Distance must include only Number", "invalid",
                    JOptionPane.ERROR_MESSAGE);
            response.sendRedirect("View/friend-finder/New_logIn.html");
        }

    }
}
