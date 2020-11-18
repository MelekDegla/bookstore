package com.vermeg.bookstore.model;

public class Order {
    private int id;
    private int status;

    private int userId;

    public Order(int id, int status, int userId) {
        this.id = id;
        this.status = status;
        this.userId = userId;
    }

    public Order(int status, int userId) {
        this.status = status;
        this.userId = userId;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
