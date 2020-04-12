/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataBaseFiles.ServicesImplementation.DataBaseConnection;
import DataBaseFiles.ServicesImplementation.PostServices;
import Model.Post;
import Model.User;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Eng Eslam khder
 */
public class PostControl {

    // Object Of Class DataBaseConnection
    private PostServices postservices;

    public PostControl() {
        postservices = new PostServices();
    }

    // Set Connection of Database
    public void setConnection(Connection connection) {
        postservices.setConnection(connection);
    }
    // Create new Object Of Class DataBaseConnection

    // Share Post
    public int sharePost(Post post) {
        return postservices.sharePost(post);
    }

    // Get All Post 
    public ArrayList<Post> getPosts(User user) {
        return postservices.getPosts(user);
    }
}
