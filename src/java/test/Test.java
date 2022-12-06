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
        HibernateUtil.getSessionFactory().openSession();
        AdminService ad = new AdminService();
        CategorieService ca = new CategorieService();
        ClientService cl = new ClientService();
        CommandeService cm = new CommandeService();
        FactureService ft = new FactureService();
        LigneCommandeService lc = new LigneCommandeService();
        MarqueService mr = new MarqueService();
        ProduitService pr = new ProduitService();
       /*  ad.create(new Admin("admin@gmail.com", "h123"));
         ca.create(new Categorie("PC"));
         ca.create(new Categorie("Tablette"));
         cl.create(new Client("alaoui", "salma", "26555", "zohor", "client@gmail.com", "0000"));
         mr.create(new Marque("DELL"));
         mr.create(new Marque("HP"));
         mr.create(new Marque("THINKPAD"));
        pr.create(new Produit("hp","Hp",5000,"image.jpg",4,"corei5",mr.findById(2),ca.findById(1)));
        ca.create(new Categorie("PcPortable", ca.findById(1)));
        ca.create(new Categorie("PcDesktop", ca.findById(1)));
        /*Iterator<Categorie> categoriets = ca.findAll().iterator();
        System.out.println("la liste");
        while(categoriets.hasNext()){
            Categorie e = categoriets.next();
            e.show();
            
        }
        //System.out.println(ad.findByEmail("admin@gmail.com"));
       // System.out.println(cl.findByEmail("client@gmail.com"));
        //ad.create(new Admin("admin11@gmail.com",Util.md5("1234")));
        //cl.create(new Client("kabbabi1", "salma1", "72955", "zohor", "client12@gmail.com",Util.md5( "0011")));
        //kk et  oo <password=1111
         pr.create(new Produit("dell","Dell",8000,"logos.jpg",4,"corei7",mr.findById(1),ca.findById(2)));
         pr.create(new Produit("asus","Asus",7000,"logos.jpg",4,"corei7",mr.findById(1),ca.findById(2)));
         pr.create(new Produit("toshiba","Toshiba",9000,"logos.jpg",4,"corei7",mr.findById(1),ca.findById(2)));
         pr.create(new Produit("dell","Dell",4000,"logos.jpg",4,"corei7",mr.findById(1),ca.findById(2)));
         pr.create(new Produit("dell","Dell",8000,"logos.jpg",4,"corei7",mr.findById(1),ca.findById(2)));
         pr.create(new Produit("dell","Dell",8000,"logos.jpg",4,"corei7",mr.findById(1),ca.findById(2)));
         pr.create(new Produit("lsus","Asus",7000,"logos.jpg",4,"corei7",mr.findById(1),ca.findById(2)));
         pr.create(new Produit("il","Toshiba",9000,"logos.jpg",4,"corei7",mr.findById(1),ca.findById(2)));
         pr.create(new Produit("legof","Dell",4000,"logos.jpg",4,"corei7",mr.findById(1),ca.findById(2)));
         pr.create(new Produit("gof","Dell",8000,"logos.jpg",4,"corei7",mr.findById(1),ca.findById(2)));*/
        //cl.create(new Client("kabbabi1", "salma1", "72955", "zohor", "client12@gmail.com",Util.md5( "0011")));
       /* cm.create(new Commande(new Date(),cl.findById(4),ft.findById(1),"Annuler"));
        cm.create(new Commande(new Date(),cl.findById(4),ft.findById(1),"Approuver"));
        cm.create(new Commande(new Date(),cl.findById(4),ft.findById(1),"Livrer"));
        cm.create(new Commande(new Date(),cl.findById(4),ft.findById(1),"Livrer"));*/
        PanierService pn = new PanierService();
        UserService us = new UserService();
      /*  cl.create(new Client("kabbabi1", "salma1", "72955", "zohor", "oumaima@gmail.com",Util.md5( "0011"),"Client"));
       cl.create(new Client("kabbabi1", "salma1", "72955", "zohor", "amal@gmail.com",Util.md5( "0012"),"Client"));
       ad.create(new Admin("admin@gmail.com",Util.md5("0000"),"Admin"));*/
       
       
    }
}
