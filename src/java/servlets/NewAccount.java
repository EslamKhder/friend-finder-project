package servlets;

import DataBaseFiles.ServicesImplementation.UserServices;
import Model.User;
import java.io.IOException;
import java.sql.Connection;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
            int distance = Integer.parseInt(request.getParameter("distance").trim());;
            if (name.isEmpty()) {
                response.getWriter().print("name");
            } else if (password.isEmpty()) {
                response.getWriter().print("password");
            } else if (job.isEmpty() || !(Pattern.matches("[a-zA-Z]+", job))) {
                response.getWriter().print("job");
            } else if (!(valEmail(email)) || email.isEmpty()) {
                response.getWriter().print("email");
            } else {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setJob(job);
                user.setDistance(distance);
                UserServices userservices = new UserServices();
                userservices.setConnection((Connection) getServletContext().getAttribute("Connect"));
                userservices.add(user);
                int id = userservices.getUserId(user);
                user.setId(id);
                request.getSession().setAttribute("user", user);
                Cookie c1 = new Cookie("email", email);
                Cookie c2 = new Cookie("password", password);
                c1.setMaxAge(60 * 60 * 24);
                c2.setMaxAge(60 * 60 * 24);
                response.addCookie(c1);
                response.addCookie(c2);
                response.getWriter().print("success");
            }

        } catch (Exception e) {
            response.getWriter().print("distance");
        }

    }

    public boolean valEmail(String input) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,3}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        return emailPat.matcher(input).find();
    }
}
