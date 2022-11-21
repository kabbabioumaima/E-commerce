/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Client;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ClientService;
import util.Util;


/**
 *
 * @author hp
 */
@WebServlet(name = "AuthentificationClient", urlPatterns = {"/AuthentificationClient"})
public class AuthentificationClient extends HttpServlet {
 

    
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
        ClientService cl = new ClientService();
        Client c = cl.findByEmail(email);
        
        if (c != null) {
            if (c.getPassword().equals(Util.md5(passworde))) {
                HttpSession session = request.getSession();
                session.setAttribute("client", c);
                cl.update(c);
                response.sendRedirect("catalogue.jsp");
            } else {
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
