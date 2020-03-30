package DataBaseFiles.ServicesInterface;

import Model.Post;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Eng Eslam khder
 */
public interface PostService {
    // This Function to set The Connection of DataBase
    public void setConnection(Connection connection);
    // Share Post
    public int sharePost(Post post);
    // Get All Post 
    public ArrayList<Post> getPosts();
}
