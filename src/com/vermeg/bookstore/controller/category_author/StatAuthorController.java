package com.vermeg.bookstore.controller.category_author;

import com.vermeg.bookstore.service.implementation.AuthorService;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StatAuthorController implements Initializable {

    @FXML
    private PieChart piechartID;
    @FXML
    private AnchorPane page1;
    @FXML
    private Button back_menu;
     ObservableList piechartlist= FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //
            stat();
        } catch (SQLException ex) {
            Logger.getLogger(StatAuthorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        piechartID.getData().addAll(piechartlist);

    }

    public void stat() throws SQLException
    {
        AuthorService a= new AuthorService();
        piechartlist= FXCollections.observableArrayList();
        ResultSet rs= a.statistic();
        while (rs.next())
        {
            piechartlist.add(new PieChart.Data(rs.getString(2),rs.getLong(2)));

        }

    }


    @FXML
    private void retour(ActionEvent event) throws IOException {
        setNode(FXMLLoader.load(getClass().getResource("../../gui/category_author/author.fxml")));
    }


    private void setNode(Node node) {
        page1.getChildren().removeAll(page1.getChildren());
        page1.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.seconds(1));//dure de la translation
        ft.setNode(node);
        ft.setFromValue(0.10);//dispartion
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }
}
