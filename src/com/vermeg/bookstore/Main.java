package com.vermeg.bookstore;

import com.vermeg.bookstore.model.Author;
import com.vermeg.bookstore.service.AuthorService;
import com.vermeg.bookstore.service.CategorieService;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class Main  {




    public static void main(String[] args) {
        DBConnection.getInstance().getConnection();
//        launch(args);

      /*  try {

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception" );
        }*/

    }
}
