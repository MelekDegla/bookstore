package com.vermeg.bookstore.controller.pbook;

import com.vermeg.bookstore.model.PBook;
import com.vermeg.bookstore.service.implementation.ServicePBook;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import sun.awt.image.IntegerComponentRaster;

import java.lang.reflect.Array;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class ClientPBook implements Initializable {

    @FXML
    private GridPane grid;

    int col = 0 ; int row = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ServicePBook servicePBook = new ServicePBook();

        try {


            servicePBook.findAll().forEach(p -> {
                HBox hBox = new HBox();
                hBox.setPadding(new Insets(20));
                hBox.setSpacing(10);

                ImageView imageView = new ImageView(new Image("file:///"+p.getPhoto()));
                imageView.setFitWidth(100);
                imageView.setFitHeight(150);
                VBox vBox = new VBox();
                vBox.setAlignment(Pos.CENTER);
                Button button = new Button("Add To Cart");
                button.setStyle("-fx-background-color: #00a98f; -fx-background-radius: 0px; -fx-text-fill: white;");
                vBox.getChildren().add(button);
                Hyperlink hyperlink = new Hyperlink("View more details");

                vBox.getChildren().add(hyperlink);
                hBox.getChildren().add(imageView);
                hBox.getChildren().add(vBox);
                hBox.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);" +
                        " -fx-background-color: white;" +
                        "-fx-padding: 5px;" +
                        "    -fx-border-insets: 5px;" +
                        "    -fx-background-insets: 5px;");
                grid.add(hBox, col, row) ;
                if(col == 2){
                    row++;
                    col=0;
                }else {
                    col++;
                }

            });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


       /* PBook pBook = new PBook();
        I1 = new ImageView("https://m.media-amazon.com/images/I/5102ogTDCGL.jpg");
        I1.setFitHeight(160);
        I1.setFitWidth(120);
        b1= new Button();
        b1.setText("Add to card");
        b1.setText("View");
        b1.setId(Integer.toString(pBook.getId()));
        hyperlink = new Hyperlink("View more details");
        b1.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 0px;");
        p1.setMaxHeight(Region.USE_COMPUTED_SIZE);
        p1.setMaxWidth(Region.USE_COMPUTED_SIZE);
        AnchorPane displayed = new  AnchorPane();
        displayed.setStyle("-fx-background-color: #ffffff;");
        displayed.getChildren().add(I1);
        displayed.getChildren().add(hyperlink);
        displayed.getChildren().add(b1);

        displayed.setOnMouseEntered(event -> {
            displayed.setStyle("-fx-background-color : #F4D504");
        });
        displayed.setOnMouseExited(event -> {
            displayed.setStyle("-fx-background-color : #ffffff");
        });*/
    }



    public void displayBooks(Collection<PBook> pbooks){
        System.out.println("here");
    }


}
