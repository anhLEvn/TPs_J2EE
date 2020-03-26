/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TpGame;

import java.io.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;


/**
 *
 * @author vanan
 */
@WebServlet(name = "SaveFileServlet", urlPatterns = {"/SaveFileServlet"})
public class SaveFileServlet extends HttpServlet {
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    public Board initBoard(BufferedReader br) throws IOException{
        String line = br.readLine();
         String dataLine[] = line.split(":");
         int x = Integer.parseInt(dataLine[1]); 
         int y = Integer.parseInt(dataLine[2]);
         Integer[][] b = new Integer[x][y];
         int i=0;
         Board board = new Board(x,y);
		while ((line = br.readLine()) != null) {
                    dataLine = line.split(":");
                    for (int j=1;j<dataLine.length;j++){
                        b[i][j-1] = Integer.parseInt(dataLine[j]);
                    }
                    i++;
		}
        board.setMatrix(b);
         return board;
    }
 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       processRequest(request, response);
         Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
         String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
         InputStream fileContent = filePart.getInputStream();
         BufferedReader br = new BufferedReader(new InputStreamReader(fileContent));
	 Board b = initBoard(br);
         request.getSession().setAttribute("uploaded", true);
         request.getSession().setAttribute("board", b);
         response.sendRedirect("CarteVille.jsp");
        
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

