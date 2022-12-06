/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Commande;
import entities.Detail;
import entities.Facture;
import entities.Panier;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ClientService;
import service.CommandeService;
import service.DetailService;
import service.FactureService;
import service.PanierService;

/**
 *
 * @author hp
 */
@WebServlet(name = "CommandeController", urlPatterns = {"/CommandeController"})
public class CommandeController extends HttpServlet {

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
        PanierService pn = new PanierService();
       CommandeService cm = new CommandeService();
       ClientService cl = new ClientService();
       FactureService fc = new FactureService();
       int total = Integer.parseInt(request.getParameter("total"));
       Facture f = new Facture(new Date(), total);
        boolean b = fc.create(f);
       if(b){
       
        List<Facture> liste_fc = fc.findAll();
        request.getSession().setAttribute("liste_fc", liste_fc);
       }
       int client = Integer.parseInt(request.getParameter("client"));
      
       Commande c = new Commande(new Date(), cl.findById(client), f, "en cours");
        boolean h = cm.create(c);
       if(h){
       
        List<Commande> liste_cm = cm.findAll();
        request.getSession().setAttribute("liste_cm", liste_cm);
       }
      
    
       DetailService dt = new DetailService();
                    if (pn.findAll() != null) {
                        for (Panier p : pn.findAll()) {
                           if (p.getClient().getId() == client){
                            dt.create(new Detail(p.getProduit(),p.getQte(),c.getId()));
                           }
                        }  
                    }  
                    
                    
    
    
                    if (pn.findAll() != null) {
                        for (Panier p : pn.findAll()) {
                           if (p.getClient().getId() == client){
                            pn.delete(p);
                           }
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
