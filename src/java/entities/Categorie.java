/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author hp
 */
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @OneToMany(mappedBy = "categorie")
    List<Categorie> sous_categorie = new ArrayList();
    @ManyToOne
    private Categorie categorie;

    public Categorie() {
    }

    public Categorie(String nom, Categorie categorie) {
        this.nom = nom;
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Categorie(String nom) {
        this.nom = nom;
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
       return  nom ;
      
    }
    public void show(){
        
        System.out.println(this.nom.toString());
    }

}
