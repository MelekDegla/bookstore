package com.vermeg.bookstore.model;

import java.util.Date;

public class Author {
    private int id;
    private String name;
    private String lastname;
    private String birthdate;
    private String photo;

    public Author(){}

    public Author(int id, String name, String lastname, String birthdate, String photo) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.photo = photo;
    }

    public Author(String name, String lastname, String birthdate, String photo) {

        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.photo = photo;
    }

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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
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
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", photo='" + photo + '\'' +
                '}';
    }
}

