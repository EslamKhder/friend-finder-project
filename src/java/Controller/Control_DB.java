package Controller;
import DataBaseFiles.DataBase;
import Model.Post;
import Model.User;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Eng Eslam khder
 */
/*
    This class to Control All function in DataBase
*/
public class Control_DB {
    // Object Of Class DataBase
    private DataBase database;
    
    // Create new Object Of Class DataBase
    public Control_DB() {
        database = new DataBase();
    }
    // Connect with Database
    public Connection connect() {
        return database.connect();
    }
    // Add User Account
    public int add(User user) {
        return database.add(user);
    }
    // function to set Connection of Database
    public void setConnecion(Connection connection){
        database.setConnection(connection);
    }
    // Get User Account (All Attripute)
    public User getUser(User user){
        return database.getUser(user);
    }
    // Share Post
    public int sharePost(Post post){
        return database.sharePost(post);
    }
    // Get All Post 
    public ArrayList<Post> getPosts() {
        return database.getPosts();
    }
    // Get User Account (Only Name) 
    public User getUserName(User user){
        return database.getUserName(user);
    }
    // Add Like to Post
    public int addLike(User user,Post post){
        return database.addLike(user, post);
    }
    // Get Number Of Likes in Any Post
    public int numberLikes(Post post) {
        return database.numberLikes(post);
    }
    // Check If User like in Post or not
    public int checkLike(Post post) {
        return database.checkLike(post);
    }
    // Delete Like from Post
    public int removeLike(User user,Post post){
        return database.removeLike(user, post);
    }
    // Add Comment to Post
    public int addComment(User user,Post post,String comment){
        return database.addComment(user, post,comment);
    }
    // Get Comment of post
    public ArrayList getComments(Post post){
        return database.getComments(post);
    }
    // Get Friends
    public ArrayList<User> getFriends(User us){
        return database.getFriends(us);
    }
    // Make Relation between users
    public int relation(User user1,User user2){
        return database.relation(user1, user2);
    }
}