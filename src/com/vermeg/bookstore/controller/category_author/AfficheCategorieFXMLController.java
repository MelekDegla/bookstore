package com.vermeg.bookstore.controller.category_author;

import com.itextpdf.text.DocumentException;
import com.vermeg.bookstore.model.Categorie;
import com.vermeg.bookstore.model.PDF;
import com.vermeg.bookstore.service.implementation.CategorieService;
import com.vermeg.bookstore.utils.DBConnection;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AfficheCategorieFXMLController implements Initializable {

    @FXML
    private VBox categoriecontainer;
    @FXML
    private AnchorPane app;
    private Connection con;
    @FXML
    private TextField search;
    @FXML
    private ScrollPane scroll;
    @FXML
    private Button bt1;
    int n=1;

    public AfficheCategorieFXMLController() {
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



        categoriecontainer.setSpacing(5);
        try {
            displayCategorie();
        } catch (SQLException ex) {
            Logger.getLogger(AfficheCategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }




    }

    private void displayCategorie() throws SQLException {
        CategorieService pa = new CategorieService();
        String req = "select * from Categorie  ";
        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            java.sql.Date d1 = new java.sql.Date(rs.getDate(3).getTime());
            java.sql.Date d2 = new java.sql.Date(rs.getDate(4).getTime());

            Categorie a1 = new Categorie(rs.getString(1), rs.getString(2), d1, d2);
            Label libelle = new Label("Libelle : " + a1.getLibelle());
            Label description = new Label("Description : " + a1.getDescription());
            Label dateajout = new Label("Cette publication est ajouté le : " + a1.getDateajout());
            Label datemodif = new Label("Cette publication est modifé le : " + a1.getDatemodif());

            HBox h1 = new HBox();
            h1.setSpacing(10);
            h1.setAlignment(Pos.CENTER);
            h1.getChildren().addAll(libelle);
            HBox h2 = new HBox();
            h2.setSpacing(10);
            h2.setAlignment(Pos.CENTER);
            h2.getChildren().addAll(description);
            HBox h3 = new HBox();
            h3.setSpacing(10);
            h3.setAlignment(Pos.CENTER);
            h3.getChildren().addAll(dateajout);
            HBox h4 = new HBox();
            h4.setSpacing(10);
            h4.setAlignment(Pos.CENTER);
            h4.getChildren().addAll(datemodif);
            Button bt2=new Button("télécharger" ) ;
            bt2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) { //bitha heki chas

                    PDF pdf = new PDF();
                    System.out.println("Document téléchargé ");
                    try {
                        pdf.pdf(a1);

                    } catch (SQLException ex) {
                        Logger.getLogger(AfficheCategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DocumentException ex) {
                        Logger.getLogger(AfficheCategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(AfficheCategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    bt2.setDisable(true);





                }
            });

            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1, h2,h3,h4,bt2);

            HBox No = new HBox();
            No.setSpacing(10);
            No.setAlignment(Pos.CENTER);
            No.getChildren().addAll(v);

            VBox v1 = new VBox();
            v1.setAlignment(Pos.CENTER);
            v1.setSpacing(10);
            v1.getChildren().addAll(No);
            list.add(v1);

        }
        categoriecontainer.getChildren().addAll(list);
    }

    private void displayCategorieAvancee(String req) throws SQLException {
        CategorieService pa = new CategorieService();

        List<VBox> list = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            java.sql.Date d1 = new java.sql.Date(rs.getDate(3).getTime());
            java.sql.Date d2 = new java.sql.Date(rs.getDate(4).getTime());

            Categorie a1 = new Categorie( rs.getString(1), rs.getString(2), d1, d2);
            Label nom = new Label("Titre : " + a1.getLibelle());
            Label contenu = new Label("Le contenu : " + a1.getDescription());
            Label dateajout = new Label("Cette publication est ajouté le : " + a1.getDateajout());
            Label datemodif = new Label("Cette publication est modifé le : " + a1.getDatemodif());

            HBox h1 = new HBox();
            h1.setSpacing(10);
            h1.setAlignment(Pos.CENTER);
            h1.getChildren().addAll(nom);
            HBox h2 = new HBox();
            h2.setSpacing(10);
            h2.setAlignment(Pos.CENTER);
            h2.getChildren().addAll(contenu);
            HBox h3 = new HBox();
            h3.setSpacing(10);
            h3.setAlignment(Pos.CENTER);
            h3.getChildren().addAll(dateajout);
            HBox h4 = new HBox();
            h4.setSpacing(10);
            h4.setAlignment(Pos.CENTER);
            h4.getChildren().addAll(datemodif);
            Button bt2=new Button("télécharger" ) ;
            bt2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) { //bitha heki chas

                    PDF pdf = new PDF();
                    System.out.println("document téléchargé ");
                    try {
                        pdf.pdf(a1);

                    } catch (SQLException ex) {
                        Logger.getLogger(AfficheCategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DocumentException ex) {
                        Logger.getLogger(AfficheCategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(AfficheCategorieFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    bt2.setDisable(true);





                }
            });
            VBox v = new VBox();
            v.setAlignment(Pos.CENTER);
            v.setSpacing(10);
            v.getChildren().addAll(h1, h2,h3,h4,bt2);

            HBox No = new HBox();
            No.setSpacing(10);
            No.setAlignment(Pos.CENTER);
            No.getChildren().addAll(v);

            VBox v1 = new VBox();
            v1.setAlignment(Pos.CENTER);
            v1.setSpacing(10);
            v1.getChildren().addAll(No);
            list.add(v1);

        }
        categoriecontainer.getChildren().addAll(list);
    }


    @FXML
    private void recherche(ActionEvent event) throws SQLException {
        categoriecontainer.getChildren().removeAll(categoriecontainer.getChildren());
        String search11 = search.getText();
        String req ="select * from Categorie where libelle = '"+search11+"'";
        displayCategorieAvancee(req);
        if(search11.equals("")){
            req ="select * from Categorie";
            displayCategorieAvancee(req);

        }




    }

    @FXML
    private void triedate(ActionEvent event) throws SQLException {
        categoriecontainer.getChildren().removeAll(categoriecontainer.getChildren());
        String req = "select * from Categorie ORDER BY libelle  ";
        displayCategorieAvancee(req);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        setNode(FXMLLoader.load(getClass().getResource("/com/vermeg/bookstore/gui/category_author/CategorieFXML.fxml")));
    }


    private void setNode(Node node) {
        app.getChildren().clear();
        app.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.seconds(1));//dure de la translation
        ft.setNode(node);
        ft.setFromValue(0.10);//dispartion
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }

}
