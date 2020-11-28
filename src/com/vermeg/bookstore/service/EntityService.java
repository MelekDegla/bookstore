package com.vermeg.bookstore.service;

import java.sql.SQLException;
import java.util.List;

public interface EntityService<T> {
	public void insert(T entity) throws SQLException;
	public void update (T entity) throws SQLException;
	public void delete(T entity) throws SQLException;
	void deleteById(int id) throws SQLException;
	public  List<T> findAll() throws SQLException;
	public T findById(int id ) throws SQLException;
	
	
}
