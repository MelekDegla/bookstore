package com.vermeg.bookstore.controller.pbook;

import com.vermeg.bookstore.model.PBook;
import com.vermeg.bookstore.service.implementation.ServicePBook;
import com.vermeg.bookstore.utils.Draft;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UpdatePBook implements Initializable {
    @FXML
    AnchorPane mainpane;
    @FXML
    private TextField auteur;
    @FXML
    private TextField isbn;
    @FXML
    private TextField description;
    @FXML
    private TextField quantity;
    @FXML
    private TextField price;
    @FXML
    private TextField title;
    @FXML
    private Button    Submit;
    @FXML
    private TextField photo;

    @FXML
    private TextField nbrpage;



    @FXML
    private void close(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../../gui/pbook/manage_pbooks.fxml"));
        mainpane.getChildren().removeAll(mainpane.getChildren());
        mainpane.getChildren().add(pane);
    }

    @FXML
    private void submit(ActionEvent actionEvent) throws IOException {
        float price= Float.parseFloat(this.price.getText());
        String desc = description.getText();
        int quantity= Integer.parseInt(this.quantity.getText());
        String isbn= this.isbn.getText();
        String photo= this.photo.getText();
        String title=this.title.getText();
        int auteur = Integer.parseInt(this.auteur.getText());
        ServicePBook spb= new ServicePBook();
        PBook pbook= new PBook(Draft.pbook.getId(),quantity, isbn,title,auteur,desc,photo,price,0);
        initialize(null,null);
        close(null);

        try {
            spb.update(pbook);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(("error"));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        auteur     .setText(String.valueOf(Draft.pbook.getAuteur()));
        isbn       .setText(Draft.pbook.getIsbn());
        description.setText(Draft.pbook.getDescription());
        quantity   .setText(Draft.pbook.getQuantity()+"");
        price      .setText(Draft.pbook.getPrice() + "");
        title      .setText(Draft.pbook.getTitle());
        photo      .setText(Draft.pbook.getPhoto());
        nbrpage  .setText(Draft.pbook.getNbrPage() + "");


    }

    public static class ClientPBooks implements Initializable {
        @FXML
        private AnchorPane mainpain;
        @FXML
        private GridPane grid;
        @FXML
        private ImageView I1;
        @FXML
        private ImageView I2;
        @FXML
        private ImageView I3;
        @FXML
        private ImageView I6;
        @FXML
        private ImageView I9;
        @FXML
        private ImageView I5;
        @FXML
        private ImageView I8;
        @FXML
        private ImageView I4;
        @FXML
        private ImageView I7;
        @FXML
        private Pagination pagination=new Pagination(1,5);

        @Override
        public void initialize(URL location, ResourceBundle resources) {
    //        CardPane cardPane = new CardPane();
    //        cardPane.getItems().addAll( label("Card 1"), label("Card 2"), label("Card 3"));
    //
    //        private Label label( String caption ) {
    //            Label label = new Label( caption );
    //            label.setStyle("-fx-padding:10;");
    //            return label;
    //        }
        }



    }
}
