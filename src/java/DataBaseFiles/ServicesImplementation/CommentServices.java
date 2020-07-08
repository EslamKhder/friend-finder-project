package DataBaseFiles.ServicesImplementation;

import DataBaseFiles.ServicesInterface.CommentService;
import Model.Comment;
import Model.Post;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eng Eslam khder
 */
public class CommentServices implements CommentService {

    private PreparedStatement preparedstatement = null;
    private String instraction = null;
    private int result = 0;
    private Connection connection = null;

    // Set Connection of Database
    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // Add Comment to Post
    @Override
    public int addComment(User user, Post post, String comment) {
        instraction = "INSERT INTO COMMENT (IDEmail,IDPost,Comment) values (?,?,?)";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setInt(1, user.getId());
            preparedstatement.setInt(2, post.getIdpost());
            preparedstatement.setString(3, comment);
            result = preparedstatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    // Get Comments of post
    @Override
    public ArrayList<Comment> getComments(Post post) {
        ArrayList<Comment> comments = new ArrayList();

        instraction = "SELECT * FROM comment WHERE IDPost = ?";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setInt(1, post.getIdpost());
            ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                Comment comment = new Comment();
                comment.setIduser(resultset.getInt(1));
                comment.setComment(resultset.getString(3));
                comments.add(comment);
            }
        } catch (SQLException e) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return comments;
    }

}
