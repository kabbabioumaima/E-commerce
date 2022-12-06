/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Lachgar
 */
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String designation;
    private int prix;
    private String image;
    private int unite;
    private String description;
    @ManyToOne
    private Marque marque;
    @ManyToOne
    private Categorie categorie;
    @OneToMany(mappedBy = "produit")
    private List<Panier> paniers;

    public Produit() {
    }

    public Produit(String nom, String designation, int prix, String image, int unite, String description, Marque marque, Categorie categorie) {
        this.nom = nom;
        this.designation = designation;
        this.prix = prix;
        this.image = image;
        this.unite = unite;
        this.description = description;
        this.marque = marque;
        this.categorie = categorie;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUnite() {
        return unite;
    }

    public void setUnite(int unite) {
        this.unite = unite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", designation=" + designation + ", prix=" + prix + ", image=" + image + ", unite=" + unite + ", description=" + description + ", marque=" + marque + ", categorie=" + categorie + '}';
    }
public void show(){
        
        System.out.println(this.nom.toString());
    }

}
