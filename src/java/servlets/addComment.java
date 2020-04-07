package servlets;

import DataBaseFiles.ServicesImplementation.CommentServices;
import Model.Post;
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
public class addComment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String comment = request.getParameter("comment"),
                idpost = request.getParameter("id");
        if (comment.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You must fill the Comment", "invalid",
                    JOptionPane.ERROR_MESSAGE);
            response.sendRedirect("View/friend-finder/newsfeed.jsp");
        } else {
            User user = null;
            user = (User) request.getSession().getAttribute("user");
            Connection connection = (Connection) getServletContext().getAttribute("Connect");
            Post post = new Post();
            post.setIdpost(Integer.parseInt(idpost));
            CommentServices commentservices = new CommentServices();
            commentservices.setConnection(connection);
            commentservices.addComment(user, post, comment);
            response.sendRedirect("View/friend-finder/newsfeed.jsp");
        }
    }
}
