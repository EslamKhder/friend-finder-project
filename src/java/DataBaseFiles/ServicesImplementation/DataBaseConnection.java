package DataBaseFiles.ServicesImplementation;

import DataBaseFiles.ServicesInterface.DatabaseService;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.ibatis.jdbc.ScriptRunner;

/**
 *
 * @author Eng Eslam khder
 */
public class DataBaseConnection implements DatabaseService {

    private final String DRIVER = "com.mysql.jdbc.Driver",
            USERNAME = "root",
            PASSWORD = "";
    private String URL = "jdbc:mysql://localhost:3306";
    private Connection connection = null;

    @Override
    // Connection With DataBaseConnection
    public Connection connect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(
                    URL, USERNAME, PASSWORD);
            String aSQLScriptFilePath ="C:\\Users\\Eng Eslam khder\\Documents\\NetBeansProjects\\friend-project\\Table\\AllTable.sql";
            
            // Initialize object for ScripRunner
            ScriptRunner sr = new ScriptRunner(connection, false, false);
            // Give the input file to Reader
            Reader reader = new BufferedReader(
                    new FileReader(aSQLScriptFilePath));
            // Exctute script
            sr.runScript(reader);
            URL = "jdbc:mysql://localhost:3306/frindfrinder";
            connection = DriverManager.getConnection(
                    URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection Error Because " + e.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error Because " + ex.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.toString());
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
