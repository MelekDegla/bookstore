package com.vermeg.bookstore;

import com.vermeg.bookstore.model.Feedback;
import com.vermeg.bookstore.service.implementation.ServiceFeedback;
import com.vermeg.bookstore.utils.DBConnection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainFeedback extends Application {



    @Override

    public void start(Stage stage)  {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("gui/feedback/getFeedbackVisitorFXML.fxml"));
          //  Parent root = FXMLLoader.load(getClass().getResource("gui/feedback/getFeedbackAdminFXML.fxml"));
             //Parent root = FXMLLoader.load(getClass().getResource("gui/feedback/AddFeedbackFXML.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("gui/feedback/AnswerFeedbackAdminFXML.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
