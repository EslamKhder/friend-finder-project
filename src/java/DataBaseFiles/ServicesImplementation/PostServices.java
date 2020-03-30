package DataBaseFiles.ServicesImplementation;

import DataBaseFiles.ServicesInterface.PostService;
import Model.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Eng Eslam khder
 */
public class PostServices implements PostService {

    private Connection connection = null;
    private PreparedStatement preparedstatement = null;
    private String instraction = null;
    private int result = 0;

    // Set Connection of Database
    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    // Share Post of User

    @Override
    public int sharePost(Post post) {
        instraction = "INSERT INTO POST (IDUser, Text, Attachment) values (?, ?, ?)";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setInt(1, post.getIduser());
            preparedstatement.setString(2, post.getText());
            preparedstatement.setString(3, post.getImage());
            result = preparedstatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Because " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    // Get All Posts
    @Override
    public ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        instraction = "SELECT * FROM POST";

        try {
            preparedstatement = connection.prepareStatement(instraction);
            ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                Post post = new Post();
                post.setIduser(resultset.getInt(1));
                post.setIdpost(resultset.getInt(2));
                post.setText(resultset.getString(3));
                post.setImage(resultset.getString(4));
                posts.add(post);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Because " + e.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return posts;
    }
}
