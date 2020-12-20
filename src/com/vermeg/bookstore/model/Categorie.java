package com.vermeg.bookstore.model;

import java.sql.Date;

public class Categorie {

    private int id ;
   private String libelle ;
    private String description ;

    public Date getDateajout() {
        return dateajout;
    }

    public void setDateajout(Date dateajout) {
        this.dateajout = dateajout;
    }

    public Date getDatemodif() {
        return datemodif;
    }

    public Categorie(String libelle, String description, Date dateajout, Date datemodif) {
        this.libelle = libelle;
        this.description = description;
        this.dateajout = dateajout;
        this.datemodif = datemodif;
    }

    public Categorie(int id, String libelle, String description, Date dateajout, Date datemodif) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.dateajout = dateajout;
        this.datemodif = datemodif;
    }

    public void setDatemodif(Date datemodif) {
        this.datemodif = datemodif;
    }

    public Date dateajout ;
    public Date datemodif ;
    public Categorie(){}

    public Categorie( String libelle , String description){
        this.libelle=libelle ;
        this.description=description ;

    }
    public Categorie(int id) {
        this.id = id;
    }
    public Categorie(int id,String libelle , String description){
        this.id=id;
        this.libelle=libelle;
        this.description=description ;
    }


    public String getLibelle() {
        return libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return  libelle ;
    }
}
