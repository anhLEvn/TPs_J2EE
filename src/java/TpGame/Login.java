/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpGame;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vanan
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         String nom = request.getParameter("nomLogin");
         String pw;
            pw = request.getParameter("motDePasse");
                 
        // init hashMap
        HashMap loginList;
        loginList = new HashMap <String,Joueur>();
        // add elements to hashMap
        loginList.put("meyer", new Joueur("Meyer", "Luc",30, "meyer", "1111"));
        loginList.put("dupont", new Joueur("Dupont", "René",40, "dupont", "2222"));
        loginList.put("legrand", new Joueur("Legrand", "Lisa",16, "legrand", "3333"));
         request.getSession().setAttribute("uploaded", false);
        Joueur j = (Joueur)loginList.get(nom);
        if(j.getLoginName()!= null && j.getPassword()!= null) {  
           if(j.getPassword().equals(pw)){
                if((j.getAge())>=18){
                    request.getSession().setAttribute("nom", j.getFirstname());
                response.sendRedirect("Welcome.jsp");
                }else{
                     out.println("Vous êtes moins 18 ans. Pas autorisé!");      
                }
             }else{
                out.println("Nom ou mot de passe invalidé. Resaisir svp!");
                response.sendRedirect("index.html");
             }
        }else{ 
          out.println("Nom ou mot de passe vide . Resaisir svp!");
          response.sendRedirect("index.html");
         }
        
        }
    }
}
    