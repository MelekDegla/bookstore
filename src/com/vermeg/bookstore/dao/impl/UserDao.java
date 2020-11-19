package com.vermeg.bookstore.dao.impl;

import java.util.List;

import com.vermeg.bookstore.dao.EntityDao;
import com.vermeg.bookstore.model.User;

public interface UserDao extends EntityDao<User> {
	
	public  List<User> findByName(String name);
	
	
	
}
