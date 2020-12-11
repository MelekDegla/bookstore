package com.vermeg.bookstore.model;

import java.sql.Date;

public class Events {
    private int ID;
    private String title;
    private String description;
    private Date date;
    private int MAX_PARTICIPANTS;
    private String lieu;
    public Events() {

    }

    public Events(String title, String description, Date date, int MAX_PARTICIPANTS, String lieu) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.MAX_PARTICIPANTS = MAX_PARTICIPANTS;
        this.lieu = lieu;
    }

    public Events(int ID, String title, String description, Date date, int MAX_PARTICIPANTS, String lieu) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.date = date;
        this.MAX_PARTICIPANTS = MAX_PARTICIPANTS;
        this.lieu = lieu;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public  String getTitle() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMAX_PARTICIPANTS() {
        return MAX_PARTICIPANTS;
    }

    public void setMAX_PARTICIPANTS(int MAX_PARTICIPANTS) {
        this.MAX_PARTICIPANTS = MAX_PARTICIPANTS;
    }



    @Override
    public String toString() {
        return "Events{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", MAX_PARTICIPANTS=" + MAX_PARTICIPANTS +
                '}';
    }



}
