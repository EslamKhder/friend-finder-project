package servlets;

import DataBaseFiles.ServicesImplementation.UserServices;
import Model.User;
import java.io.IOException;
import java.sql.Connection;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
                response.sendRedirect("View/friend-finder/New_logIn.jsp");
            } else {
                if (!(Pattern.matches("[a-zA-Z]+", job)) || !(valEmail(email))) {
                    JOptionPane.showMessageDialog(null, "yes");
                    response.sendRedirect("View/friend-finder/New_logIn.jsp");
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
                        int id = userservices.getUserId(user);
                        user.setId(id);
                        request.getSession().setAttribute("user", user);
                        response.sendRedirect("View/friend-finder/newsfeed.jsp");
                    } else {
                        response.sendRedirect("View/friend-finder/New_logIn.jsp");
                    }
                }
            }

        } catch (Exception e) {
            response.sendRedirect("View/friend-finder/New_logIn.jsp");
        }

    }
    public boolean valEmail(String input) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,3}$";
        Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
        return emailPat.matcher(input).find();
    }
}
