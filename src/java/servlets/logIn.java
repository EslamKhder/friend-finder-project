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

public class logIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email").trim(),
                password = request.getParameter("password").trim();
        Connection connection = (Connection) getServletContext().getAttribute("Connect");
        if (email.isEmpty() || !(valEmail(email))) {
            response.getWriter().print("email");
            //response.sendRedirect("View/friend-finder/Log_In.jsp?error=email");
        } else if (password.isEmpty()) {
            response.getWriter().print("password");
            //response.sendRedirect("View/friend-finder/Log_In.jsp?error=password");
        } else {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            UserServices userservices = new UserServices();
            userservices.setConnection(connection);
            user = userservices.getUser(user);
            if (user.getId() == 0) {
                response.getWriter().print("invalid");
                //response.sendRedirect("View/friend-finder/Log_In.jsp?error=invalid");
            } else if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                Cookie c1 = new Cookie("email", email);
                Cookie c2 = new Cookie("password", password);
                c1.setMaxAge(60 * 60 * 24);
                c2.setMaxAge(60 * 60 * 24);
                response.addCookie(c1);
                response.addCookie(c2);
                request.getSession().setAttribute("user", user);
                response.getWriter().print("success");
                //response.sendRedirect("View/friend-finder/newsfeed.jsp");
            }
        }
    }

    public boolean valEmail(String input) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,3}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        return emailPat.matcher(input).find();
    }
}
