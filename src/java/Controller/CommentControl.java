/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataBaseFiles.ServicesImplementation.CommentServices;
import DataBaseFiles.ServicesImplementation.DataBaseConnection;
import Model.Post;
import Model.User;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Eng Eslam khder
 */
public class CommentControl {

    // Object Of Class DataBaseConnection
    private CommentServices commentservices;

    // Create new Object Of Class DataBaseConnection
    public CommentControl() {
        commentservices = new CommentServices();
    }
    
    // Set Connection of Database
    public void setConnection(Connection connection) {
        commentservices.setConnection(connection);
    }

    // Add Comment to Post
    public int addComment(User user, Post post, String comment) {
        return commentservices.addComment(user, post, comment);
    }

    // Get Comment of post
    public ArrayList getComments(Post post) {
        return commentservices.getComments(post);
    }
}
