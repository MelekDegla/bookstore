package com.vermeg.bookstore.controller.event;

import com.vermeg.bookstore.model.Events;
import com.vermeg.bookstore.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class ValidParticipationController {

    @FXML public Label label1;
    @FXML public TextField tfTitle;
    @FXML public TextField tfPlace;
    @FXML public TextField tfParticipation;
    //@FXML public TextArea tfDescription;
    @FXML public TextField tfdate;
    @FXML public TextField tfnumber;
    @FXML public TextField tfname;
   @FXML public TextArea tfDescription;

    public void setAll(String title, String lieu, String participant,String date, String description ){
        Events e =new Events();
        User u= new User();
        this.tfTitle.setText(title);
        //date = e.getDate().toLocalDate();
        this.tfdate.setText(date);
        this.tfPlace.setText(lieu);
        this.tfParticipation.setText(participant);
        this.tfDescription.setText(description);


    }
    @FXML public TextField tfemail;

    @FXML public Button btnvalider;
    public void setLabelText(String text, Label label){
        label.setText(text);
        this.label1 = label;
    }

    public void validerParticipation(ActionEvent actionEvent) {
        System.out.println(this.tfnumber.getText());


        //////////////////////////////////////////////////////
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put( "mail.smtp.port", "587");
            properties.put("mail.smtp.ssl.trust","smtp.gmail.com");
            String myAccountEmail ="friends.online.bookstore@gmail.com";
            String password = "friendsforever2020";
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myAccountEmail,password);
                }
            });



            Message message= prepareMessage(session,myAccountEmail,tfemail.getText());
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message= new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            //message.setRecipient(Message.RecipientType,TO,new InternetAddress(recipient));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(tfemail.getText()));
            message.setSubject(tfTitle.getText());
            message.setText("hey "+tfname.getText()+","+"\n"+
                    "You are accepted to be one of us in "+tfTitle.getText()+"\n");
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }return null;



    }




}

