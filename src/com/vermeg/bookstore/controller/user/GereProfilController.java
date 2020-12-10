package com.vermeg.bookstore.controller.user;


import com.vermeg.bookstore.model.User;
import com.vermeg.bookstore.service.implementation.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.vermeg.bookstore.controller.user.LoginController.loadWindow;

public class GereProfilController implements Initializable{

    @FXML
    private TextField username;

    @FXML
    private TextField email;


    @FXML
    private PasswordField password;

    @FXML
    private Label labelusername;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelconfEmail;


    @FXML
    private ImageView ImporterImage;

    @FXML
    private Label inscrirLabel;
    @FXML
    private DatePicker birth ;

    @FXML
    private Button addBtn;

    @FXML
    private TextField nom;

    @FXML
    private Button annulerBtn;

    @FXML
    private Label labelPhone;

    @FXML
    private TextField prenom;

    @FXML
    private TextField phone;

    @FXML
    private Button ImporterImagePath;

    @FXML
    private Label labelImage;

    @FXML
    private ImageView usernameCheck;

    @FXML
    private ImageView emailCheck;

    @FXML
    private ImageView ccnfirmation_emailCheck;

    @FXML
    private ImageView nomCheck;

    @FXML
    private ImageView genreCheck;

    @FXML
    private ImageView passwordCheck;

    @FXML
    private ImageView phoneCheck;

    @FXML
    private ImageView prenomCheck;

    @FXML
    private ImageView rolesCheck;

    @FXML
    private ImageView Confirmation_passwordCheck;

    @FXML
    private ImageView date_naissanceCheck;

    @FXML
    private ImageView date_inscritCheck;

    @FXML
    private ImageView ImporterImageCheck;

    @FXML
    private Label labelnom;

    @FXML
    private Label labelprenom;

    @FXML
    private Label labeldate_inscrit;
    @FXML
    private  Button changer ;

    @FXML

    private Label labeldate_naissance;
    private UserServiceImpl Services = new UserServiceImpl();
    String path;
    File selectedFile;

    //les verification qui va faire pour confirmer la registration
    private boolean verificationUserName;
    private boolean verificationUserEmail;
    private boolean verificationUserPhone;
    private boolean verificationUserpasword;
    private boolean verificationImage;

    private boolean verificationUserNom;
    private boolean verificationUserPrenom;
    //les verfication de la mot de passe
    boolean containsDigit = false;
    boolean containsLowerCaseLetter = false;
    boolean containsUpperCaseLetter = false;
    boolean containsSpecialCharacter = false;
    boolean length = false;


    String img="";
    List<String>type;
    User n =  UserSession.user;
    public void initialize(URL url, ResourceBundle rb) {

        try {
            // TODO
            type=new ArrayList<>();
            type.add("*.jpg");
            type.add("*.png");

            UserServiceImpl user_ser= new UserServiceImpl();
            User uu = new User();
            if(n == null)
                n = new User();

            User u =user_ser.getuser(n);

            nom.setText(n.getName());
            prenom.setText(n.getLastname());
            email.setText(n.getEmail());
          //  password.setText(n.getPassword());


            username.setText(n.getUsername());
            phone.setText(n.getPhone());
            labelImage.setText(n.getPhoto());


        } catch (SQLException ex) {
            Logger.getLogger(GereProfilController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
@FXML
     void image(ActionEvent event) {
        FileChooser f=new FileChooser();

        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpeg,png files", type));
        File fc=f.showOpenDialog(null);
        if(f!= null)
        {
            System.out.println(fc.getName());
            img=fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
            ImporterImage.setImage(i);
        }
    }



    @FXML
    private void handleButtonConfirmar(ActionEvent event) throws SQLException, IOException {

        UserServiceImpl cs = new UserServiceImpl();
        User uu = new User();
        uu.setUsername(n.getUsername());
        User u =cs.getuser(uu);


        String nnom = nom.getText();
        String pprenom = prenom.getText();

        String uusername = username.getText();

        String eemail = email.getText();
        String imag = labelImage.getText();
        LocalDate d = birth.getValue();
        Date date= java.sql.Date.valueOf(d);
       u.setBirthdate(date);
        String pho =phone.getText();
        User us =new  User(u.getId(),nnom,pprenom,pho,eemail,u.getPassword(),uusername,date,false,imag);
        cs.update(us);
        JOptionPane.showMessageDialog(null, "parametre modifié");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../gui/GererProfil.fxml"));


    }

    @FXML
    void handleButtonCancelar(ActionEvent event) {
        ///yimchi lil home
        //labelusername.getScene().getWindow().hide();
       // loadWindow(getClass().getResource("/com/vermeg/bookstore/gui/Login.fxml"), "Registration", null);

    }
    @FXML
    void versChangerMp(ActionEvent event) throws IOException {
        // labelusername.getScene().getWindow().hide();
        // loadWindow(getClass().getResource("/com/vermeg/bookstore/gui/ChangerMp.fxml"), "Registration", null);
        labelusername.getScene().getWindow().hide();
        loadWindow(getClass().getResource("/com/vermeg/bookstore/gui/user/ChangerMp.fxml"), "Registration", null);



}}

