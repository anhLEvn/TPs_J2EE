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


public class ReadFileServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }
    public Carte initCarte(BufferedReader carteReader) throws IOException{
        String line = carteReader.readLine();
        String dataLine[] = line.split(":");
        int x = Integer.parseInt(dataLine[1]);
       
     int y = Integer.parseInt(dataLine[2]);
        
        int[][] inputCarte = new int[x][y];
        
        int i = 0; 
        Carte carte = new Carte(x,y); 
        while (((line = carteReader.readLine())!= null)){
            dataLine = line.split(":");
            for (int j = 1; j < dataLine.length; j++){
                inputCarte[i][j-1] = Integer.parseInt(dataLine[j]);
            }
            i++;
        }
        carte.setMatrix(inputCarte);
     return carte; 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Part filePart = request.getPart("file"); 
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream fileContent = filePart.getInputStream();
            BufferedReader carteReader = new BufferedReader(new InputStreamReader(fileContent));
            Carte carte = initCarte(carteReader);
            request.getSession().setAttribute("uploaded", true);
            request.getSession().setAttribute("carte", carte);
            response.sendRedirect("CarteVille.jsp");
       
        }
    }
}
