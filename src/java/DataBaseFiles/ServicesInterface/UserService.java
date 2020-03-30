package DataBaseFiles.ServicesInterface;

import Model.User;
import java.sql.Connection;

/**
 *
 * @author Eng Eslam khder
 */
public interface UserService {

    // This Function to set The Connection of DataBase
    public void setConnection(Connection connection);

    // Add User Account
    public int add(User user);

    // Get User Account (All Attripute)
    User getUser(User user);

    // Get User Account (Only Name) 
    public User getUserName(User user);
}
