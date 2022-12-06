<%-- 
    Document   : checkout
    Created on : 24 nov. 2022, 19:17:45
    Author     : HP
--%>

<%@page import="entities.Panier"%>
<%@page import="service.PanierService"%>
<%@page import="entities.Facture"%>
<%@page import="entities.Client"%>
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
   <title>checkout</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="container">

<section class="checkout-form">

   <h1 class="heading">complete your order</h1>

   <form action="" method="post">

   

      <div class="flex">
         <div class="inputBox">
            <span>your name</span>
            <input type="text" placeholder="enter your name" name="name" required>
         </div>
         <div class="inputBox">
            <span>your number</span>
            <input type="number" placeholder="enter your number" name="number" required>
         </div>
         <div class="inputBox">
            <span>your email</span>
            <input type="email" placeholder="enter your email" name="email" required>
         </div>
         <div class="inputBox">
            <span>payment method</span>
            <select name="method">
               <option value="cash on delivery" selected>cash on devlivery</option>
               <option value="credit cart">credit cart</option>
               <option value="paypal">paypal</option>
            </select>
         </div>
         <div class="inputBox">
            <span>address line 1</span>
            <input type="text" placeholder="adress 1" name="flat" required>
         </div>
         <div class="inputBox">
            <span>address line 2</span>
            <input type="text" placeholder="adress 2" name="street" required>
         </div>
         <div class="inputBox">
            <span>city</span>
            <input type="text" placeholder="city" name="city" required>
         </div>
         <div class="inputBox">
            <span>state</span>
            <input type="text" placeholder="state" name="state" required>
         </div>
         <div class="inputBox">
            <span>country</span>
            <input type="text" placeholder="country" name="country" required>
         </div>
         <div class="inputBox">
            <span>pin code</span>
            <input type="text" placeholder="oin code" name="pin_code" required>
         </div>
      </div>
       
         <%! int total = 0;%>
                <%
                   
                    PanierService pn = new PanierService();
                    if (pn.findAll() != null) {
                        for (Panier p : pn.findAll()) {
                           if (p.getClient().getId() == c.getId()){
                            total += p.getQte() * p.getProduit().getPrix();

                %>
                 <%    }}}
                    %>
       <a href="./CommandeController?client=<%= c.getId()%>&total=<%= total%> " class="btn" >order now</a>
      
   </form>

</section>

</div>

<!-- custom js file link  -->
<script src="js/script.js"></script>
   
</body>
</html>
