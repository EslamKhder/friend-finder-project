package DataBaseFiles;
import Model.Comment;
import Model.Post;
import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Eng Eslam khder
 */

/* 
 This class implements of UserFunction(interface)
 and include all Query in DataBase
 */
public class DataBase implements UserFunction {
    private final String DRIVER = "com.mysql.jdbc.Driver",
            URL = "jdbc:mysql://localhost:3306/frind frinder",
            USERNAME = "root",
            PASSWORD = "";
    private Connection connection = null;
    private PreparedStatement preparedstatement = null;
    private String instraction = null;
    private int result = 0;

    @Override
    // Connection With DataBase
    public Connection connect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(
                    URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection Error Because " + e.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }

    // This Function to set The Connection of DataBase
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // Add User To Data Base
    @Override
    public int add(User user) {
        instraction = "INSERT INTO LOG_IN (name, email, password, job, distance) values (?, ?, ?, ?, ?)";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setString(1, user.getName());
            preparedstatement.setString(2, user.getEmail());
            preparedstatement.setString(3, user.getPassword());
            preparedstatement.setString(4, user.getJob());
            preparedstatement.setInt(5, user.getDistance());
            result = preparedstatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Email is already use " + e.getMessage(), "Error Input",
                    JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    // Get User from Database
    @Override
    public User getUser(User user) {
        instraction = "SELECT * FROM log_in WHERE email = ? and password = ?";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setString(1, user.getEmail());
            preparedstatement.setString(2, user.getPassword());
            ResultSet resultset = preparedstatement.executeQuery();
            if (resultset.next()) {
                user.setId(resultset.getInt(1));
                user.setName(resultset.getString(2));
                user.setEmail(resultset.getString(3));
                user.setPassword(resultset.getString(4));
                user.setJob(resultset.getString(5));
                user.setDistance(resultset.getInt(6));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid email and Password",
                        "Connection Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Because " + e.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return user;
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

    // Get User Account (Only Name) 
    @Override
    public User getUserName(User user) {
        instraction = "SELECT NAME FROM log_in WHERE ID = ?";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setInt(1, user.getId());
            ResultSet resultset = preparedstatement.executeQuery();
            if (resultset.next()) {
                user.setName(resultset.getString(1));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid email and Password",
                        "Connection Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Because " + e.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return user;
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
            JOptionPane.showMessageDialog(null, "Error Because " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Error Because " + e.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return comments;
    }

    // Check if User is in relation 

    @Override
    public int getRelation(User user1,User user2) {
        instraction = "SELECT * FROM Relation Where IDEMAIL = ? AND IDFriend = ?";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setInt(1, user1.getId());
            preparedstatement.setInt(2, user2.getId());
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

    // Get Friends

    @Override
    public ArrayList<User> getFriends(User user1) {
        ArrayList<User> users = new ArrayList();
        instraction = "SELECT ID,NAME FROM log_in";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            ResultSet resultset = preparedstatement.executeQuery();
            while (resultset.next()) {
                User user2 = new User();
                user2.setId(resultset.getInt(1));
                if (resultset.getInt(1) == user1.getId()
                        || getRelation(user1,user2) == 1) {
                    continue;
                }
                User user = new User();
                user.setId(resultset.getInt(1));
                user.setName(resultset.getString(2));
                users.add(user);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Because " + e.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return users;
    }

    // Make Relation between users
    @Override
    public int relation(User user1, User user2) {
        instraction = "INSERT INTO RELATION (IDEmail,IDFriend) values (?,?)";
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setInt(1, user1.getId());
            preparedstatement.setInt(2, user2.getId());
            result = preparedstatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Because " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }
}