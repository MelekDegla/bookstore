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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;



import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class getFeedbackVisitorFXMLController implements Initializable  {
    @FXML
    private VBox vboxlist;
    @FXML
    private Label LbSubject;

    @FXML
    private Button LbSend;
    @FXML
    private Label LbDate;
    @FXML
    private Label answered;
    @FXML
    private Hyperlink show;



    @FXML
    private TextArea LbMessage;
    ArrayList<Feedback> feedbacks;
    HBox old=new HBox();
    int id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            feedbacks = new ServiceFeedback().findAllByUser(15);//connected user
        } catch (SQLException ex) {
            Logger.getLogger(getFeedbackAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Label title=new Label("Subjects");
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

        LbSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("../../gui/feedback/AddFeedbackFXML.fxml"));
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

       

    }

    public HBox convertFeedback(Feedback f) {
        Label lbSubject = new Label(f.getSubject());

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
            if (f.getIs_answered()==1){
                answered.setText("YES");
                show.setVisible(true);
                show.setOnAction(event1 -> {
                    Stage dialogStage = new Stage();
                    dialogStage.initModality(Modality.WINDOW_MODAL);
                    Button ok=new Button("OK");
                    VBox vbox = new VBox(new Text(f.getAnswer()), ok);
                    vbox.setAlignment(Pos.CENTER);
                    vbox.setPadding(new Insets(15));
                    ok.setOnAction(event2 -> {
                        dialogStage.close();
                    });
                    dialogStage.setScene(new Scene(vbox));
                    dialogStage.show();
                });

            }else{
                answered.setText("NO");
                show.setVisible(false);

            }
            answered.setStyle("-fx-font-weight:bold");

            LbDate.setText(f.getCreated_at().toString());
            LbSubject.setText(f.getSubject());
            LbMessage.setText(f.getMessage());
        });
        createdat.setWrapText(true);

        personneGraphique.getChildren().add(lbSubject);
        personneGraphique.getChildren().add(createdat);
        personneGraphique.setPadding(new Insets(10,0,10,5));
        return personneGraphique;
    }



}

