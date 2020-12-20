package com.vermeg.bookstore.controller.category_author;

import com.vermeg.bookstore.model.Author;
import com.vermeg.bookstore.service.implementation.AuthorService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddAutherFXMLController implements Initializable {

    @FXML
    private TextField enom;
    @FXML
    private TextField eprenom;
    @FXML
    private TextField enblivre;
    @FXML
    private Label error_nb;
    @FXML
    private Label error_name;
    @FXML
    private Button imagee;
    @FXML
    private ImageView imageview;
    String img="";
    List<String> type;
    @FXML
    private Label error_prenom;
    @FXML
    private DatePicker edate;

    private Author cc=null;
    @FXML
    private Button eaj;
    @FXML
    private Button emod;
    @FXML
    private Button esup;
    @FXML
    private TableView<Author> table_author;
    @FXML
    private TableColumn<Author, Integer> id;
    @FXML
    private TableColumn<Author, String> eenom;
    @FXML
    private TableColumn<Author, String> eeprenom;
    @FXML
    private TableColumn<Author, String> eeimag;
    @FXML
    private TableColumn<Author, Date> eedate;
    @FXML
    private TableColumn<Author, Integer>eenblivre;
    @FXML
    private Button tri;
    private TextField search;
    private Button stat;
    @FXML
    private AnchorPane page;
    @FXML
    private Button gerer;
    @FXML
    private Button btnclose;


    @FXML
    private void importer(ActionEvent event) {
        FileChooser f=new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpeg,png",type));
        File fc=f.showOpenDialog(null);
        if(f!= null)
        {
            System.out.println(fc.getName());
            img=fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
            imageview.setImage(i);
        }
    }


    @FXML
    private void ajoutere(ActionEvent event) {
        try {
            if(enom.getText().isEmpty() || eprenom.getText().isEmpty() || enblivre.getText().isEmpty() )

            {


                JOptionPane.showMessageDialog(null, "verifer les champs");
            }else{
                String nom= enom.getText();
                String prenom = eprenom.getText();
                int nb = Integer.parseInt(enblivre.getText());
                LocalDate dd=edate.getValue();
                Date dateajout1 = java.sql.Date.valueOf(dd);


                AuthorService sp = new AuthorService();
                Author e = new Author(nom,prenom,dateajout1,img,nb);

                sp.insert(e);
                JOptionPane.showMessageDialog(null, "ajout avec succes");
                enom.clear();
                eprenom.clear();
                edate.setValue(null);
                enblivre.clear();
                afficher();}
        } catch (SQLException ex) {
            Logger.getLogger(CategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



    /*private void ajoutere(ActionEvent event) throws SQLException {
        AuthorService sp = new AuthorService();
        String nom = enom.getText();
        String prenom = eprenom.getText();
        int nblivres= Integer.parseInt(enblivre.getText());


        java.util.Date edate = java.sql.Date.valueOf(this.edate.getValue());

        Author e = new Author(nom,prenom,(Date) edate,img,nblivres);
        if(enom.getText().isEmpty() || eprenom.getText().isEmpty() )
        {

            JOptionPane.showMessageDialog(null, "verifer les champs");   }

        else{
            sp.insert(e);
            JOptionPane.showMessageDialog(null, "ajout avec succes");
            enom.clear();
            eprenom.clear();
            enblivre.clear();
            imageview.setImage(null);
            afficher();}}*/


    @FXML
    private void modifiere(ActionEvent event) throws SQLException {
        AuthorService cs = new AuthorService();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir auteur");

        }else{



            try {
                LocalDate dd=edate.getValue();
                Author e = new Author();
                java.sql.Date d1=java.sql.Date.valueOf(dd);
                int nblivres= Integer.parseInt(enblivre.getText());

                if(img.length()==0)
                    cs.update(new Author(cc.getId(),enom.getText(),eprenom.getText(),d1,img,nblivres));
                else
                    cs.update(new Author(cc.getId(),enom.getText(),eprenom.getText(),d1,img,nblivres));

                afficher();

                JOptionPane.showMessageDialog(null, "auteur modifié");
                eprenom.clear();
                enom.clear();
                enblivre.clear();
                imageview.setImage(null);
                edate.setValue(null);


                cc=null;
            } catch (SQLException ex) {
             //   Logger.getLogger(ActualiteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

    @FXML
    private void supprimere(ActionEvent event) throws SQLException {
        AuthorService cs = new AuthorService();
        Author cc = (Author) table_author.getSelectionModel().getSelectedItem();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir auteur");

        }else{
            cs.deleteById(cc.getId());

            afficher();

            JOptionPane.showMessageDialog(null, "auteur supprimé");

            enom.clear();
            eprenom.clear();
            enblivre.clear();
            imageview.setImage(null);
            edate.setValue(null);
        }
    }





    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(AddAutherFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        type =new ArrayList();
        type.add("*.jpg");
        type.add("*.png");
        table_author.setOnMouseClicked(new EventHandler<MouseEvent>()
                                      {
                                          @Override
                                          public void handle(MouseEvent event) {
                                              cc = (Author) table_author.getSelectionModel().getSelectedItem();
                                              System.out.println(cc);
                                              enom.setText(cc.getName());
                                              eprenom.setText(cc.getLastname());
                                              enblivre.setText(String.valueOf(cc.getNbLivres()));
                                              imageview.setImage(new Image(cc.getPhoto()));



                                            //  LocalDate d1=cc.getBirthdate().toLocalDate();

                                             // edate.setValue(d1);



                                          }


                                      }



        );


        enom.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.isEmpty())
                    error_name.setText("remplir champ titre");
                else if(newValue.length()>25)
                    error_name.setText("Max champ titre 25");
                else
                    error_name.setText("");
            }


        });
        enom.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {  if(enom.getText().length()==0)
                error_name.setText("remplir champ Nom");

            }

        });
        enom.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                enom.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });


        eprenom.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.isEmpty())
                    error_prenom.setText("remplir champ titre");
                else if(newValue.length()>25)
                    error_prenom.setText("Max champ titre 25");
                else
                    error_prenom.setText("");
            }


        });
        eprenom.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
                if(eprenom.getText().length()==0)
                    error_prenom.setText("remplir champ Description");

            }

        });
        eprenom.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                eprenom.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });

        eprenom.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.isEmpty())
                    error_prenom.setText("remplir champ titre");
                else if(newValue.length()>25)
                    error_prenom.setText("Max champ titre 25");
                else
                    error_name.setText("");
            }


        });
        eprenom.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
                if(eprenom.getText().length()==0)
                    error_prenom.setText("remplir champ titre");

            }

        });
        eprenom.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                eprenom.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
        enblivre.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {  if(enblivre.getText().length()==0)
                error_nb.setText("remplir champ Nom");

            }

        });







    }




    private void afficher() throws SQLException {
        AuthorService sp = new AuthorService();
        List authors=sp.findAll();
        ObservableList et=FXCollections.observableArrayList(authors);
        table_author.setItems(et);


        eenom.setCellValueFactory(new PropertyValueFactory<Author,String>("name"));
        eeprenom.setCellValueFactory(new PropertyValueFactory<Author,String>("lastname"));
        eenblivre.setCellValueFactory(new PropertyValueFactory<Author,Integer>("nbLivres"));
        eedate.setCellValueFactory(new PropertyValueFactory<Author,Date>("birthdate"));
        eeimag.setCellValueFactory(new PropertyValueFactory<Author,String>("photo"));

    }

   @FXML
   private void voirstat(ActionEvent event) throws IOException {
       AnchorPane pane=FXMLLoader.load(getClass().getResource("/com/vermeg/bookstore/gui/category_author/statAuthor.fxml"));
       page.getChildren().setAll(pane);
   }
    @FXML
    private void retourner(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/caritaspidev/main/Back.fxml"));
        page.getChildren().setAll(pane);
    }


    @FXML
    public void closeApp() {

        Stage stage = (Stage) btnclose.getScene().getWindow();
        stage.close();
    }

}

