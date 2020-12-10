package com.vermeg.bookstore.controller.event;

import com.vermeg.bookstore.service.implementation.EventsService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DeletEventsFXMLController implements Initializable {

    @FXML
    private TextField Tfsupp;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void supprimer(javafx.event.ActionEvent actionEvent) {

        try {
            EventsService es = new EventsService();
            int id = Integer.valueOf(Tfsupp.getText());
            es.deleteById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
