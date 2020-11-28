package com.vermeg.bookstore.model;

import java.sql.Blob;
import java.util.Date;


public class User {
	private int id;
	private String name  ; 
	private String lastname;
	private String phone ; 
	private String email; 
	private String password ;
	private String username; 
	private String birthdate; 
     private Boolean isAdmin;
     private Blob photo;
	public User() {
		super();
	}
	public User(int id, String name, String lastname, String phone, String email, String password, String username,
			String birthdate, Boolean isAdmin, Blob photo) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.username = username;
		this.birthdate = birthdate;
		this.isAdmin = isAdmin;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
     
	
	
	

	
	
	

}
