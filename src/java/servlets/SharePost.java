package servlets;

import DataBaseFiles.ServicesImplementation.PostServices;
import Model.Post;
import Model.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
/**
 *
 * @author Eng Eslam khder
 */
@MultipartConfig
public class SharePost extends HttpServlet {
    private final static Logger LOGGER
            = Logger.getLogger(SharePost.class.getCanonicalName());
    private String image;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            String text = request.getParameter("texts");
            processRequest(request,response);
            if (text.isEmpty() && image.isEmpty()) {
                response.sendRedirect("View/friend-finder/newsfeed.jsp");
            } else {
//                processRequest(request,response);
                User user = (User) request.getSession().getAttribute("user");
                Connection connect = (Connection) getServletContext().getAttribute("Connect");
                PostServices postservices = new PostServices();
                postservices.setConnection(connect);
                Post post = new Post();
                post.setIduser(user.getId());
                post.setText(text);
                post.setImage(image);
                if (postservices.sharePost(post) == 1) {
                    response.sendRedirect("View/friend-finder/newsfeed.jsp");
                }
            }
        } catch (IOException | ServletException e) {
            response.sendRedirect("View/friend-finder/Log_In.jsp");
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Create path components to save the file
        final String path = "C:\\Users\\Eng Eslam khder\\Documents\\NetBeansProjects\\friend-project\\web\\View\\friend-finder\\pic";
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);
//        JOptionPane.showMessageDialog(null, fileName);
        image = fileName;
        OutputStream out = null;
        InputStream filecontent = null;
        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
//            writer.println("New file " + fileName + " created at " + path);
//            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
//                    new Object[]{fileName, path});
        } catch (FileNotFoundException fne) {
//            writer.println("You either did not specify a file to upload or are "
//                    + "trying to upload a file to a protected or nonexistent "
//                    + "location.");
//            writer.println("<br/> ERROR: " + fne.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }

        }
    }


    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}