/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import entities.Admin;
import entities.Client;
import entities.User;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.AdminService;
import service.ClientService;
import service.UserService;
import util.Util;


/**
 *
 * @author hp
 */
@WebServlet(name = "Authentification", urlPatterns = {"/Authentification"})
public class Authentification extends HttpServlet {
 

    
//Source : www.exelib.net

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String email = request.getParameter("email");
        String passworde = request.getParameter("password");
        
       UserService us = new UserService();
        User u = us.findByEmail(email);
        ClientService cl = new ClientService();
        AdminService ad = new AdminService();
        if (u != null) {
            
            if (u.getPassword().equals(Util.md5(passworde))) {
                if(u.getRole().equalsIgnoreCase("Client")){
                HttpSession session = request.getSession();
                Client c = cl.findByEmail(email);
                session.setAttribute("client", c);
                cl.update(c);
                response.sendRedirect("catalogue.jsp");
            } else{
                   HttpSession session = request.getSession();
                   Admin a = ad.findByEmail(email);
                session.setAttribute("admin", a);
                ad.update(a);
                response.sendRedirect("index_1.html"); 
                }
            
            }else {
                response.sendRedirect("loginClient.jsp?msg=mot de passe incorrect");
            }
        } else {
            response.sendRedirect("loginClient.jsp?msg=Email introvable");
        }}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
