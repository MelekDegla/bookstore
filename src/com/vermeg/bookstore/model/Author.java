package com.vermeg.bookstore.model;

import java.util.Date;

public class Author {
    private int id;
    private String name;
    private String lastname;
    private Date birthdate;
    private String photo;
    private int nbLivres;

    public Author(String name, String lastname, Date birthdate, String photo, int nbLivres) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.photo = photo;
        this.nbLivres = nbLivres;
    }



    public Author(int id, String name, String lastname, Date birthdate, String photo, int nbLivres) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.photo = photo;
        this.nbLivres = nbLivres;
    }

    public int getNbLivres() {
        return nbLivres;
    }

    public void setNbLivres(int nbLivres) {
        this.nbLivres = nbLivres;
    }

    public Author(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Auther{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", photo='" + photo + '\'' +
                '}';
    }
}

