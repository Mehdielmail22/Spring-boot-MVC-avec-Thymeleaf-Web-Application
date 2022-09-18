package com.example.tst.Model;

import javax.persistence.*;

@Entity
@Table(name = "produit")

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private float prix;
    public Produit(String nom, float prix) {
        super();
        this.nom = nom;
        this.prix = prix;
    }

    public Produit() {

    }
    public Produit(long id,String nom,float prix) {
        this.id=id;
        this.nom=nom;
        this.prix=prix;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }

}
