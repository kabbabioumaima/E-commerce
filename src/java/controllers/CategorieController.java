/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Categorie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CategorieService;

/**
 *
 * @author hp
 */
@WebServlet(name = "CategorieController", urlPatterns = {"/CategorieController"})
public class CategorieController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategorieService mr = new CategorieService();
        List<Categorie> liste_mr = mr.findAll();
        request.getSession().setAttribute("liste_mr", liste_mr);
        request.getRequestDispatcher("categories.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String nom = request.getParameter("nom");
       String categorie = request.getParameter("categorie");
        CategorieService mr = new CategorieService();
        
      if(categorie.equalsIgnoreCase("nulle")){
       Categorie m = new Categorie(nom);
       boolean b = mr.create(m);
     
       if(b){
       
        List<Categorie> liste_mr = mr.findAll();
        request.getSession().setAttribute("liste_mr", liste_mr);
       }
      }else{
            
          Categorie m2 = new Categorie(nom,mr.findByNom(categorie));
       boolean b2 = mr.create(m2);
     
       if(b2){
       
        List<Categorie> liste_mr = mr.findAll();
        request.getSession().setAttribute("liste_mr", liste_mr);
       }
          
      }
        request.getRequestDispatcher("categories.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
