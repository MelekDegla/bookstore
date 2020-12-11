package com.vermeg.bookstore.controller.user;/*package com.vermeg.bookstore.controller;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import com.nexmo.client.NexmoClientException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vermeg.bookstore.model.User;
import com.vermeg.bookstore.service.Password;
import com.vermeg.bookstore.service.implementation.ServiceCryptage;
import com.vermeg.bookstore.service.implementation.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;






public class ResetmpController implements Initializable {

    @FXML
    private Label inscrirLabel;
    @FXML
    private Button login;
    @FXML
    private Button signup;
    @FXML
    private TextField labelPhone;
    @FXML
    private Button btnlogin;
    @FXML
    private Label labelmessage;



    //les verfication de la mot de passe
    boolean containsDigit = false;
    boolean containsLowerCaseLetter = false;
    boolean containsUpperCaseLetter = false;
    boolean containsSpecialCharacter = false;
    boolean length = false;
    private boolean verificationUserpasword;
    private boolean verificationUserConfirmpasword;
    ServiceCryptage serviceCryptage=new ServiceCryptage();
      UserServiceImpl myServices=new UserServiceImpl();


    boolean verificationUserEmail;
    @FXML
    private Label labelpassword;
    @FXML
    private Label labelcontainsDigit;
    @FXML
    private Label labelcontainsLowerCaseLetter;
    @FXML
    private Label labelpasswordcontainsUpperCaseLetter;
    @FXML
    private Label labelpasswordcontainsSpecialCharacter;
    @FXML
    private Label labelpasswordlength;
    @FXML
    private Label labelConfirmationMdp;
    @FXML
    private PasswordField NewPassword;
    @FXML
    private PasswordField ConfirmNewPassword;
    @FXML
    private TextField labelUsername;
    @FXML
    private Label labelConfirmeUsername;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       labelPhone.setVisible(false);
        btnlogin.setVisible(false);
        ConfirmNewPassword.setVisible(false);
        NewPassword.setVisible(false);
        labelpassword.setVisible(false);
        labelcontainsDigit.setVisible(false);
        labelcontainsLowerCaseLetter.setVisible(false);
        labelpasswordcontainsUpperCaseLetter.setVisible(false);
        labelpasswordcontainsSpecialCharacter.setVisible(false);
        labelpasswordlength.setVisible(false);
        labelConfirmationMdp.setVisible(false);


    }

    public static void loadWindow(URL loc, String title, Stage parentStage) {
        try {
            Parent parent = FXMLLoader.load(loc);
            Stage stage = null;
            if (parentStage != null) {
                stage = parentStage;
            } else {
                stage = new Stage(StageStyle.DECORATED);
            }
            Scene scene = new Scene(parent);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void closeApplication(MouseEvent event) {
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

    @FXML
    private void Pagelogin(ActionEvent event) {
        labelPhone.getScene().getWindow().hide();
        loadWindow(getClass().getResource("/caritaspidev/GUI/login.fxml"), "Dashboard", null);
    }

    /**
     * *************************Pour l'envoie d'un SMS***************************
     */
    Random rand = new Random();
    String codeverifieChagepassword = String.valueOf(rand.nextInt(9000) + 1000);
    public static final String API_KEY = "f6e893da";
    public static final String API_SECRET = "WbL63MZXI5cgWJkn";

    public void sendsms(String numtel) throws IOException {
        String ACCOUNT_SID = "AC7cd950c4ccbc45295140fc238bf4603a";
        String AUTH_TOKEN = "cc8c069b4d8c90542b973fb096b5f5c9";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String verifMessage = "Votre code de vérification est " + codeverifieChagepassword;
        Message message = Message.creator(new PhoneNumber("+216"+labelPhone.getText()),
                new PhoneNumber("+21629772516"),
                verifMessage).create();
          System.out.println(numtel);

        //  AuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
        //  NexmoClient client = new NexmoClient(auth);
        //System.out.println(codeverifieChagepassword);



        //  client.getSmsClient().submitMessage(
        //  new TextMessage("Caritas", numtel, "Votre code de vérification est : " + codeverifieChagepassword));
    }

    public boolean verifconfirmCodeSMS(String code) {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Confirmez votre recuperation MDP");
        dialog.setHeaderText("Un sms vous a été envoyé  contenant  votre code");
        dialog.setContentText("Entrez votre code de confirmation:");
        Optional<String> result = dialog.showAndWait();
        if (result.get().equals(code)) {

            if (result.get().equals(code)) {
                return true;
            }
        } else {
            return verifconfirmCodeSMS(code);
        }
        return false;
    }
    @FXML
    private void controlMdp(KeyEvent event) {

        String PAS = NewPassword.getText().trim();

        if (PAS.length() >= 6) {// Check for Digits in password
//•	Contains at least 1 numeric digit
            labelpasswordlength.setText("longeur just");
            verificationUserConfirmpasword = true;

            for (int i = 0; i < PAS.length(); i++) {
                char ch = PAS.charAt(i);

                if (Character.isDigit(ch)) {// Check for Digits in password
//•	Contains at least 1 numeric digit
                    labelcontainsDigit.setText("Contient un nombre");
                    containsDigit = true;
                }

                if (Character.isLetter(ch) && Character.isLowerCase(ch)) {// Check for Letters in password
//•	Contains at least 1 lower letter character
                    labelcontainsLowerCaseLetter.setText("Contient une lettre minus");
                    containsLowerCaseLetter = true;

                }

                if (Character.isLetter(ch) && Character.isUpperCase(ch)) {// Check for Letters in password
//•	Contains at least 1 upper letter character
                    labelpasswordcontainsUpperCaseLetter.setText("Contient une lettre majus");
                    containsUpperCaseLetter = true;

                }
                if (ch == '!' || ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*') {
//•	Contains at least 1 special character from the set: !@#$%^&*
                    labelpasswordcontainsSpecialCharacter.setText("Contient un lettre sepcial");
                    containsSpecialCharacter = true;

                }
                System.out.println(containsUpperCaseLetter + "containsUpperCaseLetter\n" + containsLowerCaseLetter + "containsLowerCaseLetter\n"
                        + containsDigit + "containsDigit\n" + containsSpecialCharacter + "containsSpecialCharacter\n\n\n");

                if (containsUpperCaseLetter && containsLowerCaseLetter && containsDigit && containsSpecialCharacter) {
                    labelpassword.setText("Mot de passe valide!");

                    verificationUserpasword = true;
                }

            }
        } else {
            labelpasswordlength.setText("Il faut 6 caractere");
            labelpassword.setText("Mot de passe  invalide!");
            length = false;
            verificationUserpasword = false;
            labelpasswordcontainsSpecialCharacter.setText("");
            containsSpecialCharacter = false;
            labelpasswordcontainsUpperCaseLetter.setText("");
            containsUpperCaseLetter = false;
            labelcontainsLowerCaseLetter.setText("");
            containsLowerCaseLetter = false;
            labelcontainsDigit.setText("");
            containsDigit = false;
        }

    }
    @FXML
    private void ConfirmMDP(KeyEvent event) {
        if (NewPassword.getText().equals(ConfirmNewPassword.getText())) {
            labelConfirmationMdp.setText("Mot de passe valide!");
            verificationUserConfirmpasword = true;
        } else {
            labelConfirmationMdp.setText("Verifier votre mot de passe");
            verificationUserConfirmpasword = false;
        }

    }

    @FXML
    private void verifPhone(KeyEvent event) {

        String username=labelUsername.getText().trim();
        User user=myServices.chercherUtilisateurByUsername(username);
        if ( myServices.chercherUtilisateurByPhoneUsername(labelPhone.getText().trim(),username) != null && user!=null) {
            labelmessage.setText("Phone et Username sont justes");
            User u = new User();
            u = myServices.chercherUtilisateurByPhoneUsername(labelPhone.getText(),username);

            String numtel = "+216" + labelPhone.getText();

            System.out.println(numtel);
            try {
                sendsms(numtel);
                if (verifconfirmCodeSMS(codeverifieChagepassword) == true) {
                    labelPhone.setVisible(false);
                    labelUsername.setVisible(false);
                    labelConfirmeUsername.setVisible(false);
                    btnlogin.setVisible(true);
                    labelmessage.setVisible(false);
                    labelPhone.setVisible(false);
                    ConfirmNewPassword.setVisible(true);
                    NewPassword.setVisible(true);
                    labelpassword.setVisible(true);
                    labelcontainsDigit.setVisible(true);
                    labelcontainsLowerCaseLetter.setVisible(true);
                    labelpasswordcontainsUpperCaseLetter.setVisible(true);
                    labelpasswordcontainsSpecialCharacter.setVisible(true);
                    labelpasswordlength.setVisible(true);
                    labelConfirmationMdp.setVisible(true);

                }

            } catch (IOException ex) {
                Logger.getLogger(ResetmpController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ResetmpController.class.getName()).log(Level.SEVERE, null, ex);
            }

            verificationUserEmail = true;
        }
        if (myServices.chercherUtilisateurByPhoneUsername(labelPhone.getText().trim(),username) == null) {//alphanumerique@alphanumerique.com

            labelmessage.setText("Phone  invalide pour ton username !");
            verificationUserEmail = false;

        }

    }

    @FXML
    private void handleRestMDPButtonAction(ActionEvent event) {

        if (verificationUserConfirmpasword && verificationUserpasword) {

            String mdpcrypte = Password.hashPassword(NewPassword.getText().trim());
            myServices.changepassword(mdpcrypte, labelPhone.getText().trim());

            System.out.println("succes");


            labelPhone.getScene().getWindow().hide();
            loadWindow(getClass().getResource("../gui/Login.fxml"), "Login", null);




        } else {
        }


    }

    @FXML
    private void Pageregister(ActionEvent event) {

        labelPhone.getScene().getWindow().hide();
        loadWindow(getClass().getResource("/gui/Register.fxml"), "Registration", null);
    }

    @FXML
    private void verifUsername(KeyEvent event) {

        String username=labelUsername.getText().trim();

        if (myServices.chercherUtilisateurByUsername(username)!=null) {
            labelConfirmeUsername.setText("Username Valide");
            labelPhone.setVisible(true);



        } else {
            labelConfirmeUsername.setText("Username invalide");
            labelPhone.setVisible(false);
            labelPhone.setText("");
            labelmessage.setVisible(false);
        }



    }

}
