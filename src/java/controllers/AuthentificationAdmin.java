/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import entities.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.AdminService;
import util.Util;

/**
 *
 * @author hp
 */
@WebServlet(name = "AuthentificationAdmin", urlPatterns = {"/AuthentificationAdmin"})
public class AuthentificationAdmin extends HttpServlet {


   
   

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
          String email = request.getParameter("email");
        String passworde = request.getParameter("password");
        AdminService cl = new AdminService();
        Admin c = cl.findByEmail(email);
        
        if (c != null) {
            if (c.getPassword().equals(Util.md5(passworde))) {
                HttpSession session = request.getSession();
                session.setAttribute("admin", c);
                cl.update(c);
                response.sendRedirect("index_1.html");
            } else {
                response.sendRedirect("login.jsp?msg=mot de passe incorrect");
            }
        } else {
            response.sendRedirect("login.jsp?msg=Email introvable");
        }
            
           
    }

   
   

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

   
   

}
