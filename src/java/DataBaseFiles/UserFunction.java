package DataBaseFiles;

import Model.Post;
import Model.User;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Eng Eslam khder
 */

// Interface That Include The Prototype of Function without body of it  
public interface UserFunction {
    // Connect with Data Base
    public Connection connect();
    // Add User Account
    public int add(User user);
    // Get User Account (All Attripute)
    User getUser(User user);
    // Share Post
    public int sharePost(Post post);
    // Get All Post 
    public ArrayList<Post> getPosts();
    // Get User Account (Only Name) 
    public User getUserName(User user);
    // Add Like to Post
    public int addLike(User user,Post post);
    // Get Number Of Likes in Any Post
    public int numberLikes(Post post);
    // Check If User like in Post or not
    public int checkLike(Post post);
    // Delete Like from Post
    public int removeLike(User user,Post post);
    // Add Comment to Post
    public int addComment(User user,Post post,String comment);
    // Get Comments of post
    public ArrayList getComments(Post post);
    // Check if User is in relation 
    public int getRelation(User user1,User user2);
    // Get Friends
    public ArrayList<User> getFriends(User user1);
    // Make Relation between users
    public int relation(User user1,User user2);
}
