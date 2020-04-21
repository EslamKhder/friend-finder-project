/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataBaseFiles.ServicesImplementation.LikeServices;
import Model.Post;
import Model.User;
import java.sql.Connection;

/**
 *
 * @author Eng Eslam khder
 */
public class LikeControl {

    // Object Of Class DataBaseConnection
    private LikeServices likeservices;

    // Set Connection of Database
    public void setConnection(Connection connection) {
        likeservices.setConnection(connection);
    }
    // Create new Object Of Class DataBaseConnection
    public LikeControl() {
        likeservices = new LikeServices();
    }

    // Add Like to Post
    public int addLike(User user, Post post) {
        return likeservices.addLike(user, post);
    }

    // Get Number Of Likes in Any Post
    public int numberLikes(Post post) {
        return likeservices.numberLikes(post);
    }

    // Check If User like in Post or not
    public int checkLike(Post post) {
        return likeservices.checkLike(post);
    }

    // Delete Like from Post
    public int removeLike(User user, Post post) {
        return likeservices.removeLike(user, post);
    }
}
