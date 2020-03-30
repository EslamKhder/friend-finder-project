package DataBaseFiles.ServicesInterface;

import java.sql.Connection;

/**
 *
 * @author Eng Eslam khder
 */
public interface DatabaseService {
    // Connect with Data Base
    public Connection connect();
}
