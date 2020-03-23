/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Controller.Control_DB;
import Model.Post;
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
public class addComment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String comment = request.getParameter("comment"),
                idpost = request.getParameter("id");
        User user = null;
        user = (User) request.getSession().getAttribute("user");
        Connection connection = (Connection) getServletContext().getAttribute("Connect");
        Post post = new Post();
        post.setIdpost(Integer.parseInt(idpost));
        Control_DB control_db = new Control_DB();
        control_db.setConnecion(connection);
        control_db.addComment(user, post,comment);
        response.sendRedirect("View/friend-finder/newsfeed.jsp");
    }
}