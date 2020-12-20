package com.vermeg.bookstore.model;

import java.util.Date;

public class Feedback {
    private int id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String subject;
    private String message;
    private Date created_at;
    private int is_answered;
    private String answer;
    private int id_user;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String Subject) {
        this.subject = Subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getIs_answered() {
        return is_answered;
    }

    public void setIs_answered(int is_answered) {
        this.is_answered = is_answered;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Feedback(int id, String name, String lastname, String email, String phone, String subject, String message, Date created_at, int is_answered,String answer,int id_user) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
        this.message = message;
        this.created_at = created_at;
        this.is_answered=is_answered;
        this.answer=answer;
        this.id_user=id_user;
    }
    public Feedback() {
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
