package com.vermeg.bookstore.controller.pbook;
import com.vermeg.bookstore.model.PBook;
import com.vermeg.bookstore.service.implementation.ServicePBook;
import com.vermeg.bookstore.utils.Draft;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class ManagePbooks implements Initializable {

    @FXML
    private  TextField search;
    @FXML
    private CheckBox author;
    @FXML
    private CheckBox name;
    @FXML
    private AnchorPane mainpane;
    @FXML
    private TableView<PBook> listOfBooks;
    @FXML
    private TableColumn<PBook,String> title;
    @FXML
    private TableColumn<PBook,String> isbn;
    @FXML
    private TableColumn<PBook,String> description;
    @FXML
    private TableColumn quantite;
    @FXML
    private TableColumn prix;
    @FXML
    private TableColumn image;
    @FXML
    private TableColumn auteur;
    @FXML
    private TableColumn nbrpages;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }
    public synchronized void init(){
        System.out.println("okay");
        ServicePBook servicePBook = new ServicePBook();
        title.setCellValueFactory( new PropertyValueFactory<>("title"));
        quantite.setCellValueFactory( new PropertyValueFactory<PBook, String>("quantity"));
        prix.setCellValueFactory( new PropertyValueFactory<PBook, String>("price"));
        auteur.setCellValueFactory( new PropertyValueFactory<PBook,Integer>("author"));
        image.setCellValueFactory( new PropertyValueFactory<PBook, String>("photo"));
        isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        nbrpages.setCellValueFactory(new PropertyValueFactory<PBook,Integer>("nbr_pages") );
        try {
            listOfBooks.refresh();
            ArrayList<PBook> books =  servicePBook.findAll();
            books.forEach(System.out::println);
            ObservableList<PBook>  observableBooks= FXCollections.observableList(books);
            listOfBooks.getItems().removeAll(listOfBooks.getItems());
            listOfBooks.getItems().addAll(observableBooks);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void inititi(){
        System.out.println("rani nininttii");
        init();
    }
    @FXML
    private void addPBook(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../gui/addPBook.fxml"));
        init();
        mainpane.getChildren().removeAll(mainpane.getChildren());
        mainpane.getChildren().add(pane);
        System.out.println("inserted");
    }

    @FXML
    private void deletePBook(javafx.event.ActionEvent actionEvent) {
        ServicePBook pbk = new ServicePBook();
        try {
            pbk.deleteById(listOfBooks.getSelectionModel().getSelectedItem().getId());
            init();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    private void updatePBook(javafx.event.ActionEvent actionEvent) throws IOException {
        Draft.pbook = listOfBooks.getSelectionModel().getSelectedItem();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../gui/updatePBook.fxml"));
        mainpane.getChildren().removeAll(mainpane.getChildren());
        mainpane.getChildren().add(pane);

    }

    @FXML
    private void searchBooks(KeyEvent keyEvent) {
    }

    @FXML
    private void refresh(ActionEvent actionEvent) {
        inititi();
    }
}
