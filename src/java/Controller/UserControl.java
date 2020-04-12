/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataBaseFiles.ServicesImplementation.UserServices;
import Model.User;
import java.sql.Connection;

/**
 *
 * @author Eng Eslam khder
 */
public class UserControl {

    // Object Of Class DataBaseConnection
    private UserServices userservices;

    // Create new Object Of Class DataBaseConnection
    public UserControl() {
        userservices = new UserServices();
    }
    // Set Connection of Database
    public void setConnection(Connection connection) {
        userservices.setConnection(connection);
    }
    // Get User ID
    public int getUserId(User user){
        return userservices.getUserId(user);
    }
    // Add User Account
    public int addUser(User user) {
        return userservices.add(user);
    }

    // Get User Account (All Attripute)
    public User getUser(User user) {
        return userservices.getUser(user);
    }

    // Get User Account (Only Name) 
    public User getUserName(User user) {
        return userservices.getUserName(user);
    }
}
