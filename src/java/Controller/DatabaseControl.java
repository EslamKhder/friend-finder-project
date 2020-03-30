package Controller;


import DataBaseFiles.ServicesImplementation.DataBaseConnection;
import java.sql.Connection;

/**
 *
 * @author Eng Eslam khder
 */
/*
    This class to Control All function in DataBaseConnection
 */
public class DatabaseControl {
    // Object Of Class DataBaseConnection
    private DataBaseConnection database;

    // Create new Object Of Class DataBaseConnection
    public DatabaseControl() {
        database = new DataBaseConnection();
    }

    // Connect with Database
    public Connection connect() {
        return database.connect();
    }
}
