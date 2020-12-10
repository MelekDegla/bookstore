package com.vermeg.bookstore.controller.feedback;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.StringUtils;
import com.vermeg.bookstore.model.Feedback;
import com.vermeg.bookstore.service.implementation.ServiceFeedback;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddFeedbackFXMLController implements Initializable {
    @FXML
    private JFXTextField tfFirstname;
    @FXML
    private JFXTextField tfLastname;
    @FXML
    private JFXTextField tfPhone;
    @FXML
    private JFXTextField tfEmail;
    @FXML
    private JFXTextArea tfMessage;
    @FXML
    private JFXButton btnSend;
    @FXML
    private TextField tfSubject;
    @FXML
    private Label LbErreur;
    @FXML
    private Label LbSucess;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Feedback f = new Feedback();
                LbSucess.setText("");
                f.setName(tfFirstname.getText());
                f.setLastname(tfLastname.getText());
                f.setPhone(tfPhone.getText());
                f.setEmail(tfEmail.getText());
                f.setSubject(tfSubject.getText());
                f.setMessage(tfMessage.getText());
                boolean valide=true;

                String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
                Pattern pattern = Pattern.compile(masque);
                Matcher controler = pattern.matcher(tfEmail.getText());




                if ((f.getName().length() < 2) || (f.getLastname().length() < 2) && valide) {
                    LbErreur.setText("Please verify your firstname and your lastname");
                    valide=false;
                }
                if (((!StringUtils.isStrictlyNumeric(tfPhone.getText()) ) || (tfPhone.getText().length() !=8)) && valide) {
                    LbErreur.setText("Your phone must be as the following format 55666777 ");
                    valide=false;
                }
                if (!controler.matches() && valide) {
                    LbErreur.setText("Your email must be as the following format xyz@example.com");
                    valide=false;
                }
                if ((f.getSubject().length() < 3)  && valide) {
                    LbErreur.setText("Please write your subject");
                    valide=false;
                }


                //System.out.println(tfPhone.getText());
                if (valide) {
                    ServiceFeedback sp = new ServiceFeedback();
                    try {
                        sp.insert(f);
                        LbErreur.setText("");
                        LbSucess.setText("Thank you for contacting us! We will answer you as soon as possible");
                    } catch (SQLException ex) {
                        LbErreur.setText("Error of database");
                    } finally {
                        tfFirstname.setText("");
                        tfLastname.setText("");
                        tfPhone.setText("");
                        tfEmail.setText("");
                        tfSubject.setText("");
                        tfMessage.setText("");
                    }
                }

            }
        });

    }
}

