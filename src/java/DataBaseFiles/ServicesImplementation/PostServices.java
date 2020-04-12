package DataBaseFiles.ServicesImplementation;

import DataBaseFiles.ServicesInterface.PostService;
import Model.Post;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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

    //Get Frind Post
    public ArrayList<Integer> getIdUserPost(User user) {
        ArrayList<Integer> list = new ArrayList<>();
        instraction = "SELECT IDFriend FROM relation where IDEmail = ?";

        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setInt(1, user.getId());
            ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                list.add(resultset.getInt(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Because " + e.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    // Get All Posts
    @Override
    public ArrayList<Post> getPosts(User user) {
        ArrayList<Integer> ids = getIdUserPost(user);
        ArrayList<Post> posts = new ArrayList<>();
        instraction = "SELECT * FROM POST where IDUser = ?";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setInt(1, user.getId());
            ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                Post post = new Post();
                post.setIduser(resultset.getInt(1));
                post.setIdpost(resultset.getInt(2));
                post.setText(resultset.getString(3));
                post.setImage(resultset.getString(4));
                posts.add(post);
            }
            for (int i = 0; i < ids.size(); i++) {
                instraction = "SELECT * FROM POST where IDUser = ?";
                preparedstatement = connection.prepareStatement(instraction);
                preparedstatement.setInt(1, ids.get(i));
                resultset = preparedstatement.executeQuery();
                if (resultset.next()) {
                    Post post = new Post();
                    post.setIduser(resultset.getInt(1));
                    post.setIdpost(resultset.getInt(2));
                    post.setText(resultset.getString(3));
                    post.setImage(resultset.getString(4));
                    posts.add(post);
                }

            }
            Collections.reverse(posts);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Because 1" + e.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return posts;
    }
}
