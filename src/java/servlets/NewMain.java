package servlets;


import Controller.Control_DB;
import Model.Comment;
import Model.Post;
import Model.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eng Eslam khder
 */
public class NewMain {
    
    public static void main(String[] args) {
//        User user = new User();
//        user.setEmail("e@e");
//        user.setPassword("1111");
        Control_DB control = new Control_DB();
        control.connect();
        Post post = new Post();
        post.setIdpost(5);
        try{
        post.setIdpost(5);
        ArrayList<Comment> comments = new ArrayList<>();
        comments = control.getComments(post);
        for(int i = 0; i< comments.size(); i++){
            JOptionPane.showMessageDialog(null, comments.get(i).getComment());
        }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
//        user = control.getUser(user);
//        JOptionPane.showMessageDialog(null,user.getId() );
//        JOptionPane.showMessageDialog(null,user.getName());
//        JOptionPane.showMessageDialog(null,user.getEmail());
//        JOptionPane.showMessageDialog(null,user.getPassword());
//        JOptionPane.showMessageDialog(null,user.getJob());
//        JOptionPane.showMessageDialog(null,user.getDistance());
//        if(control.add(user) == 1){
//            JOptionPane.showMessageDialog(null, "wow");
//        } else {
//            JOptionPane.showMessageDialog(null, "ops");
//        }
    }
    
}
