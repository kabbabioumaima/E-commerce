<%-- 
    Document   : carte
    Created on : 24 nov. 2022, 14:29:25
    Author     : HP
--%>

<%@page import="entities.Client"%>
<%@page import="service.PanierService"%>
<%@page import="entities.Panier"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
		    
    Client c = (Client)session.getAttribute("client");
                    
		%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>shopping cart</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/style.css">
<style>
body {
  background-image: url('bac.jpg');
}
img {
                width : 170px;
                height : 150px;
            }
checkout-btn {
  width: 90%;
     }
</style>
</head>
<body>



<div class="container">

<section class="shopping-cart">

   <h1 class="heading">shopping cart</h1>

   <table>

      <thead>
         <th>image</th>
         <th>name</th>
         <th>price</th>
         <th>quantity</th>
         <th>total price</th>
      </thead>

      <tbody>

         <% int total = 0;%>
                <%
                   
                    PanierService pn = new PanierService();
                    if (pn.findAll() != null) {
                        for (Panier p : pn.findAll()) {
                           if (p.getClient().getId() == c.getId()){
                            total += p.getQte() * p.getProduit().getPrix();

                %>

         <tr>
          
            
             <td><img src=<%="images\\" + p.getProduit().getImage()%>></td>
            <td><%= p.getProduit().getNom()  %></td>
            <td><%= p.getProduit().getPrix()%></td>
            <td>  <%= p.getQte()%> </td>
            <td><%= p.getQte() * p.getProduit().getPrix()%></td>
            <td><a href="./DeletePanier?id=<%=p.getId()%>" onclick="return confirm('remove item from panier?')" class="delete-btn"> <i class="fas fa-trash"></i> remove</a></td>
<% }%>
         </tr>
       <%    }}
                    %>
         
         <tr class="table-bottom">
            <td><a href="catalogue.jsp" class="option-btn" style="margin-top: 0;">continue shopping</a></td>
            <td colspan="3">grand total</td>
            <td><%=total%></td>
            
         </tr>

      </tbody>

   </table>

   <div class="checkout-btn">
       <button><a href="checkout.jsp" class="option-btn">procced to checkout</a></button>
   </div>

</section>

</div>
   
<!-- custom js file link  -->
<script src="js/script.js"></script>

</body>
</html>