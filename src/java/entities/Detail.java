/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 *
 * @author hp
 */
@Entity
public class Detail implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   @ManyToOne
    private Produit produit;
    private int qte;
    private int commande;

    public Detail() {
    }

    public Detail(Produit produit, int qte, int commande) {
        this.produit = produit;
        this.qte = qte;
        this.commande = commande;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }


    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getCommande() {
        return commande;
    }

    public void setCommande(int commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        return "Detail{" + "id=" + id + ", produit=" + produit + ", qte=" + qte + ", commande=" + commande + '}';
    }

   
    
}
