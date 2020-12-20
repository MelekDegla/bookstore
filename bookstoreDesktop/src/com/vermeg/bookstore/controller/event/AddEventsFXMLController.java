package com.vermeg.bookstore.controller.event;

import com.vermeg.bookstore.model.Events;
import com.vermeg.bookstore.service.implementation.EventsService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class AddEventsFXMLController implements Initializable {
    @FXML
    private TextField tfeventname;
    @FXML
    private TextField tfeventlocation;
    @FXML
    private TextField tfmaxp;
    @FXML
    private TextField tfeventcontext;
    @FXML
    private Button btnsubmit;
    @FXML
    private Button btncancel;
    @FXML
    private Label LbErreur;
@FXML
private DatePicker tfeventdate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.btnsubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //public void handler(ActionEvent event){
                Events e = new Events();
                e.setTitle(AddEventsFXMLController.this.tfeventname.getText());
                e.setLieu(AddEventsFXMLController.this.tfeventlocation.getText());
                e.setMAX_PARTICIPANTS(Integer.parseInt(AddEventsFXMLController.this.tfmaxp.getText()));
                e.setDescription(AddEventsFXMLController.this.tfeventcontext.getText());
                String  string = tfeventdate.getValue().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                 String time = string;
                SimpleDateFormat format = new SimpleDateFormat("MMMM d, yyyy");
                System.out.println(time);



                try {
                   Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(time);
                    System.out.println(date1.toString());

                    e.setDate(new java.sql.Date(date1.getTime()));
                } catch (ParseException parseException) {
                    System.err.println("erruer " + parseException);
                }

                if (e.getLieu().length() >= 5 && (e.getMAX_PARTICIPANTS() <= 250 && e.getMAX_PARTICIPANTS() > 0) && e.getTitle().length() >= 5
                        && e.getDescription().length() >= 20) {
                    EventsService es = new EventsService();
                    try {
                        es.insert(e);

                    } catch (SQLException var8) {
                        AddEventsFXMLController.this.LbErreur.setText("Erreur de base de données");

                    } finally {
                        AddEventsFXMLController.this.tfeventcontext.setText("");
                        AddEventsFXMLController.this.tfeventlocation.setText("");
                        AddEventsFXMLController.this.tfmaxp.setText("");
                        AddEventsFXMLController.this.tfeventcontext.setText("");
                        AddEventsFXMLController.this.tfeventdate.setValue(LocalDate.now());
                    }
                }else{
                    AddEventsFXMLController.this.LbErreur.setText("vérifier les données entrez");
                }

            }


        });
        this.btncancel.setOnAction(new EventHandler<ActionEvent>() {
@Override
         public void handle(ActionEvent event) {

          }
            }






        );
    }
}

