/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Admin;
import entities.Categorie;
import entities.Client;
import entities.Commande;
import entities.LigneCommande;
import entities.Marque;
import entities.Produit;
import java.util.Date;
import java.util.Iterator;
import org.hibernate.Hibernate;
import service.AdminService;
import service.CategorieService;
import service.ClientService;
import service.CommandeService;
import service.FactureService;
import service.LigneCommandeService;
import service.MarqueService;
import service.PanierService;
import service.ProduitService;
import service.UserService;
import util.HibernateUtil;
import util.Util;

/**
 *
 * @author a
 */
public class Test {

    public static void main(String[] args) {
       // HibernateUtil.getSessionFactory().openSession();
        AdminService ad = new AdminService();
        CategorieService ca = new CategorieService();
        ClientService cl = new ClientService();
        CommandeService cm = new CommandeService();
        FactureService ft = new FactureService();
        LigneCommandeService lc = new LigneCommandeService();
        MarqueService mr = new MarqueService();
        ProduitService pr = new ProduitService();
     
        UserService us = new UserService();
      
       
       
    }
}
