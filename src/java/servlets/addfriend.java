package servlets;

import Controller.DatabaseControl;
import DataBaseFiles.ServicesImplementation.RelationServices;
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
public class addfriend extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user1 = (User) request.getSession().getAttribute("user");
        String idfrind = request.getParameter("id");
        User user2 = new User();
        user2.setId(Integer.parseInt(idfrind));
        // Connection of Database
        Connection connect = (Connection) getServletContext().getAttribute("Connect");
        // Object of class (DatabaseControl)
        RelationServices relationservices = new RelationServices();
        // Set connection Of Database
        relationservices.setConnection(connect);
        if (relationservices.relation(user1, user2) == 1) {
            response.sendRedirect("View/friend-finder/newsfeed.jsp");
        }
    }
}
