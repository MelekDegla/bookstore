package com.vermeg.bookstore.controller.event;

import com.vermeg.bookstore.model.Events;
import com.vermeg.bookstore.model.User;
import com.vermeg.bookstore.service.implementation.EventsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ClientEventDisplayController implements Initializable {
    ObservableList<Events> Eventss = FXCollections.observableArrayList();

    public AnchorPane page;
    public TableColumn colTitle;
    public TableView tvEvents;
    public TableColumn colPlace;
    public TableColumn colParticipation;
    public TableColumn colDate;
    public TableColumn colDescription;
    public Label label;
    public TextField chercher;
    User u = new User(20, "sami", "ben aissia", "27348409", "samibenaissia6@gmail.com", "aaaaaaaaaa", "sami0115", null, null, null);
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    public Button participate;

    public void InitColumn() {
        try {


            EventsService es = new EventsService();
            List events = es.findAll();
            ObservableList et = FXCollections.observableArrayList(events);

            tvEvents.setItems(et);
            colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colPlace.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            colParticipation.setCellValueFactory(new PropertyValueFactory<>("MAX_PARTICIPANTS"));
            colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        } catch (SQLException ex) {

            ex.printStackTrace();

        }

    }
    String titre;
    String description;
    String participant;
    String lieu;
    String date;
    String name;
    String num;

    public void buttonClicked() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/vermeg/bookstore/gui/event/ValidParticipationEventsFXML.fxml"));
            Parent root = loader.load();

            Stage primaryStage = new Stage();
            tvEvents.setRowFactory(tv -> {
                TableRow<Events> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && (!row.isEmpty())) {
                        TablePosition pos = (TablePosition) tvEvents.getSelectionModel().getSelectedCells().get(0);
                        int index = pos.getRow();

                        Events selected = (Events) tvEvents.getItems().get(index);

                        titre = selected.getTitle();
                        description = selected.getDescription();
                        participant = String.valueOf(selected.getMAX_PARTICIPANTS());
                        lieu = selected.getLieu();
                        date = String.valueOf(selected.getDate());



                        String rowData = String.valueOf(row.getItem());


                        label.setText(rowData);
                    }
                });
                return row;
            });

            ValidParticipationController ValidParticipationController = loader.getController();

            ValidParticipationController vs = loader.getController();
            vs.setAll(titre, lieu, participant, date, description);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Participate Confirmation");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InitColumn();
        buttonClicked();
    }
}

