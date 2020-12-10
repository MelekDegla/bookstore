package com.vermeg.bookstore.controller.pbook;

import com.vermeg.bookstore.model.PBook;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import sun.awt.image.IntegerComponentRaster;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class ClientPBook implements Initializable {
    @FXML
    private AnchorPane mainpain;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane p1=new AnchorPane();
    @FXML
    private ImageView I1;
    @FXML
    private Button b1;
    @FXML
    private Hyperlink hyperlink;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PBook pBook = new PBook();
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
        });
    }



    public void displayBooks(Collection<PBook> pbooks){
        System.out.println("here");
    }


}
