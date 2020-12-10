package com.vermeg.bookstore.model;

public class Categorie {
    private int id ;
   private String title ;
    private String description ;
    public Categorie(){}

    public Categorie(String title , String description){
        this.title=title ;
        this.description=description ;
    }
    public Categorie(int id,String title , String description){
        this.id=id;
        this.title=title ;
        this.description=description ;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
