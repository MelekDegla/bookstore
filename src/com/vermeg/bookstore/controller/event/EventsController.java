package com.vermeg.bookstore.controller.event;

import com.vermeg.bookstore.model.Events;
import com.vermeg.bookstore.service.implementation.EventsService;
import com.vermeg.bookstore.utils.DBConnection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class EventsController implements Initializable {

@FXML
    public AnchorPane page;
    public Label LbErreur;
    public TextArea test;
    public TextArea tfDescription;
    @FXML private DatePicker tfDate;
    @FXML private TextField tfTitle;
    @FXML private TextField tfPlace;
    @FXML private TextField tfParticipation;
    //@FXML private TextField tfDescription;
    @FXML private TableView<Events> tvEvents;
    @FXML private TableColumn<Events,String> colTitle;
    @FXML  private TableColumn<Events,String> colPlace;
    @FXML private TableColumn<Events,Integer> colParticipation;
    @FXML private TableColumn<Events, Date> colDate;
    @FXML private TableColumn<Events,String> colDescription;
    @FXML private Button btnInsert;
    @FXML private Button btnUpdate;
    @FXML private Button btnDelete;
    int id=0;

    public void HandleButtonAction(ActionEvent actionEvent) {
 if (actionEvent.getSource()==btnUpdate){
     updateEvent();
 }else if(actionEvent.getSource()==btnDelete){
     deleteButton();
 }
 }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InitColumn();
    }
    

      public ObservableList<Events> getEventsList(){
          ObservableList<Events> EventsList = FXCollections.observableArrayList();
        try{
            DBConnection cnx=DBConnection.getInstance();
            String req ="select * from Events";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req);
            while(rs.next()){
                Events e = new Events();
                e.setTitle(rs.getString("Title"));
                e.setLieu(rs.getString("Lieu"));
                e.setMAX_PARTICIPANTS(rs.getInt("MAX_PARTICIPANTS"));
                e.setDescription(rs.getString("description"));
                e.setID(rs.getInt("ID"));

                EventsList.add(e);
            }
        }
        catch(Exception ex){
        ex.printStackTrace();
        }
        return EventsList;
    }
    public void InitColumn(){

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
      }catch (SQLException ex){

          ex.printStackTrace();

      }
        tvEvents.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Events>() {
            @Override
            public void changed(ObservableValue<? extends Events> observable, Events oldValue, Events newValue) {

                Events e=(Events)tvEvents.getSelectionModel().getSelectedItem();
                System.out.println(e);
                tfTitle.setText(e.getTitle());
                tfPlace.setText(e.getLieu());
                tfDescription.setText(e.getDescription());
                tfParticipation.setText(String.valueOf(e.getMAX_PARTICIPANTS()));
                LocalDate d = e.getDate().toLocalDate();
                tfDate.setValue(d);
                id=newValue.getID();
            }
        });

    }
    @FXML
    private void ajouter(ActionEvent event) {

        try {
            String titre = tfTitle.getText();
            String description = tfDescription.getText();
            int maxparti = Integer.parseInt(tfParticipation.getText());
            String place = tfPlace.getText();
            LocalDate d = tfDate.getValue();
            Date date= java.sql.Date.valueOf(d);

            EventsService es = new EventsService();
            Events e = new Events(titre,description,date,maxparti,place);


            if (e.getTitle().length() <= 5 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Look, Problem insert item");
                alert.setContentText(" le titre doit avoir 5 caractéres au minimum  !");
                alert.showAndWait();}else

            if (e.getLieu().length() <= 5) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Look, Problem insert item");
                alert.setContentText("  le lieu doit avoir 5 caractéres au minimum  !");
                alert.showAndWait();

            }


                else
            if (e.getMAX_PARTICIPANTS() >= 250 && e.getMAX_PARTICIPANTS() > 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Look, Problem insert item");
                alert.setContentText(" les participants ne doivent pas dépassez 250 personnes  !");
                alert.showAndWait();}
                    else
                        if (e.getDescription().length() <= 20) {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Warning Dialog");
                            alert.setHeaderText("Look, Problem update item");
                            alert.setContentText(" la description doit avoir 20 caractéres au minimum  !");
                            alert.showAndWait();}
                else{
                es.insert(e);
                InitColumn();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

/*private void voirstat (ActionEvent es) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/com/vermeg/bookstore/GUI/AddEventsFXML.fxml"));
        page.getChildren().setAll(pane);
}*/

@FXML
private void ChangeScreenButtonPushed(ActionEvent evente) throws IOException {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/AddEventsFXML.fxml"));
        Stage stage = (Stage) btnUpdate.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }catch (IOException io){
        io.printStackTrace();
    }
}
    private void updateEvent(){
        String query = "UPDATE  Events SET Title ='" + tfTitle.getText() + "', lieu = '" + tfPlace.getText() + "', description='"
                + tfDescription.getText() + "', MAX_PARTICIPANTS=" + tfParticipation.getText() + " WHERE id= " +id;
        executeQuery(query);
        InitColumn();
    }
    private void deleteButton(){
        String query = "DELETE FROM Events WHERE id =" + id ;
        executeQuery(query);
        InitColumn();
    }
    private void executeQuery(String query) {

        try{
            DBConnection cnx=DBConnection.getInstance();
            Statement st;
            st= cnx.getConnection().createStatement();
             st.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
