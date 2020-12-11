package com.vermeg.bookstore.controller.user;


import com.vermeg.bookstore.model.User;
import com.vermeg.bookstore.service.implementation.UserServiceImpl;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController implements Initializable {
    @FXML
    private Label inscrirLabel;

    @FXML
    private Button login;

    @FXML
    private Button signup;

    @FXML
    private TextField labelusername;

    @FXML
    private PasswordField labelpassword;

    @FXML
    private Hyperlink labelmdo;


    @FXML
    private Button btnlogin;

    @FXML
    private ImageView imgProgress;
    private User loggedUser;
    private static LoginController instance;
    public static final Map<Integer, User> USERS = new HashMap<>();

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
    private Label message;
    @FXML
    private AnchorPane pane;




    public LoginController() {
        instance = this;
    }

    public static LoginController getInstance() {
        return instance;
    }


    public User getLoggedUser() {
        return loggedUser;
    }



    private void gotoLogin() {
        try {
            loadWindow(getClass().getResource("gui/Login.fxml"), "Dashboard", null);


        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public void userLogout(){
        loggedUser = null;
        gotoLogin();
    }


    @FXML
    void Pagelogin(ActionEvent event) {

    }

    @FXML
    private void Pagerecupmdp(ActionEvent event) {
       // labelusername.getScene().getWindow().hide();
        //loadWindow(getClass().getResource("../gui/Resetmdp.fxml"), "Resetmdp", null);


        try {
           AnchorPane page = FXMLLoader.load(getClass().getResource("../gui/Resetmdp.fxml"));
            pane.getChildren().setAll(page);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML

    void Pageregister(ActionEvent event) throws IOException {

        AnchorPane page=FXMLLoader.load(getClass().getResource("../../gui/user/register.fxml"));

        pane.getChildren().setAll(page);
//        labelusername.getScene().getWindow().hide();
//        loadWindow(getClass().getResource("/com/vermeg/bookstore/gui/register.fxml"), "Registration", null);

    }








    @FXML
    void Signup(MouseEvent event) {

    }

    @FXML
    void closeApplication(MouseEvent event) {

    }

    @FXML
    void handleLoginButtonAction(ActionEvent event) {
        UserServiceImpl myServices = new UserServiceImpl();
        String mdp=labelpassword.getText();
        String username=labelusername.getText();


        String errorMessage = "";

        if (username == null || username.length() == 0) {
            errorMessage += "Username invalide \n";
        }

        if (mdp  == null || mdp.length() == 0) {
            errorMessage += "Mot de passe invalide \n";
        }

        if (errorMessage.length() != 0) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error valeur");
            alert.setHeaderText("Invalide input");
            alert.setContentText(errorMessage);
            alert.show();
        } else {


            Boolean pas=myServices.verifierpassword(mdp, username);

            if (myServices.chercherUtilisateurBylogin(username) && pas==true) {
                User user = new User();
                user.setUsername(username);
                try {
                    UserSession.user = myServices.getuser(user);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if (myServices.Gettype(username)) {
                    imgProgress.setVisible(true);
                    PauseTransition pauseTransition = new PauseTransition();
                    pauseTransition.setDuration(Duration.seconds(3));
                    pauseTransition.setOnFinished(ev -> {
                        System.out.println("hello Admin");


                        User userConnecter=myServices.chercherUtilisateurByUsername(username);
//yimchi dashbord admin
                loadWindow(getClass().getResource("/com/vermeg/bookstore/gui/main/main.fxml"), "Registration", null);
                      labelusername.getScene().getWindow().hide();
                      /* Notifications n = Notifications.create()
                                .title("Bienvenue")
                               .text("Vous étes connecté en tant que Administrateur!")
                                .graphic(null)

                                .hideAfter(Duration.seconds(5));
                        n.show();*/
                    });
                    pauseTransition.play();
                }


                if (!myServices.Gettype(username)) {
                    imgProgress.setVisible(true);
                    PauseTransition pauseTransition = new PauseTransition();
                    pauseTransition.setDuration(Duration.seconds(3));
                    pauseTransition.setOnFinished(ev -> {
                        System.out.println("hello user");
                        labelusername.getScene().getWindow().hide();
                        loadWindow(getClass().getResource("/com/vermeg/bookstore/gui/main/main2.fxml"), "Registration", null);

                        //yimchi lil interface mta3 user catalogue ya melek wala homepage
                        User userConnecter=myServices.chercherUtilisateurByUsername(username);
                        labelusername.getScene().getWindow().hide();
                       /* Notifications n = Notifications.create()
                                .title("Bienvenue")
                                .text("Vous étes connecté !")
                                .graphic(null)
                                .position(Pos.TOP_CENTER)
                                .hideAfter(Duration.seconds(5));
                        n.showInformation();*/

                    });
                    pauseTransition.play();
                }





            }else
            {

               /* Notifications n = Notifications.create()
                        .title("Bienvenue")
                        .text("Username ou mot de passe invalide!")
                        .graphic(null)
                        .position(Pos.TOP_CENTER)
                        .hideAfter(Duration.seconds(5));
                n.showInformation();/*
                */
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error valeur");
                alert.setHeaderText("Invalide input");
                alert.setContentText(errorMessage);
                alert.show();



            }
        }


    }
    @FXML
    void quitter(MouseEvent event){
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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgProgress.setVisible(false);

    }




}

