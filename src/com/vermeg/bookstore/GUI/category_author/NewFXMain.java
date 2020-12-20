package com.vermeg.bookstore.gui.category_author;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class NewFXMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {


       Parent root = FXMLLoader.load(getClass().getResource("statAuthor.fxml"));
     // Parent root = FXMLLoader.load(getClass().getResource("author.fxml"));
        // root = FXMLLoader.load(getClass().getResource("CategorieFXML.fxml"));
       //Parent root = FXMLLoader.load(getClass().getResource("AfficheCategorieFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
