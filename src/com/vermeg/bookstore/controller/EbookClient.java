package com.vermeg.bookstore.controller;

import com.dansoftware.pdfdisplayer.PDFDisplayer;
import com.vermeg.bookstore.model.Ebook;
import com.vermeg.bookstore.service.IEBookService;
import com.vermeg.bookstore.service.implementation.ServiceEbook;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.omg.IOP.ServiceIdHelper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EbookClient implements Initializable {

    public GridPane grayda;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ServiceEbook bs = new ServiceEbook();
        ArrayList<Ebook> bookLIST = new ArrayList<>();
        try {
             bookLIST = bs.findAll();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

         int col = 0;
       int lig = 0;
        for(Ebook e : bookLIST){
            grayda.add(addElement(e), col , lig);
            if(col==3){
                col=0;
                lig++;
            }else {
                col++;
            }


        }





               /* Button button = new Button();
                ImageView imageView = new ImageView();
                Image image = new Image("/com/vermeg/bookstore/Images/the zen art book.png" );*/

             /*   imageView.setImage(image);
                imageView.setFitWidth(115);
                imageView.setFitHeight(145);
                button.setText("pdf");

                anchorPane.getChildren().add(imageView);
                anchorPane.getChildren().add(button);
                anchorPane.prefHeight(30);
                anchorPane.prefWidth(30);*/



        }

private  VBox addElement(Ebook b){
        VBox vb = new VBox();
    Button button = new Button();
    button.setText("API");
    ImageView imageView = new ImageView();
    System.out.println(b.getPhoto());
    Image image = new Image("/com/vermeg/bookstore/Images/"+ b.getPhoto() );
    imageView.setImage(image);
    imageView.setFitWidth(115);
    imageView.setFitHeight(145);
    vb.getChildren().add(imageView);
    vb.getChildren().add(button);
    button.setOnAction(event -> {

        PDFDisplayer displayer = new PDFDisplayer();

        Stage primaryStage =new Stage();
        primaryStage.setScene(new Scene(displayer.toNode())); // to create the javaFX object from the displayer, you have to use the toNode() function
        primaryStage.show();

        try {
            displayer.displayPdf(new File(b.getFileURL()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    });
        return vb;
    }

   @FXML
    private void DisplayPDF(ActionEvent event) throws SQLException{

    }

}
