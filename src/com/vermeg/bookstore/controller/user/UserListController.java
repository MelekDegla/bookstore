package com.vermeg.bookstore.controller.user;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vermeg.bookstore.model.User;
import com.vermeg.bookstore.service.implementation.UserServiceImpl;
import com.vermeg.bookstore.utils.DBConnection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;


public class UserListController implements Initializable {
    @FXML
    private AnchorPane usercontainer;

    private Connection con;

    private ObservableList<User> data;
@FXML
private  Button  btn3;
@FXML
private  Button  btn4;
    @FXML
    private  Button  btn5;

    @FXML
    private TableColumn<User, String> id;
    @FXML
    private TableColumn<User, String> username;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private TableColumn<User, Boolean> roles;
    @FXML
    private Button btn2;
    //private user cc=null;
    String img="";
    List<String> type;

    int n=1;
    @FXML
    private TableView<User> id_tableUser;
    @FXML
    private Button rt;

    public UserListController() {
        con = DBConnection.getInstance().getConnection();
    }
    private Statement ste;
    private PreparedStatement pre;
    String s1 = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        init();

    }

        @FXML
        void supprimerUser(ActionEvent event){

            User usertab = (User) id_tableUser.getSelectionModel().getSelectedItem();
//
            if (usertab != null) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Look, a Confirmation Dialog");
                alert.setContentText("Voulez vous vraiment supprimer cet utilisateur  ?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {

                    UserServiceImpl crud = new UserServiceImpl();
                    //ParentCrud parents = new ParentCrud();
                    User u = new User();
                    u.setId(usertab.getId());

                    crud.delete(u);
                    init();


                } else {
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("ooops ! vous devez selectionner un utilisateur ");

                    alert.showAndWait();
                }

            }

        }
    @FXML
    void toAdmin(ActionEvent event){

        User usertab = (User) id_tableUser.getSelectionModel().getSelectedItem();
//
        if (usertab != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Voulez vous changer l'utilisateur vers admin  ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                UserServiceImpl crud = new UserServiceImpl();
                //ParentCrud parents = new ParentCrud();
                User u = new User();
                u.setId(usertab.getId());

                crud.toadmin(u);
                init();


            } else {
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("ooops ! vous devez selectionner un utilisateur ");

                alert.showAndWait();
            }

        }

    }

    private void init() {
        data = FXCollections.observableArrayList();

        UserServiceImpl myListe = new UserServiceImpl();

        data.addAll(myListe.afficherlisteUtilisateurs());
        data.forEach(System.out::println);
        id.setCellValueFactory(new PropertyValueFactory<User, String>("id"));
        username.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        email.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        roles.setCellValueFactory(new PropertyValueFactory<User, Boolean>("isAdmin"));

        // id_tableUser.setItems(null);
        id_tableUser.getItems().removeAll(id_tableUser.getItems());
        id_tableUser.getItems().addAll(data);

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
@FXML
    void versdashbord(){
        // eli thez lil dashbord ya melek boutton home
}
}



