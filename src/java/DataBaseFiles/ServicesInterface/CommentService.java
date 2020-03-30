package DataBaseFiles.ServicesInterface;

import Model.Post;
import Model.User;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Eng Eslam khder
 */
public interface CommentService {
    // This Function to set The Connection of DataBase
    public void setConnection(Connection connection);
    // Add Comment to Post
    public int addComment(User user,Post post,String comment);
    // Get Comments of post
    public ArrayList getComments(Post post);
}
