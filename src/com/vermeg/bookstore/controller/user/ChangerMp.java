package com.vermeg.bookstore.controller.user;

import com.vermeg.bookstore.model.User;
import com.vermeg.bookstore.service.Password;
import com.vermeg.bookstore.service.implementation.UserServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import static sun.plugin.security.JDK11ClassFileTransformer.init;

public class ChangerMp {
    User n =  UserSession.user;

    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private TextField ancien;
    @FXML
    private TextField nv ;
    public void initialize(URL url, ResourceBundle rb) {


        init();

    }


   // public void changerpass (ActionEvent event) throws SQLException {

    @FXML
    void vershome(){
        //yhez lil home ya melek
    }

    @FXML

    public void changerpass(javafx.event.ActionEvent event) throws SQLException {

        UserServiceImpl cs =new UserServiceImpl();
        User uu = new User();
        uu.setUsername(n.getUsername());
        User u =cs.getuser(uu);
        //User u = new User();
        String mp =nv.getText();
        String passCrypt = Password.hashPassword(mp).trim();
        User us =new  User(u.getId(),u.getName(),u.getLastname(),u.getPhone(),u.getEmail(),passCrypt,u.getUsername(),u.getBirthdate(),false,u.getPhoto());
        cs.update(us);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("mot de passe");
        alert.setHeaderText("update");
        alert.setContentText("vous avez changer le mot de passe");
        alert.show();

    }

    public void exit(javafx.event.ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Vous allez quitter l'application");
        alert.setHeaderText("Vous allez quitter l'application");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        } else {
            alert.close();
        }

    }
}