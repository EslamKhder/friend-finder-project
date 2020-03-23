/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Controller.Control_DB;
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
public class addfriend extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            User user1 = (User) request.getSession().getAttribute("user");
            JOptionPane.showMessageDialog(null, user1.getId() + " ");
            String idfrind = request.getParameter("id");
            User user2 = new User();
            user2.setId(Integer.parseInt(idfrind));
            JOptionPane.showMessageDialog(null, idfrind + " ");
            // Connection of Database
            Connection connect = (Connection) getServletContext().getAttribute("Connect");
            // Object of class (Control_DB)
            Control_DB control_db = new Control_DB();
            // Set connection Of Database
            control_db.setConnecion(connect);
            if (control_db.relation(user1, user2) == 1) {
                response.sendRedirect("View/friend-finder/newsfeed.jsp");
            }
    }
}
