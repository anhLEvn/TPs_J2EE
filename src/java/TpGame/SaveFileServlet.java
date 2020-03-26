
package TpGame;

import java.io.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vanan
 */
public class SaveFileServlet extends HttpServlet {
    private boolean isMultipart; 
    private String filePath;
    private File file; 
    
    public void init(){
        // location pour ranger les fichier
        filePath = getServletContext().getInitParameter("userfile");
    }
 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request, response);
       response.setContentType("text/html;charset=UTF-8");
      //  isMultipart = ServletFileUpload.isMutipartContent(request);
        try (PrintWriter out = response.getWriter()) {
           
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
