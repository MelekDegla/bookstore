package com.vermeg.bookstore.controller.category_author;


import com.vermeg.bookstore.model.Categorie;
import com.vermeg.bookstore.service.implementation.CategorieService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
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




public class CategorieFXMLController implements Initializable {
        @FXML
        private TableView<Categorie> table1;
        @FXML
        private TableColumn<Categorie,String> tablelibelle;
        @FXML
        private TableColumn<Categorie,String> tabledescription;
        @FXML
        private TableColumn<Categorie,String> tabledajout;
        @FXML
        private TableColumn<Categorie,String> tabledmodif;
        @FXML
        private TextField Libelle;
        @FXML
        private TextField description;

        @FXML
        private DatePicker dateajout;
        @FXML
        private DatePicker datemodif;
        String img="";
        List<String> type;

        private Categorie cc=null;
        @FXML
        private AnchorPane ap;
        @FXML
        private Button btnclose;
        @FXML
        private Label erreurcontenu;
        @FXML
        private Label erreurdateajout;
        @FXML
        private Label erreurdatemodif;
        @FXML
        private Label erreurtitre;
        @FXML
        private Button imagee;

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                afficher();
                type =new ArrayList();
                type.add("*.jpg");
                type.add("*.png");

                table1.setOnMouseClicked(new EventHandler<MouseEvent>(){

                        @Override
                        public void handle(MouseEvent event) {
                                cc = (Categorie)table1.getSelectionModel().getSelectedItem();
                                System.out.println(cc);
                                Libelle.setText(cc.getLibelle());
                                description.setText(cc.getDescription());
                                LocalDate d1=cc.getDateajout().toLocalDate();
                                LocalDate d2=cc.getDatemodif().toLocalDate();
                                dateajout.setValue(d1);
                                datemodif.setValue(d2);

                        }
                });
                Libelle.textProperty().addListener((observable, oldValue, newValue) -> {
                        if (!newValue.matches("\\sa-zA-Z*")) {
                                Libelle.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
                        }
                });
                Libelle.textProperty().addListener(new ChangeListener<String>()
                {
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                                if(newValue.isEmpty())
                                        erreurtitre.setText("remplir champ libelle");
                                else if(newValue.length()>200)
                                        erreurtitre.setText("Max champ libelle 200");
                                else
                                        erreurtitre.setText("");
                        }


                });
                Libelle.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                        @Override
                        public void handle(MouseEvent event) {
                                if(Libelle.getText().length()==0)
                                        erreurtitre.setText("remplir champ libelle");

                        }

                });
                description.textProperty().addListener(new ChangeListener<String>()
                {
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                                if(newValue.isEmpty())
                                        erreurcontenu.setText("remplir champ description");
                                else if(newValue.length()>200)
                                        erreurcontenu.setText("Max champ description 200");
                                else
                                        erreurcontenu.setText("");
                        }


                });
                description.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                        @Override
                        public void handle(MouseEvent event) {
                                if(description.getText().length()==0)
                                        erreurcontenu.setText("remplir champ description");

                        }

                });
                dateajout.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                        @Override
                        public void handle(MouseEvent event) {
                                if(dateajout.getValue()==null)
                                        erreurdateajout.setText("remplir champ date ajout");



                        }

                });
                dateajout.valueProperty().addListener((ov, oldValue, newValue) -> {
                        if(newValue==null)
                                erreurdateajout.setText("remplir champ date ajout");

                        else
                                erreurdateajout.setText("");


                });


                datemodif.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                        @Override
                        public void handle(MouseEvent event) {
                                if(datemodif.getValue()==null)
                                        erreurdatemodif.setText("remplir champ date modification");



                        }

                });
                datemodif.valueProperty().addListener((ov, oldValue, newValue) -> {
                        if(newValue==null)
                                erreurdatemodif.setText("remplir champ date modification");

                        else
                                erreurdatemodif.setText("");


                });




        }


        @FXML
        private void ajouter(ActionEvent event) {
                try {
                        if(Libelle.getText().isEmpty() || description.getText().isEmpty() )

                        {


                                JOptionPane.showMessageDialog(null, "verifer les champs");
                        }else{
                                String titre1 = Libelle.getText();
                                String contenu1 = description.getText();
                                LocalDate dd =dateajout.getValue();
                                LocalDate df =datemodif.getValue();
                                Date dateajout1 = java.sql.Date.valueOf(dd);
                                Date datemodif2 = java.sql.Date.valueOf(df);

                                CategorieService sp = new CategorieService();
                                Categorie e = new Categorie(titre1,contenu1,dateajout1,datemodif2);

                                sp.addCategorie(e);
                                JOptionPane.showMessageDialog(null, "ajout avec succes");
                                Libelle.clear();
                                description.clear();
                                dateajout.setValue(null);
                                datemodif.setValue(null);
                                afficher();}
                } catch (SQLException ex) {
                        Logger.getLogger(CategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }

        }

        @FXML
        private void modifier(ActionEvent event) {
                CategorieService cs = new CategorieService();
                System.out.println(cc);
                if(cc== null){
                        JOptionPane.showMessageDialog(null, "choisir catégorie");

                }else{



                        try {
                                LocalDate dd=dateajout.getValue();
                                LocalDate df=datemodif.getValue();
                                java.sql.Date d1=java.sql.Date.valueOf(dd);
                                java.sql.Date d2=java.sql.Date.valueOf(df);

                                if(img.length()==0)
                                        cs.update(new Categorie(cc.getId(),Libelle.getText(),description.getText(),d1,d2));
                                else
                                        cs.update(new Categorie(cc.getId(),Libelle.getText(),description.getText(),d1,d2));

                                afficher();
                                JOptionPane.showMessageDialog(null, "catégorie modifié");
                                Libelle.clear();
                                description.clear();
                                dateajout.setValue(null);
                                datemodif.setValue(null);

                                cc=null;
                        } catch (SQLException ex) {
                                Logger.getLogger(CategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }


        }

        @FXML
        private void supprimer(ActionEvent event) {
                CategorieService cs = new CategorieService();
                Categorie cc = (Categorie) table1.getSelectionModel().getSelectedItem();
                System.out.println(cc);
                if(cc== null){
                        JOptionPane.showMessageDialog(null, "choisir Catégorie");

                }else{
                        try {
                                cs.deleteById(cc.getId());

                                afficher();

                                JOptionPane.showMessageDialog(null, "Catégorie supprimé");
                                Libelle.clear();
                                description.clear();
                                dateajout.setValue(null);
                                datemodif.setValue(null);

                                cc=null;
                        } catch (SQLException ex) {
                                Logger.getLogger(CategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }


        }

        private void afficher()
        {    try {
                CategorieService sp = new CategorieService();
                List categories=sp.findAll();
                ObservableList et= FXCollections.observableArrayList(categories);
                table1.setItems(et);

                tablelibelle.setCellValueFactory(new PropertyValueFactory<>("Libelle"));
                tabledescription.setCellValueFactory(new PropertyValueFactory<>("description"));
                tabledajout.setCellValueFactory(new PropertyValueFactory<>("dateajout"));
                tabledmodif.setCellValueFactory(new PropertyValueFactory<>("datemodif"));


        } catch (SQLException ex) {
                Logger.getLogger(CategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }


        }

        @FXML
        public void closeApp() {

                Stage stage = (Stage) btnclose.getScene().getWindow();
                stage.close();
        }

        @FXML
        private void telecharger(ActionEvent event) throws IOException {
                FXMLLoader fxml=new FXMLLoader(getClass().getResource("/com/vermeg/bookstore/gui/category_author/AfficheCategorieFXML.fxml"));

                Parent root=fxml.load();
                ap.getScene().setRoot(root);
        }
        @FXML
        private void trier(ActionEvent event) {
                CategorieService sp = new CategorieService();
                List authors=sp.trieParnb();
                ObservableList et= FXCollections.observableArrayList(authors);
                table1.setItems(et);
                tablelibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
                tabledescription.setCellValueFactory(new PropertyValueFactory<>("description"));
                tabledajout.setCellValueFactory(new PropertyValueFactory<>("dateajout"));
                tabledmodif.setCellValueFactory(new PropertyValueFactory<>("datemodif"));


        }

}

