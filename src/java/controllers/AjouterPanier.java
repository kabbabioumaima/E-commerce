/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Client;
import entities.Panier;
import entities.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ClientService;
import service.PanierService;

import service.ProduitService;

/**
 *
 * @author hp
 */
@WebServlet(name = "AjouterPanier", urlPatterns = {"/AjouterPanier"})
public class AjouterPanier extends HttpServlet {
 
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
       int id = Integer.parseInt(request.getParameter("id"));
       int client = Integer.parseInt(request.getParameter("client"));
        PanierService paniers = new PanierService();
        ProduitService sp = new ProduitService();
        Produit p = sp.findById(id);
        ClientService cs = new ClientService();
        Client c= cs.findById(client);
        HttpSession session = request.getSession();
        if (p != null) {
            int etat = 0;
            
            if (paniers.findAll() != null) {
               
                for (Panier p1 : paniers.findAll()) {
                    if (p1.getProduit().getId() == id && p1.getClient().getId()==client) {
                        p1.setQte(p1.getQte() + 1);
                        paniers.update(p1);
                        etat = 1;
                    }
                }
            }
            if (etat == 0) {
                Panier pi = new Panier(p, 1,c);
               paniers.create(pi);
                
            }

        }

        request.getRequestDispatcher("catalogue.jsp").forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);

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