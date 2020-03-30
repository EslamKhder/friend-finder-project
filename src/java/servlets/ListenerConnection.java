package servlets;

import Controller.DatabaseControl;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Eng Eslam khder
 */
public class ListenerConnection implements ServletContextListener {
    // This is Listener to get Connection only one to Connect with Database

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DatabaseControl control_db = new DatabaseControl();
        sce.getServletContext().setAttribute("Connect", control_db.connect());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}