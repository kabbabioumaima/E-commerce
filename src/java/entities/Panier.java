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
public class Panier implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Produit produit;
    private int qte;
    @ManyToOne
    private Client client;

    public Panier() {
    }

    public Panier(Produit produit, int qte, Client client) {
        this.produit = produit;
        this.qte = qte;
        this.client = client;
    }

    

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", produit=" + produit + ", qte=" + qte + ", client=" + client + '}';
    }
   
}