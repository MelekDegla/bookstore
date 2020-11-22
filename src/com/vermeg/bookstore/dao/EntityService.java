package com.vermeg.bookstore.dao;

import java.util.List;

public interface EntityService<T> {
	public void insert(T entity); 
	public void update (T entity); 
	public void delete(T entity); 
	public  List<T> findAll();
	public T findById(int id );
	
	
}
