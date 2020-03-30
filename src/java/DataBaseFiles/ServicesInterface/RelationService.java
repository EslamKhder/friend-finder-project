package DataBaseFiles.ServicesInterface;

import Model.User;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Eng Eslam khder
 */
public interface RelationService {

    // This Function to set The Connection of DataBase
    public void setConnection(Connection connection);

    // Check if User is in relation 
    public int getRelation(User user1, User user2);

    // Get Friends
    public ArrayList<User> getFriends(User user1);

    // Make Relation between users
    public int relation(User user1, User user2);
}
