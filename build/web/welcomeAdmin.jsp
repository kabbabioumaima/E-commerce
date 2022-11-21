<%-- 
    Document   : welcomeAdmin
    Created on : 18 nov. 2022, 22:45:51
    Author     : lenovo
--%>

<%@page import="entities.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome</title>
    </head>
    <body>
        <%!Admin c ;%>
        <%
         
        HttpSession sessio = request.getSession();
        if (sessio != null) {
             c = (Admin) sessio.getAttribute("admin");
        }
        else{
            response.sendRedirect("login.jsp");
        }
        %>
        <h1>Welcome MR </h1>
        <form action="deconnexion">
            <input type="submit" value="deconnixion">
        </form>

    </body>
</html>
