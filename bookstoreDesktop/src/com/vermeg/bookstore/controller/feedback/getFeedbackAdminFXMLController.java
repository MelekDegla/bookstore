package com.vermeg.bookstore.controller.feedback;


import com.jfoenix.controls.JFXTextField;
import com.vermeg.bookstore.model.Feedback;
import com.vermeg.bookstore.service.implementation.PassingDataService;
import com.vermeg.bookstore.service.implementation.ServiceFeedback;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class getFeedbackAdminFXMLController implements Initializable  {
    @FXML
    private VBox vboxlist;
    @FXML
    private Label LbFirstname;
    @FXML
    private Label LbLastname;
    @FXML
    private Label LbPhone;
    @FXML
    private Label LbEmail;
    @FXML
    private Label LbSubject;
    @FXML
    private JFXTextField LbSearch;
    @FXML
    private ImageView tfSearch;
    @FXML
    private Button LbAnswer;

    @FXML
    private TextArea LbMessage;
    ArrayList<Feedback> feedbacks;
    HBox old=new HBox();
    int id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            feedbacks = new ServiceFeedback().findAll();
        } catch (SQLException ex) {
            Logger.getLogger(getFeedbackAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Label title=new Label("From");
        title.setMinWidth(150);
        Label date=new Label("Date");
        HBox box=new HBox();
        box.getChildren().add(title);
        box.getChildren().add(date);
        box.setPadding(new Insets(10,0,10,5));
        box.setStyle("-fx-background-color: #49c7f0");
        vboxlist.getChildren().add(box);

        for (Feedback f: feedbacks){
            vboxlist.getChildren().add(convertFeedback(f));
        }

        LbAnswer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                    PassingDataService.setData(LbSubject.getText());
                    PassingDataService.email = LbEmail.getText();
                    PassingDataService.id=id;
                    Parent root = FXMLLoader.load(getClass().getResource("../../gui/feedback/AnswerFeedbackAdminFXML.fxml"));
                    Scene scene = new Scene(root);
                    Node node = (Node) t.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    System.out.println(e.getCause());
                    System.out.println(e.getMessage());
                }
            }
        });

        tfSearch.setOnMouseClicked((MouseEvent e )-> {
            ServiceFeedback sf= new ServiceFeedback();
            try {
                ArrayList<Feedback> list=sf.search(LbSearch.getText());
                vboxlist.getChildren().clear();



                vboxlist.getChildren().add(box);

                for (Feedback f: list){
                    vboxlist.getChildren().add(convertFeedback(f));
                }
                System.out.println(list);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

    }

    public HBox convertFeedback(Feedback f) {
        Label lbSubject = new Label(f.getLastname()+" "+f.getName());

        HBox personneGraphique = new HBox();


        lbSubject.setMinWidth(150);
        Label createdat =new Label(f.getCreated_at().toString());
        if (f.getIs_answered() == 0){
            lbSubject.setStyle("-fx-font-weight:bold");
            createdat.setStyle("-fx-font-weight:bold");
        }
        lbSubject.setWrapText(true);
        personneGraphique.setOnMouseClicked(event -> {
            id=f.getId();
            old.setStyle("-fx-background-color:white");
            personneGraphique.setStyle("-fx-background-color:lightgray");
            old=personneGraphique;
            LbFirstname.setText(f.getName());
            LbLastname.setText(f.getLastname());
            LbEmail.setText(f.getEmail());
            LbPhone.setText(f.getPhone());
            LbSubject.setText(f.getSubject());
            LbMessage.setText(f.getMessage());
        });
        createdat.setWrapText(true);

        personneGraphique.getChildren().add(lbSubject);
        personneGraphique.getChildren().add(createdat);
        personneGraphique.setPadding(new Insets(10,0,10,5));
        return personneGraphique;
    }

    @FXML
    public void search(){
    System.out.println("qsdf");
    }

}

