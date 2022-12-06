<%-- 
    Document   : welcomeClient
    Created on : 18 nov. 2022, 22:45:51
    Author     : lenovo
--%>

<%@page import="entities.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome</title>
    </head>
    <body>
        <%!Client c ;%>
        <%
         
        HttpSession sessio = request.getSession();
        if (sessio != null) {
             c = (Client) sessio.getAttribute("client");
        }
        else{
            response.sendRedirect("loginClient.jsp");
        }
        %>
       <h1>Welcome MR : <%= c.getNom() + " " + c.getPrenom()%> </h1>
        <form action="deconnexion">
            <input type="submit" value="deconnixion">
        </form>

    </body>
</html>
