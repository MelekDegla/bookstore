package com.vermeg.bookstore.dao.impl;

import java.util.List;

import com.vermeg.bookstore.dao.EntityService;
import com.vermeg.bookstore.model.User;

public interface UserService extends EntityService<User> {
	
	public  List<User> findByName(String name);
	
	
	
}
