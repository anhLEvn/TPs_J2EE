<%-- 
    Document   : CarteVille
    Created on : Mar 23, 2020, 4:09:47 PM
    Author     : vanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="TpGame.Board" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carte De La Ville</title>
    </head>
    <body>
        <form method = "post" action ="SaveFileServlet" enctype ="multipart/form-data"> 
        <div style = "width:450px; height: 700px; top: 50px; bottom: auto; 
             margin-left:auto; margin-right: auto; border:5px; background: antiquewhite">
        <br>
        <h2> Capturez Monsieur X </h2>        
            <a style="float:right" href = "Welcome.jsp">Retour à l'acceuil </a>
            <br>
        <p></p>
        <input type ="file" name ="file" value = "Percourir"/><br>
        <p></p>
        <input type ="submit" name ="submit" value = "Chargez"/>
        <div>
            <%
                boolean checkUpload = (Boolean) request.getSession().getAttribute("uploaded");
                if (checkUpload){
                    Board b = (Board) request.getSession().getAttribute("board");
                    int x = b.getX(); int y = b.getY();
                    
                    for (int i=0;i<x;i++) {
                        for (int j =0;j<y;j++){
                            out.print(b.matrix[i][j] + " ");
                        }
                       out.println("<br>");
                    }
                    
                }
            %>
             
        </div>
        </div> 
            
        </form>
     
       
    </body>
</html>
