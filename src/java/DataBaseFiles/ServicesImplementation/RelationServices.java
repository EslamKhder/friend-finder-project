package DataBaseFiles.ServicesImplementation;

import DataBaseFiles.ServicesInterface.RelationService;
import Model.User;
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
public class RelationServices implements RelationService {

    private PreparedStatement preparedstatement = null;
    private String instraction = null;
    private int result = 0;
    private Connection connection = null;

    // Set Connection of Database
    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    // Check if User is in relation 
    @Override
    public int getRelation(User user1, User user2) {
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
                        || getRelation(user1, user2) == 1) {
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
