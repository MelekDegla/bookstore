package com.vermeg.bookstore.controller;

import com.vermeg.bookstore.model.Author;
import com.vermeg.bookstore.model.Ebook;
import com.vermeg.bookstore.service.implementation.ServiceEbook;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AjouterController implements Initializable{



    @FXML
    private TextField tftitle ;
    @FXML
    private TextField tfauthor ;
    @FXML
    private TextField tfdecription ;
    @FXML
    private TextField tffile;
    @FXML
    private TextField tfprice ;
    @FXML
    private TextField tfphoto ;
    @FXML
    private Button btadd;
    @FXML
    private Button btupdate;
    @FXML
    private Button btdelete;
    @FXML
    private TableView<Ebook> tftable;
    @FXML
    private TableColumn<Ebook,String> tvtitle;
    @FXML
    private TableColumn<Ebook, Integer> tvauthor;
    @FXML
    private TableColumn<Ebook,String> tvdescription;
    @FXML
    private TableColumn<Ebook,String> tvfile;
    @FXML
    private TableColumn<Ebook,String> tvprice;
    @FXML
    private TableColumn<Ebook,String> tvphoto;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showBooks();
    }



    public ObservableList<Ebook> getEbookList(){
        ObservableList<Ebook> ebooklist = FXCollections.observableArrayList();
        try {
            ebooklist.addAll(new ServiceEbook().findAll());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ebooklist;

    }

    public void showBooks(){
        ObservableList<Ebook> list = getEbookList();
        tvtitle.setCellValueFactory(new PropertyValueFactory<Ebook, String>("title"));
        tvauthor.setCellValueFactory(new PropertyValueFactory<Ebook, Integer>("author"));
        tvdescription.setCellValueFactory(new PropertyValueFactory<Ebook, String>("description"));
        tvfile.setCellValueFactory(new PropertyValueFactory<Ebook, String>("file_url"));
        tvprice.setCellValueFactory(new PropertyValueFactory<Ebook,String>("price"));
        tvphoto.setCellValueFactory(new PropertyValueFactory<Ebook, String>("photo"));
        tftable.setItems(list);
    }




    public void add(ActionEvent actionEvent) {
        Ebook e = new Ebook();
        e.setTitle(tftitle.getText());
        e.setAuthor(tfauthor.getLength());
        e.setDescription(tfdecription.getText());
        e.setFileURL(tffile.getText());
        e.setPrice(tfprice.getLength());
        e.setPhoto(tfphoto.getText());

        ServiceEbook se = new ServiceEbook();
        try {
            se.insert(e);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            tftitle.setText("");
            tfdecription.setText("");
            tfauthor.setText("");
            tffile.setText("");
            tfprice.setText("");
            tfphoto.setText("");
        }
        showBooks();


    }


    public void delete(ActionEvent actionEvent){
        ObservableList<Ebook> ebookList = getEbookList();
        tftable.getItems().removeAll();
       // System.out.println();

        ServiceEbook se = new ServiceEbook();
        try {
            se.deleteById(tftable.getSelectionModel().getSelectedItems().get(0).getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        showBooks();

    }


    public void update(ActionEvent actionEvent) {
        ObservableList<Ebook> ebooklist = getEbookList();

        final List<Ebook> items = tftable.getItems();
        if( items == null || items.size() == 0) return;

        final Ebook e = tftable.getSelectionModel().getSelectedItems().get(0);
        if(!tftitle.getText().equals("")){
            e.setTitle(tftitle.getText());
        }
        if(!tfdecription.getText().equals("")){
            e.setDescription(tfdecription.getText());
        }
        if(!tffile.getText().equals("")){
            e.setFileURL(tffile.getText());
        }
        if(!tfprice.getText().equals("")){
            e.setPrice(Float.parseFloat(tfprice.getText().toString()));
        }
        if(!tfphoto.getText().equals("")){
            e.setPhoto(tfphoto.getText());
        }

        ServiceEbook se = new ServiceEbook();
        try {
            se.update(e);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tftable.getItems().removeAll();
        showBooks();
      /*  items.remove(0);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                items.add(0, item);
            }
            });*/
    }
}






