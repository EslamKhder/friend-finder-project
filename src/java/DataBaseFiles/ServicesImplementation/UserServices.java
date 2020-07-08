package DataBaseFiles.ServicesImplementation;

import DataBaseFiles.ServicesInterface.UserService;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eng Eslam khder
 */
public class UserServices implements UserService {

    private PreparedStatement preparedstatement = null;
    private String instraction = null;
    private int result = 0;
    private Connection connection = null;

    // Set Connection of Database
    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    // Get User ID
    @Override
    public int getUserId(User user){
        instraction = "SELECT id FROM log_in WHERE email = ? and password = ?";
        int id = 0;
        try {
            preparedstatement = connection.prepareStatement(instraction);
            preparedstatement.setString(1, user.getEmail());
            preparedstatement.setString(2, user.getPassword());
            ResultSet resultset = preparedstatement.executeQuery();
            if (resultset.next()) {
                id = resultset.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
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
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
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
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}