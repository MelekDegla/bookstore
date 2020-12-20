/*
 * Copyright (C) Gleidson Neves da Silveira
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.vermeg.bookstore.gui.main;

import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXBadge;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import org.controlsfx.control.PopOver;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  08/10/2018
 * Version 2.0
 */
public class Main implements Initializable {

    public Image im;
    public AnchorPane content;
    @FXML private GNAvatarView avatar;
    @FXML public  VBox sideBar;
    @FXML private HBox searchBox;
    @FXML private HBox boxStatus;
    @FXML private VBox info;
    @FXML private VBox views;
    @FXML private Circle cStatus;
    @FXML private Label status;
    @FXML public  ScrollPane body;
    @FXML public  Label title;
    @FXML private TextField search;
    @FXML private ScrollPane scroll;
    @FXML private TitledPane design;
    @FXML private TitledPane controls;
    @FXML private TitledPane charts;
    @FXML private Button home;
    @FXML private Button  about;
    @FXML private Button hamburger;
    @FXML private SVGPath searchIcon;
    @FXML private StackPane root;
    @FXML private Button clear;
    @FXML private JFXButton config;
    @FXML private VBox drawer;
    @FXML private JFXBadge messages;
    @FXML private JFXBadge notifications;
    @FXML private JFXBadge bg_info;
    @FXML private ToggleGroup group;

    @FXML private RadioButton available;

    private FilteredList<Button> filteredList = null;

    public static  final PopOver popConfig = new PopOver();
    public static  final PopOver popup     = new PopOver();

    private ObservableList<Button> items         = FXCollections.observableArrayList();
    private ObservableList<Button> designItems   = FXCollections.observableArrayList();
    private ObservableList<Button> controlsItems = FXCollections.observableArrayList();
    private ObservableList<Button> chartsItems   = FXCollections.observableArrayList();

    private JFXDialog       dialog          = new JFXDialog();
    private JFXDialogLayout dialog_layout   = new JFXDialogLayout();

    private String path = "/com/gn/theme/css/";
    boolean scrolling   = false;

    private Parent popContent;
    public static Main ctrl;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ctrl = this;
//        loadContentPopup();

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                cStatus.setFill( ((RadioButton) newValue).getTextFill());
                status.setText(((RadioButton)newValue).getText());
            }
        });



        populateItems();
        filteredList = new FilteredList<>(items, s -> true);

        search.textProperty().addListener(obs -> {

            String filter = search.getText();
            if (filter == null || filter.length() == 0) {
//                barInitial();
                clear.setMouseTransparent(true);
                searchIcon.setContent("M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z");
            } else {
//                barFiltered(filter);
                clear.setMouseTransparent(false);
                searchIcon.setContent("M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z");

            }
        });
    }
    @FXML
    private void openConfig(){
        if(popConfig.isShowing()){
            popConfig.hide();
        } else {
            popConfig.show(config, 0);
            popConfig.getRoot().setFocusTraversable(true);
        }
    }
    private void populateItems() {

        for (Node node : views.getChildren()) {
            if (node instanceof Button) {
                items.add( (Button) node);
            }
        }

        for (Node node : ((VBox) controls.getContent()).getChildren()) {
            controlsItems.add((Button) node);
            items.add((Button) node);
        }


    }

    @FXML
    private void clearText(){
        search.clear();
    }


    @FXML
    private void checkBox(){
       }


    @FXML
    private void choiceBox(){
       }


    @FXML
    private void dashboard(){
       }


    public void pbookNav(MouseEvent mouseEvent) {
        try {
            AnchorPane anchorPane= FXMLLoader.load(getClass().getResource("../pbook/manage_pbooks.fxml"));
            content.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ebookNav(MouseEvent mouseEvent) {
        try {
            AnchorPane anchorPane= FXMLLoader.load(getClass().getResource("../AjouterFXML.fxml"));
            content.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void authorNav(MouseEvent mouseEvent) {
        try {
            AnchorPane anchorPane= FXMLLoader
                    .load(getClass()
                            .getResource("../category_author/author.fxml"));
            content.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void categoryNav(MouseEvent mouseEvent) {
        try {
            AnchorPane anchorPane= FXMLLoader
                    .load(getClass()
                            .getResource("../category_author/CategorieFXML.fxml"));
            content.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void feedBackNav(MouseEvent mouseEvent) {
        try {
            AnchorPane anchorPane= FXMLLoader
                    .load(getClass()
                            .getResource("../feedback/getFeedbackAdminFXML.fxml"));
            content.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userNav(MouseEvent mouseEvent) {
        try {
            AnchorPane anchorPane= FXMLLoader
                    .load(getClass()
                            .getResource("../user/Userlist.fxml"));
            content.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eventNav(MouseEvent mouseEvent) {
        try {
            AnchorPane anchorPane= FXMLLoader
                    .load(getClass()
                            .getResource("../event/Events.fxml"));
            content.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void profileNav(ActionEvent actionEvent) {
        try {
            AnchorPane anchorPane= FXMLLoader
                    .load(getClass()
                            .getResource("../user/GererProfil.fxml"));
            content.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
