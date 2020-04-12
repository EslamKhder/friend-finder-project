
import Controller.DatabaseControl;
import Controller.PostControl;
import Model.User;
import java.util.regex.Pattern;
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

    /**
     * @param args the command line arguments
     */
    
    public static boolean valEmail(String input) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,3}$";
        Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
        return emailPat.matcher(input).find();
    }
    public static void main(String[] args) {
        String input = "eslam@eslam.oom";
        System.out.println(valEmail(input));
//        DatabaseControl d = new DatabaseControl();
//        
//        PostControl postc = new PostControl();
//        postc.setConnection(d.connect());
//        User user = new User();
//        user.setId(1);
//        JOptionPane.showMessageDialog(null, postc.getPosts(user).size());
    }
    
}
