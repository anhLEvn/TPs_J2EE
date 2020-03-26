<%-- 
    Document   : CarteVille
    Created on : Mar 23, 2020, 4:09:47 PM
    Author     : vanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carte De La Ville</title>
    </head>
    <body>
        <form method = "post" action ="SaveFileServlet" enctype ="multipar/form-data"> 
        <div style = "width:450px; height: 700px; top: 50px; bottom: auto; 
             margin-left:auto; margin-right: auto; border:5px; background: antiquewhite">
        <br>
        <h2> Capturez Monsieur X </h2>        
            <a style="float:right" href = "Welcome.jsp">Retour à l'acceuil </a>
            <br>
        <p></p>
        <input type ="file" name ="userfile" value = "Percourir"/><br>
        <p></p>
        <input type ="submit" name ="submit" value = "Chargez"/>
        </div> 
        </form>
    </body>
</html>
