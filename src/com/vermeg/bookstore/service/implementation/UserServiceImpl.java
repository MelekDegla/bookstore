package com.vermeg.bookstore.service.implementation;

import com.vermeg.bookstore.model.User;
import com.vermeg.bookstore.service.Password;
import com.vermeg.bookstore.service.UserService;
import com.vermeg.bookstore.utils.DBConnection;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class UserServiceImpl implements UserService {
	private Statement statement; 
	private ResultSet result;
	private static UserServiceImpl instance;
	private Connection con;

//	public UserServiceImpl(){
//		con = DBConnection.getInstance().getConnection();
//	}

	public UserServiceImpl( ) {
		 try {
			 		con = DBConnection.getInstance().getConnection();

			 statement= con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  public static synchronized UserServiceImpl getInstance(){
	        if(instance== null){
	            instance  = new UserServiceImpl();
	        }
	        return instance;
	    }
	@Override
	public void insert(User entity)  {
		try {
			Date date = entity.getBirthdate();
			// TODO Auto-generated method stub
			String query = "insert into User ( name ,lastname , phone , email,password, username,birthdate,photo)" +
					" values ('"+entity.getName()+"', '" +entity.getLastname()+"', '"+entity.getPhone()+"' ,' "
					+entity.getEmail() +"',' "	+ entity.getPassword()+"','"+entity.getUsername()+"' , '"
					+new java.sql.Date(date.getTime())+" ' , '"	+entity.getPhoto()+"');" ;
			try {
//				statement = con.createStatement();
				statement.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@Override
	public void update(User entity) {
		try {
			Date date = entity.getBirthdate();
			String  query = "update User set  name='"+entity.getName()+"' ,lastname='" +entity.getLastname()+"' "
					+ ", phone='"+entity.getPhone()+"' , email=' "+entity.getEmail() +"'"
					+ ",password=' "+ entity.getPassword()+"', username='"+entity.getUsername()+
					"',birthdate= '"+new java.sql.Date(date.getTime()) +"',photo="+entity.getPhoto()+  " where id = "+entity.getId()+";";
			try {
				statement.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
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
	public void deleteById(int id) throws SQLException {

	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method
		String query="select * from user ;";
		ArrayList<User> users = new ArrayList();

		try {
			 result=statement.executeQuery(query);
		
		

		while (result.next()) {
			
				User user=new User(result.getInt("id") ,result.getString("name") , result.getString("lastname"),result.getString("phone"),result.getString("email") ,result.getString("password"),result.getString("username"), result.getDate("birthdate") , result.getBoolean("isadmin"),result.getString("photo"));
		
				users.add(user);

			System.out.println(user);
		
	
		
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
			 user=new User(result.getInt("id") ,result.getString("name") , result.getString("lastname"),result.getString("phone"),result.getString("email") ,result.getString("password"),result.getString("username"),result.getDate("birthdate") , result.getBoolean("isadmin"),result.getString("photo"));

			
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
			
				User user=new User(result.getInt("id") ,result.getString("name") , result.getString("lastname"),result.getString("phone"),result.getString("email") ,result.getString("password"),result.getString("username"),result.getDate("birthdate") , result.getBoolean("isadmin"),result.getString("photo"));
		users.add(user);
		
	
		
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	
		
	}

	public User chercherUtilisateurByUsername(String s) {
		User user = null;

		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement("select * from user where username =?");
			preparedStatement.setString(1, s);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				 user = new User(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getString("Lastname"),
						resultSet.getString("phone"),
						resultSet.getString("email"),
						resultSet.getString("password"),
						resultSet.getString("username"),
						resultSet.getDate("birthdate"),
						resultSet.getBoolean("isAdmin"),
						resultSet.getString("photo"));



			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (user == null) {
			return null;
		}
		return user;
	}
	public boolean chercherUtilisateurByEmail(String s) {
		User user = null;
		String req = "select * from user where email =?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setString(1, s);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = new User(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getString("Lastname"),
						resultSet.getString("phone"),
						resultSet.getString("email"),
						resultSet.getString("password"),
						resultSet.getString("username"),
						resultSet.getDate("birthdate"),
						resultSet.getBoolean("isAdmin"),
						resultSet.getString("photo"));


			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (user == null) {
			return false;
		}
		return true;
	}
	public boolean chercherUtilisateurBylogin(String s) {
		User user = null;
		String req = "select * from user where username =?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setString(1, s);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = new User(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getString("Lastname"),
						resultSet.getString("phone"),
						resultSet.getString("email"),
						resultSet.getString("password"),
						resultSet.getString("username"),
						resultSet.getDate("birthdate"),
						resultSet.getBoolean("isAdmin"),
						resultSet.getString("photo"));

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (user == null) {
			return false;
		}
		return true;
	}

	public Boolean verifierpassword(String pword, String uname) {
		String s1 = "";
		String req = "Select password from user where username= ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement =con.prepareStatement(req);
			preparedStatement.setString(1, uname);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				s1 = resultSet.getString(1);
				System.out.println(s1);
				s1 = s1.trim();
				System.out.println(s1);
				// String s2=uname+"{"+s1+"}";



				System.out.println("ili 3malnelou deccryptage==>"+ Password.checkPassword(pword,s1));
				//   System.out.println(uname);
				System.out.println(s1);


				if ( (Password.checkPassword(pword,s1))) {
					return true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;

	}
	public Boolean Gettype(String s) {
		boolean s1 = false;
		String req = "select isAdmin from user where username =?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setString(1, s);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				s1 = resultSet.getBoolean("isAdmin");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return s1;
	}

	public List<User> afficherlisteUtilisateurs() {


		List<User> myListe = new ArrayList<>();
		String requette2 = "select * from user";
		try {

			PreparedStatement pst2 = con.prepareStatement(requette2);
			ResultSet ResListe = pst2.executeQuery(requette2);

			while (ResListe.next()) {

				User p = new User();
				p.setId(ResListe.getInt("id"));
				p.setName(ResListe.getString("name"));
				p.setLastname(ResListe.getString("lastname"));
				p.setPhone(ResListe.getString("phone"));
				p.setEmail(ResListe.getString("email"));
				p.setPassword(ResListe.getString("password"));
				p.setUsername(ResListe.getString("username"));
				p.setPhoto(ResListe.getString("photo"));
//				java.sql.Date date = ResListe.getDate("birthdate");
//
//				p.setBirthdate(new SimpleDateFormat("dd/MM/yyyy")
//						.parse(date.getDate() +"/" +date.getMonth() + "/"+ date.getYear() ));
				p.setIsAdmin(ResListe.getBoolean("isAdmin"));


				System.out.println(p);
				myListe.add(p);

			}

		} catch (SQLException e) {

			System.err.println(e.getMessage());
		}


		return myListe;

	}


	public void toadmin(User entity) {
		String  query = "update User set  isAdmin=true where id="+entity.getId()+"; ";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public User getuser(User u) throws SQLException {
		User us = new User();
		PreparedStatement pre = con.prepareStatement("SELECT * FROM user WHERE username LIKE ? ;");

		pre.setString(1, u.getUsername());
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			int id_user = rs.getInt("id");
			String nom = rs.getString("name");
			String prenom = rs.getString("lastname");

			String phone = rs.getString("phone");
			String email = rs.getString("email");

			String mot_de_passe = rs.getString("password");
			String username = rs.getString("username");
			String photo = rs.getString("photo");
			 Date birthday=rs.getDate( "birthdate");
			 boolean role =rs.getBoolean("isAdmin");


			us.setId(id_user);
			us.setName(nom);
			us.setLastname(prenom);
			us.setPhone(phone);
			us.setEmail(email);
			us.setPassword(mot_de_passe);
			us.setUsername(username);
			us.setPhoto(photo);
			us.setBirthdate(birthday);
			us.setIsAdmin(role);






		}
		return us;

	}


	public User chercherUtilisateurByPhoneUsername(String r,String username) {
		User user = null;
		String req = "select * from user where phone =? and username=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setString(1, r);
			preparedStatement.setString(2, username);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				 user  = new User(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getString("Lastname"),
						resultSet.getString("phone"),
						resultSet.getString("email"),
						resultSet.getString("password"),
						resultSet.getString("username"),
						resultSet.getDate("birthdate"),
						resultSet.getBoolean("isAdmin"),
						resultSet.getString("photo"));



			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return user;
	}
	public void changepassword(String s1, String email) {
		try {
			String requete = "update user set password=? where email=? ";
			PreparedStatement preparedStatement = con.prepareStatement(requete);
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, email);

			preparedStatement.executeUpdate();
			System.out.println("Modification effectuée avec succés");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	public static void sendMail(String recepient) throws Exception {
		System.out.println("Preparing to send email");
		Properties properties = new Properties();

		//Enable authentication
		properties.put("mail.smtp.auth", "true");
		//Set TLS encryption enabled
		properties.put("mail.smtp.starttls.enable", "true");
		//Set SMTP host
		properties.put("mail.smtp.host", "smtp.gmail.com");
		//Set smtp port
		properties.put("mail.smtp.port", "587");

		//Your gmail address
		String myAccountEmail = "friends.online.bookstore@gmail.com";
		//Your gmail password
		String password = "friendsforever2020";

		//Create a session with account credentials
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		//Prepare email message
		Message message = prepareMessage(session, myAccountEmail, recepient);

		//Send mail
		Transport.send(message);
		System.out.println("Message sent successfully");
	}

	private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("friends bookstore");
			String htmlCode = "welcme to freinds bookstore";
			message.setContent(htmlCode, "text/html");
			return message;
		} catch (Exception ex) {
ex.printStackTrace();
			//Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}


}
