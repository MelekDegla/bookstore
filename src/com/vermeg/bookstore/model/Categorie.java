package com.vermeg.bookstore.model;

public class Categorie {

    private int id ;
   private String libelle ;
    private String description ;
    private String image;
    public Categorie(){}

    public Categorie( String libelle , String description,String image){
        this.libelle=libelle ;
        this.description=description ;
        this.image=image;
    }
    public Categorie(int id) {
        this.id = id;
    }
    public Categorie(int id,String libelle , String description,String image){
        this.id=id;
        this.libelle=libelle;
        this.description=description ;
        this.image=image;
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

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return  libelle ;
    }
}
