package com.vermeg.bookstore;

import java.util.Date;

import com.vermeg.bookstore.dao.impl.UserDao;
import com.vermeg.bookstore.dao.impl.UserDaoImpl;
import com.vermeg.bookstore.model.User;
import com.vermeg.bookstore.utils.DBConnection;

public class Main  {
	




    public static void main(String[] args) {
    	User user= new User(); 
    	user.setName("wiem");
    	user.setBirthdate("1/08/1997");
    	user.setId(14);
    	user.setLastname("rekik");
    	
    	
    	
    	UserDaoImpl.getInstance().delete(user);
    	
    	
    System.out.println(UserDaoImpl.getInstance().findAll());	
    
    }
}
