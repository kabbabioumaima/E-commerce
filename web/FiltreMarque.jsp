<%-- 
    Document   : prod
    Created on : 20 nov. 2022, 18:11:39
    Author     : hp
--%>

<%@page import="entities.Marque"%>
<%@page import="service.MarqueService"%>
<%@page import="entities.Client"%>
<%@page import="service.PanierService"%>
<%@page import="entities.Panier"%>
<%@page import="entities.Produit"%>
<%@page import="service.ProduitService"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
		    
    Client c = (Client)session.getAttribute("client");
                    
		%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js" type="text/javascript"></script>
        <script src="http://nicesnippets.com/demo/jsCarousel-2.0.0.js" type="text/javascript"></script>
        <link href="custom.css" rel="stylesheet" type="text/css" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <style>
            body{
                font-family: 'Raleway', sans-serif;
                background-color:#87CEEB;
                margin: 0px;
            }
            body h1.title{
                text-align: center;
                color: #fff;
            }
            .visible{
                display: block;
            }
            .hidden{
                display: none;
            }
            .product-box{
                background-color: #f1f1f1;
                text-align: center;
            }
            .product-desc{
                font-weight: bold;
                padding: 10px 0px;
            }
            .product-desc h5{
                margin: 0;
                color: #446AAF;
                font-size: 16px;
            }
            .product-desc p{
                color: #3C3F39;
                margin: 10px 0px 8px;
            }
            .product-desc button{
                padding: 5px 15px;
                border-radius: 7px;
                border: 1px solid #c1c1c1;
                font-weight: bold;
                color: #2868AF;
                background: linear-gradient(#FAFDFF, #E8E8E8);
                background: -moz-linear-gradient(#FAFDFF, #E8E8E8);
                background: -webkit-linear-gradient(#FAFDFF, #E8E8E8);
                cursor: pointer;
                font-family: 'Raleway', sans-serif;
            }
            .jscarousal-horizontal{
                width: 90%;
                overflow: hidden;
                height: 400px;
                padding: 30px 30px;
                position: absolute;
                left: 50%;
                top: 60%;
                transform: translate(-50%, -50%);
            }
            .jscarousal-horizontal-back, .jscarousal-horizontal-forward{
                float: left;
                width: 23px;
                position: relative;
                top: 50px;
                cursor: pointer;
                color: #5D5D5D;
                font-size: 22px;
            }
            .jscarousal-horizontal-forward{
                float: right;
            }
            .jscarousal-horizontal-back:before, .jscarousal-horizontal-forward:before{
                font-family: FontAwesome;
            }
            .jscarousal-horizontal-back:before{
                content: "\f053";
            }
            .jscarousal-horizontal-forward:before{
                content: "\f054";
            }
            .jscarousal-contents-horizontal{
                width: calc(100% - 50px);
                height: 100%;
                float: left;
                position: relative;
                overflow: hidden;
            }
            .jscarousal-contents-horizontal > .visible{
                position: absolute;
                width: 100%;
            }
            .jscarousal-contents-horizontal > .visible > .product-box{
                float: left;
                margin: 0px 1%;
                width: 18%;
            }
            .jscarousal-contents-horizontal img{
                width: 100%;
            }
            body {
                margin: 0;
                font-family: Arial, Helvetica, sans-serif;
            }
            .topnav {
                overflow: hidden;
                background-color:  #000000;
            }
            .topnav a {
                float: left;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }
            .topnav a:hover {
                background-color: #B0C4DE;
                color: black;
            }
            .topnav a.active {
                background-color:#B0C4DE;
                color: white;
            }
            body {
                background-image: url('bluess.jpg');
                background-repeat: no-repeat;
                background-attachment: fixed;  
                background-size: cover;
            }
            .fa_custom {
                color: 
                    #0099CC;
                margin-right:-150rem;
            }
        </style>
  
</head>
<body>
    <form action="AjouterPanier" method="POST">
    <div class="topnav">
        
            <%!int n = 0;%>
            <%
                
               PanierService pn = new PanierService();
               int o=0;
                if (pn.findAll() != null ) {
                    for(Panier pi :pn.findAll()){
                        
                        if(pi.getClient().getId()==c.getId())
                        o++;
                    }
                   n=o;
                }
            %>
            <a href="panier.jsp"> <i class="fa fa-shopping-cart fa_custom fa-2x"> <%= n%></i></a>

            <a class="active" href="#home">Home</a>
            <a href="#news">News</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>



    </div>

    <div style="padding-left:16px">

        <h2 style="font-size:30px; color:white; margin:10px;">Our products</h2>
    </div>
    <br><br>
    
    <div id="product-slider">
      
        <%
        String marque = request.getParameter("marque");
        MarqueService mr = new MarqueService();
        Marque ms = mr.findByNom(marque);
        ProduitService ui = new ProduitService();
        List<Produit> pr = ui.getByMarque(ms);
        for (int i = 0; i < pr.size(); i++) {
        %>
        <div class="product-box">
            <img src="<%="images\\" + pr.get(i).getImage()%>" alt="<%= pr.get(i).getNom()%>" />
            <div class="product-desc">
                <h5><%= pr.get(i).getCategorie().getNom()%>: <%= pr.get(i).getNom()%></h5>
                <h5><%=pr.get(i).getMarque().getNom()%></h5>
                <h5><%=pr.get(i).getPrix()%> </h5>
                <td><a href="./AjouterPanier?id=<%= pr.get(i).getId()%>&client=<%= c.getId()%> ">Add To Cart </a></td>
                <p></p>
            </div>
        </div><%}%>
    </div>
</form>
</body>
</html>