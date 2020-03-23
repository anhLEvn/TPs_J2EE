/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpGame;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vanan
 */
public class VerifyPage extends HttpServlet {
   
  
      
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


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         String nom = request.getParameter("nomLogin");
         String pw = request.getParameter("motDePasse");
                 
        // init hashMap
        HashMap loginList;
        loginList = new HashMap();
        // add elements to hashMap
        loginList.put("meyer", new Joueur("Meyer", "Luc",30, "meyer", "1111"));
        loginList.put("dupont", new Joueur("Dupont", "René",40, "dupont", "2222"));
        loginList.put("legrand", new Joueur("Legrand", "Lisa",16, "legrand", "3333"));
       
        if(((Joueur)loginList.get(nom)).getLoginName()!= null && ((Joueur)loginList.get(nom)).getPassword()!= null) {  
           //if(nom.equals(((Joueur)loginList.get(nom)).getLoginName()) && pw.equals(((Joueur)loginList.get(nom)).getPassword())){            
                if(((Joueur)loginList.get(nom)).getAge()>=18){
                response.sendRedirect("Welcome.jsp");
                }else{
                     out.println("Vous êtes moins 18 ans. Pas autorisé!");      
                }
             }else{
                out.println("Nom ou mot de passe invalidé. Resaisir svp!");
                response.sendRedirect("index.html");
             }
        /*}else{ 
          out.println("Nom ou mot de passe vide . Resaisir svp!");
          response.sendRedirect("index.html");
         }*/
        
        }
    }
}
//out.println("Nom du joueur:" + (Joueur)loginList.get(nom));
        /*if(((Joueur)loginList.get(nom))!= null && ((Joueur)loginList.get(pw)!=null)){    
            if(((Joueur)loginList.get(nom)).getAge()>18){
                response.sendRedirect("Welcome.jsp");
            }else{
            out.println("pas autorisé Nom ou mot de passse incorectée");
            }
             //RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
            //rd.forward(request, response);
            }else{ 
          out.println("Nom ou mot de passse vide");
             RequestDispatcher rd = request.getRequestDispatcher("index.html");
          rd.include(request, response);
         }
        }*/