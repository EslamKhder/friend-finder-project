package DataBaseFiles.ServicesInterface;

import Model.Post;
import Model.User;
import java.sql.Connection;

/**
 *
 * @author Eng Eslam khder
 */
public interface Likeservice {
    // This Function to set The Connection of DataBase
    public void setConnection(Connection connection);    
    // Add Like to Post
    public int addLike(User user,Post post);
    // Get Number Of Likes in Any Post
    public int numberLikes(Post post);
    // Check If User like in Post or not
    public int checkLike(Post post);
    // Delete Like from Post
    public int removeLike(User user,Post post);
}
