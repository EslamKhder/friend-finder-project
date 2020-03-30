package DataBaseFiles.ServicesImplementation;

import DataBaseFiles.ServicesInterface.DatabaseService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Eng Eslam khder
 */

public class DataBaseConnection implements DatabaseService {

    private final String DRIVER = "com.mysql.jdbc.Driver",
            URL = "jdbc:mysql://localhost:3306/frind frinder",
            USERNAME = "root",
            PASSWORD = "";
    private Connection connection = null;

    @Override
    // Connection With DataBaseConnection
    public Connection connect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(
                    URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection Error Because " + e.toString(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
}
