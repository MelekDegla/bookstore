package com.vermeg.bookstore.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vermeg.bookstore.model.User;
import com.vermeg.bookstore.utils.DBConnection;

public class UserDaoImpl implements UserDao {
	private Statement statement; 
	private ResultSet result;
	private static UserDaoImpl instance;
	private UserDaoImpl( ) {
		 try {
			statement= DBConnection.getInstance().getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  public static synchronized  UserDaoImpl getInstance(){
	        if(instance== null){
	            instance  = new UserDaoImpl();
	        }
	        return instance;
	    }
	@Override
	public void insert(User entity) {
		
		// TODO Auto-generated method stub
		String query = "insert into User ( name ,lastname , phone , email,password, username,birthdate,photo) values ('"+entity.getName()+"', '" +entity.getLastname()+"', '"+entity.getPhone()+"' ,' "+entity.getEmail() +"',' "	+ entity.getPassword()+"','"+entity.getUsername()+"' , '"+entity.getBirthdate()+" ' , "	+entity.getPhoto()+");" ;
		try {
						
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(User entity) {
		String  query = "update User set  name='"+entity.getName()+"' ,lastname='" +entity.getLastname()+"' "
				+ ", phone='"+entity.getPhone()+"' , email=' "+entity.getEmail() +"'"
						+ ",password=' "+ entity.getPassword()+"', username='"+entity.getUsername()+"',birthdate= '"+entity.getBirthdate()+"',photo="+entity.getPhoto()+  " where id = "+entity.getId()+";";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		String query="delete from user where id="+entity.getId()+";";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method
		String query="select * from user ;";
		ArrayList<User> users = new ArrayList();

		try {
			 result=statement.executeQuery(query);
		
		

		while (result.next()) {
			
				User user=new User(result.getInt("id") ,result.getString("name") , result.getString("lastname"),result.getString("phone"),result.getString("email") ,result.getString("password"),result.getString("username"),result.getString("birthdate") , result.getBoolean("isadmin"),result.getBlob("photo"));
		
				users.add(user);
		
	
		
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}
		

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		User user=null;
		String query =" select* from user where id="+id+" ;";
	try {
		
		result=statement.executeQuery(query);
		while (result.next()){
			 user=new User(result.getInt("id") ,result.getString("name") , result.getString("lastname"),result.getString("phone"),result.getString("email") ,result.getString("password"),result.getString("username"),result.getString("birthdate") , result.getBoolean("isadmin"),result.getBlob("photo"));

			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return user ;
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		String query="select * from user where name="+name+" ;";
		ArrayList<User> users = new ArrayList();

		try {
			 result=statement.executeQuery(query);
		
		

		while (result.next()) {
			
				User user=new User(result.getInt("id") ,result.getString("name") , result.getString("lastname"),result.getString("phone"),result.getString("email") ,result.getString("password"),result.getString("username"),result.getString("birthdate") , result.getBoolean("isadmin"),result.getBlob("photo"));
		users.add(user);
		
	
		
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	
		
	}
	
	

}
