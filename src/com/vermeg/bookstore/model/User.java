package com.vermeg.bookstore.model;

import java.util.Date;


public class User {
	private int id;
	private String name  ; 
	private String lastname;
	private String phone ; 
	private String email; 
	private String password ;
	private String username; 
	private Date birthdate; 
     private Boolean isAdmin;
     private String photo;
	public User() {
		super();

	}

	public User(int id, String name, String lastname, String phone, String email, String password, String username,
			Date birthdate, Boolean isAdmin, String photo) {

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
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", lastname='" + lastname + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", username='" + username + '\'' +
				", birthdate=" + birthdate +
				", isAdmin=" + isAdmin +
				", photo='" + photo + '\'' +
				'}';
	}
}
