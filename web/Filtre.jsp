<%-- 
    Document   : Filtre
    Created on : 29 nov. 2022, 00:47:40
    Author     : hp
--%>

<%@page import="entities.Commande"%>
<%@page import="service.CommandeService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Gestion des commandes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="categorie.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="styles.css" />
        <style>
            @import url("https://fonts.googleapis.com/css2?family=Lobster&display=swap");
            * {
                padding: 0px;
                margin: 0px;
                -webkit-box-sizing: border-box;
                box-sizing: border-box;
            }

            .t_dlt_btn {
                background: red;
                color: #fff;
                outline: none;
                -webkit-box-shadow: none;
                box-shadow: none;
                border: 1px solid red;
                cursor: pointer;
                padding: 2px;
                border-radius: 5px;
            }

            .t_edit_btn {
                background: green;
                color: #fff;
                outline: none;
                -webkit-box-shadow: none;
                box-shadow: none;
                border: 1px solid #5987B2;
                cursor: pointer;
                padding: 2px;
                border-radius: 5px;
            }

            .t_view_details {
                background: #5987B2;
                color: #fff;
                outline: none;
                -webkit-box-shadow: none;
                box-shadow: none;
                border: 1px solid #5987B2;
                cursor: pointer;
                padding: 2px;
                border-radius: 5px;
            }

            .categorie_section #errorMessage {
                position: fixed;
                top: 20px;
                margin-left: 10%;
                z-index: 20;
                display: none;
                background-color: red;
                padding: 10px 30px;
                width: 20%;
                color: #fff;
            }

            .categorie_section #successMessage {
                position: fixed;
                top: 20px;
                margin-left: 10%;
                display: none;
                z-index: 20;
                width: 20%;
                background-color: green;
                padding: 10px 30px;
                color: #fff;
            }

            .categorie_section .categorie_tab {
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-pack: justify;
                -ms-flex-pack: justify;
                justify-content: space-between;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
                padding: 7px 2%;
                border-bottom: 2px solid #5987B2;
                overflow: hidden;
            }

            .categorie_section .categorie_tab h1 {
                color: #000;
            }

            .categorie_section .categorie_tab .t_btn_tablinks {
                background-color: #fff;
                border: 1px solid #fff;
                float: left;
                border: none;
                outline: none;
                cursor: pointer;
                padding: 10px;
                -webkit-transition: 0.3s;
                transition: 0.3s;
                font-size: 17px;
            }

            .categorie_section .categorie_tab .t_btn_tablinks:hover {
                background-color: #B0C4DE;
            }

            .categorie_section .categorie_tab .t_btn_tablinks.active_t {
                background-color: #B0C4DE;
            }

            .categorie_section .categorie_tabcontent {
                display: none;
                padding: 6px 12px;
                border-top: none;
            }

            .categorie_section #see_categorie {
                margin: 20px 0px;
            }

            .categorie_section #see_categorie .categorie_search .search_input {
                padding: 10px 5px;
                width: 280px;
                margin: 10px 0px;
                border: 1px solid #5987B2;
            }

            .categorie_section #see_categorie .categorie_search .search_input:focus {
                outline: none;
                -webkit-box-shadow: none;
                box-shadow: none;
            }

            .categorie_section #see_categorie table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
                background-color: #fff;
            }

            .categorie_section #see_categorie th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
                background-color: #8DB4D8;
                color: #fff;
            }

            .categorie_section #see_categorie td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
                color: #000;
            }

            .categorie_section #see_categorie tr:nth-child(even) {
                background-color: #e6e3e3;
                color: #000;
            }

            .categorie_section #add_categorie form {
                background-color: #fff;
                border: 1px solid #5987B2;
                border-radius: 15px;
                -webkit-box-shadow: 0px 4px 8px 0px rgba(0, 0, 0, 0.2);
                box-shadow: 0px 4px 8px 0px rgba(0, 0, 0, 0.2);
                width: 200%;
                margin: 20px auto;
                padding: 100px;
            }

            .categorie_section #add_categorie form h2 {
                font-family: "Lobster", cursive;
                text-align: center;
                margin: 15px 0px;
                color: #000;
                display: block;
            }

            .categorie_section #add_categorie form .first_last_name {
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-pack: justify;
                -ms-flex-pack: justify;
                justify-content: space-between;
                color: #000;
            }

            .categorie_section #add_categorie form .first_last_name .f_left {
                width: 49%;
            }

            .categorie_section #add_categorie form .first_last_name .l_right {
                width: 49%;
            }

            .categorie_section #add_categorie form .t_city {
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-pack: justify;
                -ms-flex-pack: justify;
                justify-content: space-between;
            }

            .categorie_section #add_categorie form .t_city .t_city_left {
                width: 49%;
            }

            .categorie_section #add_categorie form .t_city .t_city_right {
                width: 49%;
            }

            .categorie_section #add_categorie form input {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #5987B2;
                outline: none;
                font-size: 15px;
                color: #3e3e3e;
                font-weight: 500;
                -webkit-box-shadow: none;
                box-shadow: none;
            }

            .categorie_section #add_categorie form input:focus {
                border: 1px solid yellow;
            }

            .categorie_section #add_categorie form label {
                font-size: 20px;
                line-height: 40px;
                font-weight: 500;
                color: #000;
            }

            .categorie_section #add_categorie form select {
                padding: 10px;
                margin-bottom: 20px;
                cursor: pointer;
                border: 1px solid #5987B2;
            }

            .categorie_section #add_categorie form #sub_categorie_btn {
                padding: 10px 50px;
                outline: none;
                border: 1px solid #5987B2;
                cursor: pointer;
                font-size: 17px;
                background-color: #CCE6FF;
            }

            .categorie_section #add_categorie form #sub_categorie_btn:hover {
                background-color: #B0C4DE;
                border: 1px solid #5987B2;
            }

            .modal {
                position: fixed;
                width: 100%;
                top: 0;
                left: 0;
                height: 100vh;
                background: rgba(0, 0, 0, 0.7);
                display: none;
                z-index: 300;
                overflow-y: scroll;
            }

            .modal .modal_body {
                position: relative;
                width: 70%;
                z-index: 301;
                margin: 70px auto;
                background: #fff;
            }

            .modal .modal_body #hide_edit_modal {
                position: absolute;
                top: -15px;
                right: -15px;
                background-color: red;
                padding: 7px;
                border-radius: 50%;
                color: #fff;
                cursor: pointer;
            }

            .modal .modal_body h2 {
                text-align: center;
                padding: 15px 0px;
            }

            .modal .modal_body form {
                width: 100%;
                margin: 20px auto;
                padding: 10px;
            }

            .modal .modal_body form h2 {
                font-family: "Lobster", cursive;
                text-align: center;
                margin: 10px 0px;
            }

            .modal .modal_body form .first_last_name {
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-pack: justify;
                -ms-flex-pack: justify;
                justify-content: space-between;
            }

            .modal .modal_body form .first_last_name .f_left {
                width: 49%;
            }

            .modal .modal_body form .first_last_name .l_right {
                width: 49%;
            }

            .modal .modal_body form .t_city {
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-pack: justify;
                -ms-flex-pack: justify;
                justify-content: space-between;
            }

            .modal .modal_body form .t_city .t_city_left {
                width: 49%;
            }

            .modal .modal_body form .t_city .t_city_right {
                width: 49%;
            }

            .modal .modal_body form input {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #5987B2;
                outline: none;
                font-size: 15px;
                color: #3e3e3e;
                font-weight: 500;
                -webkit-box-shadow: none;
                box-shadow: none;
            }

            .modal .modal_body form input:focus {
                border: 1px solid #5987B2;
            }

            .modal .modal_body form label {
                font-size: 20px;
                line-height: 40px;
                font-weight: 500;
                color: #000;
            }

            .modal .modal_body form select {
                padding: 10px;
                margin-bottom: 20px;
                cursor: pointer;
                border: 1px solid #5987B2;
            }

            .modal .modal_body form #sub_categorie_btn {
                padding: 10px 50px;
                outline: none;
                border: 1px solid #5987B2;
                cursor: pointer;
                font-size: 17px;
                background-color: #CCE6FF;
            }

            .modal .modal_body form #sub_categorie_btn:hover {
                background-color: #CCE6FF;
                border: 1px solid #5987B2;
            }

            .fa-envelope,
            .fa-instagram,
            .fa-twitter {
                border: 1px solid red;
                margin: 20px 10px;
                padding: 10px;
                border-radius: 50%;
                border: 2px solid #ddd;
                cursor: pointer;
                color: #000;
            }

            .fa-envelope:hover,
            .fa-instagram:hover,
            .fa-twitter:hover {
                border: 2px solid #6e6d6d;
            }

            .details_modal {
                position: fixed;
                width: 100%;
                top: 0;
                left: 0;
                height: 100vh;
                background: rgba(0, 0, 0, 0.5);
                z-index: 300;
                display: none;
                overflow-y: scroll;
                -webkit-transition: 0.3s;
                transition: 0.3s;
            }

            .details_modal .details_modal_body {
                position: relative;
                width: 70%;
                z-index: 100;
                margin: 70px auto;
                background: #fff;
            }

            .details_modal .details_modal_body #hide_details_modal {
                position: absolute;
                top: -15px;
                right: -15px;
                background-color: red;
                padding: 7px;
                border-radius: 50%;
                cursor: pointer;
            }

            .details_modal .details_modal_body .details_modal_body_inner {
                padding: 50px 20px;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row {
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .left {
                width: 30%;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .left img {
                width: 100%;
                border: 2px solid #ddd;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .left .social_media {
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-pack: center;
                -ms-flex-pack: center;
                justify-content: center;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .left .social_media a {
                color: #000;
                text-decoration: none;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right {
                width: 70%;
                padding: 0px 20px;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right h2 {
                color: #000;
                font-size: 30px;
                line-height: 40px;
                font-family: "Josefin Sans", sans-serif;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .mobile {
                margin: 20px 0px;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .mobile h3 {
                color: #000;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .mobile .fa-phone {
                color: #ddd;
                padding: 7px;
                border-radius: 50%;
                border: 2px solid #ddd;
                margin: 0px 15px 0px 0px;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .address {
                margin: 20px 0px;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .address h3 {
                color: #000;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .address .fa-address-card {
                color: #ddd;
                padding: 7px;
                border-radius: 50%;
                border: 2px solid #ddd;
                margin: 0px 15px 0px 0px;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .state {
                margin: 20px 0px;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .state h3 {
                color: #000;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .state .fa-monument {
                color: #ddd;
                padding: 7px;
                border-radius: 50%;
                border: 2px solid #ddd;
                margin: 0px 15px 0px 0px;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .qualification {
                margin: 20px 0px;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .qualification h3 {
                color: #000;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .qualification .fa-graduation-cap {
                color: #ddd;
                padding: 7px;
                border-radius: 50%;
                border: 2px solid #ddd;
                margin: 0px 15px 0px 0px;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .city {
                margin: 20px 0px;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .city h3 {
                color: #000;
            }

            .details_modal .details_modal_body .details_modal_body_inner .row .right .city .fa-city {
                color: #ddd;
                padding: 7px;
                border-radius: 50%;
                border: 2px solid #ddd;
                margin: 0px 15px 0px 0px;
            }

            .details_modal .details_modal_body .details_modal_body_inner .zip {
                margin: 20px 0px;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
            }

            .details_modal .details_modal_body .details_modal_body_inner .zip h3 {
                color: #000;
            }

            .details_modal .details_modal_body .details_modal_body_inner .zip p {
                color: #8a8787;
                font-size: 15px;
                font-weight: 500;
                margin: 0px 15px 0px 0px;
                width: 100px;
            }

            .details_modal .details_modal_body .details_modal_body_inner .email {
                margin: 20px 0px;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
            }

            .details_modal .details_modal_body .details_modal_body_inner .email h3 {
                color: #000;
            }

            .details_modal .details_modal_body .details_modal_body_inner .email p {
                width: 100px;
                color: #8a8787;
                font-size: 15px;
                font-weight: 500;
                margin: 0px 15px 0px 0px;
            }

            .details_modal .details_modal_body .details_modal_body_inner .gender {
                margin: 20px 0px;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
            }

            .details_modal .details_modal_body .details_modal_body_inner .gender h3 {
                color: #000;
            }

            .details_modal .details_modal_body .details_modal_body_inner .gender p {
                width: 100px;
                color: #8a8787;
                font-size: 15px;
                font-weight: 500;
                margin: 0px 15px 0px 0px;
            }
            .bg-info {
            width : 100%;
            background: url("bac.jpg");
            background-size: cover;
            background-position: center;
            display: flex;
            flex-direction: column;
        }

        </style>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <div class="bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading text-dark text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                        class="fas fa-user-secret me-2"></i>Espace Admin </div>
                <div class="list-group list-group-flush my-3">
                    <a href="dashboard.jsp" class="list-group-item text-dark list-group-item-action bg-transparent second-text active"><i
                            class="fas fa-tachometer-alt me-2"></i>Dashboard</a>

                    <a href="produits.jsp" class="list-group-item text-dark list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-laptop"></i>Produits</a>

                    <a href="marques.jsp" class="list-group-item text-dark list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-laptop"></i>Marques</a>
                    <a href="categories.jsp" class="list-group-item text-dark list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-paperclip me-2"></i>Catégories</a>
                    <a href="commandes.jsp" class="list-group-item text-dark list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-shopping-cart me-2"></i>Commandes</a>

                    <a href="#" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold"><i
                            class="fas fa-power-off me-2"></i>Logout</a>
                </div>
            </div>
            <div class="bg-info" id="page-content-wrapper">
                <nav class="navbar navbar-expand-lg navbar-light   bg-transparent py-4 px-4">
                    <div class="container-fluid px-4">
                        <div class="row my-5">
                            <div class="col">
                                <div class="categorie_section">
                                    <div class="categorie_tab">
                                        <i class="fas fa-align-left text-dark primary-text fs-4 me-3" id="menu-toggle"></i>
                                        <h1>Nos Commandes</h1>
                                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                                aria-expanded="false" aria-label="Toggle navigation">
                                            <span class="navbar-toggler-icon"></span>
                                        </button>
                                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                                                <li class="nav-item dropdown">


                                                </li>
                                            </ul>
                                        </div> 
                                        <div class="categorie_tab_inner">
                                            <button class="t_btn_tablinks" onclick="categorieFunc(event, 'see_categorie')"id="t_defaultOpen" >Liste
                                                <i class="fas fa-info-circle"></i>
                                            </button>


                                        </div>
                                    </div>
                                    <!-- view categorie section start  ======================================-->
                                    <div id="see_categorie" class="categorie_tabcontent">
                                        <div class="categorie_search">
                                            
                                        </div>
                                        <table>
                                            <tr>
                                                <th width="100px">Date</th>
                                                <th width="300px">Nom Client</th>
                                                <th width="300px">Montant</th>
                                               <th width="300px">Etat Actuel</th>
                                                <th width="300px">Changer Etat</th>
                                                <th style="display: none;"></th>
                                                <th> Action</th>
                                            <tbody>


                                                <%
                                                    String etat = request.getParameter("etat");
                                                    CommandeService cs = new CommandeService();
                                                   
                                                    for (Commande c : cs.findByEtat(etat)) {
                                                       
                                                %>
                                                <form method="POST" action="UpdateEtat">
                                                <tr>
                                                    <td><%= c.getDate()%></td>
                                                    <td><%= c.getClient().getNom()%></td>
                                                    <td><%= c.getFacture().getMontant()%></td>
                                                    <td><%= c.getEtat()%></td>
                                                    <td>
                                                    <select name="etat">
                                                        <option>En cours</option>
                                                        <option>Annuler</option>
                                                        <option>Approuver</option>
                                                        <option>Livrer</option>
                                                    </select>
                                                </td>
                                                <td style="display: none;"><input type="text" name="id" value="<%= c.getId()%>"></td>
                                                <td><input style="color: white; background: #52d3ed; padding: 1px 30px;margin: 0 20px;" type="submit" value="Modifier" name="Modifier" /></td>

                                                </tr>
                                                <%}%>
                                                </form>
                                                

                                               

                                            </tbody>
                                        </table>
                                        
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>                
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
        <script>
                                                var el = document.getElementById("wrapper");
                                                var toggleButton = document.getElementById("menu-toggle");

                                                toggleButton.onclick = function () {
                                                    el.classList.toggle("toggled");
                                                };
        </script>
    </body>
    <script src="categorie.js" type="text/javascript"></script>
</html>