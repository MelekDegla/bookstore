package com.vermeg.bookstore.model;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class Book {

private int id,quantity,auteur;
private String isbn,title,description,photo;
private Double price;

public Book(){}


    public Book(int id, int quantity, String isbn, String title, int auteur, String description, String photo,
                double price){
    this.id=id;
    this.quantity=quantity;
    this.isbn=isbn;
    this.title=title;
    this.description=description;
    this.photo=photo;
    this.price=price;
    this.auteur=auteur;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAuteur() {
        return auteur;
    }

    public void setAuteur(int auteur) {
        this.auteur = auteur;
    }




    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", auteur='" + auteur + '\'' +
                ", price=" + price + " ";
    }
}
