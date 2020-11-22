package com.vermeg.bookstore.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;

    private final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private final String USERNAME= "root";
    private final String PASSWORD= "";
    private Connection connection;
    private DBConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("success");
        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }

    }

    public static synchronized DBConnection getInstance(){
        if(instance== null){
            instance  = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
