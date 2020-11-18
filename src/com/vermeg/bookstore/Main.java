package com.vermeg.bookstore;

import com.vermeg.bookstore.utils.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main  {




    public static void main(String[] args) {
        DBConnection.getInstance().getConnection();
//        launch(args);
    }
}
