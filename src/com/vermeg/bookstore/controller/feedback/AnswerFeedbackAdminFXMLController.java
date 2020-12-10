package com.vermeg.bookstore.controller.feedback;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.vermeg.bookstore.model.Feedback;
import com.vermeg.bookstore.service.implementation.PassingDataService;
import com.vermeg.bookstore.service.implementation.ServiceFeedback;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class AnswerFeedbackAdminFXMLController implements Initializable {
    @FXML
    private JFXTextField txtFrom;
    @FXML
    private JFXTextField txtTo;
    @FXML
    private JFXTextField txtSubject;
    @FXML
    private JFXTextArea txtMessage;
    @FXML
    private JFXButton btnSend;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private Label LbSuccess;
    @FXML
    private Label LbError;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtSubject.setText(PassingDataService.getINSTANCE().getData());
        txtTo.setText(PassingDataService.email);

        btnSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Properties properties = new Properties();

                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");
                properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

                String myAccountEmail="friends.online.bookstore@gmail.com";
                String password="friendsforever2020";

                Session session = Session.getInstance(properties , new Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(myAccountEmail, password);
                    }
                });
                Message message = prepareMessage(session, myAccountEmail, txtTo.getText() );


                try {
                    ServiceFeedback serviceFeedback=new ServiceFeedback();

                    Transport.send(message);
                    Feedback f=new Feedback();
                    f.setId(PassingDataService.id);
                    f.setAnswer(txtMessage.getText());
                    serviceFeedback.updateAnswered(f);
                    LbError.setText("");

                    LbSuccess.setText("Your e-mail has been sent successfully!");
                } catch (MessagingException | SQLException e) {
                    e.printStackTrace();
                    LbError.setText("Error of database");
                }
                System.out.println("message sent successfully!");

            }
        });
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {


                    Parent root = FXMLLoader.load(getClass().getResource("../../gui/feedback/getFeedbackAdminFXML.fxml"));
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

    private Message prepareMessage(Session session, String myAccountEmail,String recepient){
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            System.out.println(txtSubject.getText());
            message.setSubject("[Reply] "+txtSubject.getText());
            message.setText(txtMessage.getText());
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void myFunction(String text){
        txtSubject.setText(text);
    }


}