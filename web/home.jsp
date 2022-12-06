<%-- 
    Document   : home
    Created on : 17 nov. 2022, 21:21:16
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home page</title>
    <link rel="stylesheet" href="style.css">
    <style>
        nav 
{
    margin: 100px auto;
    width: 50%;
    height: 150px;
  
}
 
nav .main_pages 
{
    display: flex;
    justify-content: space-around;
    align-items: center;
     width: 95%;
}
 
nav .main_pages a 
{
    width: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100px;
    text-decoration: none;
    font-family: Trebuchet MS;
    font-size: xx-large;
    color: white;
    font-weight: 300;
}
 body {
     background-image: url("shop.jpg");
     background-size: cover;

     }
nav a:hover 
{
    background: #000000;
}
    </style>
</head>
<body>
    <nav>
        <div class="main_pages">
       
           
            <a href="login.jsp"> Login </a>
        </div>
    </nav>
</body>
</html>