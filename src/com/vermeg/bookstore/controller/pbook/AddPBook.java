package com.vermeg.bookstore.controller.pbook;

import com.vermeg.bookstore.model.PBook;
import com.vermeg.bookstore.service.implementation.ServicePBook;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class AddPBook implements Initializable {
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
    private ImageView photo;
    @FXML
    private AnchorPane mainpane;
    @FXML
    private TextField nbrpage;
    private String photoText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    @FXML
    private void close(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/manage_pbooks.fxml"));

        AnchorPane pane = loader.load();
        mainpane.getChildren().removeAll(mainpane.getChildren());
        mainpane.getChildren().add(pane);
        ManagePbooks managePbooks = ((ManagePbooks) loader.getController());
        managePbooks.inititi();

    }

    @FXML
    private void submit(javafx.event.ActionEvent actionEvent) throws IOException {
        float price = Float.parseFloat(this.price.getText());
        String desc = description.getText();
        int quantity = Integer.parseInt(this.quantity.getText());
        String isbn = this.isbn.getText();
        String title = this.title.getText();
        //    String auteur= this.auteur.getText();
        int auteur = Integer.parseInt(this.auteur.getText());
        int nbrpages = Integer.parseInt(this.nbrpage.getText());
        ServicePBook spb = new ServicePBook();
        PBook pbook = new PBook(0, quantity, isbn, title, auteur, desc, photoText, price, nbrpages);
        close(null);
        try {
            spb.insert(pbook);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    private void uploadimage(ActionEvent actionEvent) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(null);
        File file = jFileChooser.getSelectedFile();
        System.out.println(file.getName());
        Image image = new Image("/com/vermeg/bookstore/resources/" + file.getName());

        photo.setImage(image);
    }

    @FXML
    private void refresh(ActionEvent actionEvent) {
//        auteur     .setText(String.valueOf(Draft.pbook.getAuteur()));
//        isbn       .setText(Draft.pbook.getIsbn());
//        description.setText(Draft.pbook.getDescription());
//        quantity   .setText(Draft.pbook.getQuantity()+"");
//        price      .setText(Draft.pbook.getPrice() + "");
//        title      .setText(Draft.pbook.getTitle());
//        photo      .setImage(null);
//        nbrpage  .setText(Draft.pbook.getNbrPage() + "");
//    }
    }
}

