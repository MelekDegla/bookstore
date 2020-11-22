package com.vermeg.bookstore.service;

import java.util.List;

import com.vermeg.bookstore.service.EntityService;
import com.vermeg.bookstore.model.User;

public interface UserService extends EntityService<User> {
	
	public  List<User> findByName(String name);
	
	
	
}
