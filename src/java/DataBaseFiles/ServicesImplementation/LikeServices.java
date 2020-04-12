package DataBaseFiles.ServicesImplementation;

import DataBaseFiles.ServicesInterface.Likeservice;
import Model.Post;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Eng Eslam khder
 */
public class LikeServices implements Likeservice {

    private PreparedStatement preparedstatement = null;
    private String instraction = null;
    private int result = 0;
    private Connection connection = null;

    // Set Connection of Database
    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // Add Like to Post
    @Override
    public int addLike(User user, Post post) {
        instraction = "INSERT INTO likepost (IDEmail,IDPost) values (?,?)";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setInt(1, user.getId());
            preparedstatement.setInt(2, post.getIdpost());
            result = preparedstatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Because " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    // Get Number Of Likes in Any Post
    @Override
    public int numberLikes(Post post) {
        instraction = "SELECT COUNT(IDPost) FROM likepost where IDPost = ?";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setInt(1, post.getIdpost());
            ResultSet resultset = preparedstatement.executeQuery();
            if (resultset.next()) {
                result = resultset.getInt(1);
            } else {
                result = 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Because " + e.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    // Check If User like in Post or not
    @Override
    public int checkLike(Post post) {
        instraction = "SELECT * FROM likepost where IDEmail = ? AND IDPost = ?";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setInt(1, post.getIduser());
            preparedstatement.setInt(2, post.getIdpost());
            ResultSet resultset = preparedstatement.executeQuery();
            if (resultset.next()) {
                result = 1;
            } else {
                result = 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Because " + e.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    // Delete Like from Post
    @Override
    public int removeLike(User user, Post post) {
        instraction = "DELETE FROM likepost WHERE IDEmail = ? AND IDPost = ?";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setInt(1, user.getId());
            preparedstatement.setInt(2, post.getIdpost());
            result = preparedstatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Because " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

}