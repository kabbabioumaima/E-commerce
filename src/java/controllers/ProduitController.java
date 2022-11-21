/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Categorie;
import entities.Marque;
import entities.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CategorieService;
import service.MarqueService;
import service.ProduitService;

/**
 *
 * @author hp
 */
@WebServlet(name = "ProduitController", urlPatterns = {"/ProduitController"})
public class ProduitController extends HttpServlet {

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
       ProduitService mr = new ProduitService();
        List<Produit> liste_mr = mr.findAll();
        request.getSession().setAttribute("liste_mr", liste_mr);
        request.getRequestDispatcher("produits.jsp").forward(request, response);
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
       String designation = request.getParameter("designation");
       int prix = Integer.parseInt(request.getParameter("prix"));
       String image = request.getParameter("image");
      int unite =Integer.parseInt( request.getParameter("unite"));
       String description = request.getParameter("description");
       String marque = request.getParameter("marque");
       String categorie = request.getParameter("categorie");
      /* Marque m = new Marque(request.getParameter("marque")) ;
       Categorie c = new Categorie(request.getParameter("categorie")) ;*/
       
       MarqueService m = new MarqueService();
       CategorieService c = new CategorieService();
        ProduitService mr = new ProduitService();
Produit p = new Produit(nom,designation,prix,image,unite,description,m.findByNom(marque),c.findByNom(categorie));
       boolean b = mr.create(p);
       if(b){
       
        List<Produit> liste_mr = mr.findAll();
        request.getSession().setAttribute("liste_mr", liste_mr);
       }
        request.getRequestDispatcher("produits.jsp").forward(request, response);
	
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