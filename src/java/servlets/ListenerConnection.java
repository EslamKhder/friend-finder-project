package servlets;

import Controller.Control_DB;
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
        Control_DB control_db = new Control_DB();
        sce.getServletContext().setAttribute("Connect", control_db.connect());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}