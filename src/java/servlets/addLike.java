package servlets;

import DataBaseFiles.ServicesImplementation.LikeServices;
import Model.Post;
import Model.User;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addLike extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User user = (User) request.getSession().getAttribute("user");
            String idpost = request.getParameter("idpo");
            Connection connection = (Connection) getServletContext().getAttribute("Connect");
            Post post = new Post();
            post.setIdpost(Integer.parseInt(idpost));
            post.setIduser(user.getId());
            LikeServices likeservices = new LikeServices();
            likeservices.setConnection(connection);
            if (likeservices.checkLike(post) == 1) {
                likeservices.removeLike(user, post);
                response.getWriter().print("remove");
            } else {
                likeservices.addLike(user, post);
                response.getWriter().print("add");
            }
        } catch (Exception e) {
            response.sendRedirect("View/friend-finder/Log_In.jsp");
        }
        
        //response.sendRedirect("View/friend-finder/newsfeed.jsp");
    }
}
