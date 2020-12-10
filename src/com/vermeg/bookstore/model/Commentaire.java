package com.vermeg.bookstore.model;

import java.util.Date;

public class Commentaire {
    private int id;
    private  String text;
    private int id_book;
    private int id_user;
    private Date created_at;
    private Date updated_at;

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Commentaire(int id, String text, int id_book, int id_user, Date created_at, Date updated_at) {
        this.id = id;
        this.text = text;
        this.id_book = id_book;
        this.id_user = id_user;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Commentaire() {
    }

}
