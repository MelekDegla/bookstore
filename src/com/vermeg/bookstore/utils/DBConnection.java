package com.vermeg.bookstore.utils;
import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DBConnection {
    private static DBConnection instance;

    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private final String USERNAME= "root";
    private final String PASSWORD= "";
    private static Connection connection;
    private DBConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("success");
        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

    }

    public static void dbConnect() throws SQLException,ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");

        } catch(ClassNotFoundException e){
            System.out.println("Where is mysql JDBC Driver ? ");
            e.printStackTrace();
            throw e;
        }
        System.out.println("JDBC Driver has been registered");
        try{
            connection = DriverManager.getConnection(URL,"root","root");
        } catch(SQLException e){
            System.out.println("Connection failed "+e);
            throw e;
        }
    }

    public static  synchronized DBConnection getInstance(){
        if(instance== null){
            instance  = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
