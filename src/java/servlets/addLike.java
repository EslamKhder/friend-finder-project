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

public class addLike extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idpost = request.getParameter("id");
        User user = null;
        user = (User) request.getSession().getAttribute("user");
        Connection connection = (Connection) getServletContext().getAttribute("Connect");
        Post post = new Post();
        post.setIdpost(Integer.parseInt(idpost));
        post.setIduser(user.getId());
        Control_DB control_db = new Control_DB();
        control_db.setConnecion(connection);
        if (control_db.checkLike(post) == 1) {
            control_db.removeLike(user, post);
        } else {
            control_db.addLike(user, post);
        }
        response.sendRedirect("View/friend-finder/newsfeed.jsp");
    }
}
