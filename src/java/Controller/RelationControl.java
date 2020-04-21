/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataBaseFiles.ServicesImplementation.RelationServices;
import Model.User;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Eng Eslam khder
 */
public class RelationControl {

    // Object Of Class DataBaseConnection
    private RelationServices relationservices;

    // Create new Object Of Class DataBaseConnection
    public RelationControl() {
        relationservices = new RelationServices();
    }

    // Set Connection of Database
    public void setConnection(Connection connection) {
        relationservices.setConnection(connection);
    }

    // Get Friends
    public ArrayList<User> getFriends(User us) {
        return relationservices.getFriends(us);
    }

    // Make Relation between users
    public int relation(User user1, User user2) {
        return relationservices.relation(user1, user2);
    }
}
