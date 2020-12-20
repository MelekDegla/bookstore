package com.vermeg.bookstore.model;

public class PBook  extends Book{
    private int nbrPage;

    public PBook(){}

    public PBook(int id, int quantity, String isbn, String title,int auteur, String description, String photo, double price, int nbrPage) {
        super(id, quantity, isbn, title, auteur,description, photo, price);
        this.nbrPage = nbrPage;
    }



    public int getNbrPage() {
        return nbrPage;
    }

    public void setNbrPage(int nbrPage) {
        this.nbrPage = nbrPage;
    }

    @Override
    public String toString() {
        return super.toString() + "nbr pages" + this.nbrPage;
    }

}
