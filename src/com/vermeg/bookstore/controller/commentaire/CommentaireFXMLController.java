package com.vermeg.bookstore.controller.commentaire;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.vermeg.bookstore.model.Book;
import com.vermeg.bookstore.model.Commentaire;
import com.vermeg.bookstore.model.User;
import com.vermeg.bookstore.service.implementation.ServiceCommentaire;
import com.vermeg.bookstore.service.implementation.ServicePBook;
import com.vermeg.bookstore.service.implementation.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class CommentaireFXMLController implements Initializable {
    @FXML
    private ScrollPane comments;
    @FXML
    private JFXButton btnComment;
    @FXML
    private TextArea tfCommentaire;
    @FXML
    private VBox commentlist;
    @FXML
    private Label LbErreur;
    @FXML
    private VBox userComments;
    @FXML
    private Label tfTitle;
    @FXML
    private Label tfAuthor;
    @FXML
    private Label tfDescription;
    @FXML
    private ImageView imgBook;

    int idUser=16;
    int idBook=24;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ServiceCommentaire sc = new ServiceCommentaire();
        ServicePBook sb=new ServicePBook();
        //Book book=sb.get
        commentlist.setSpacing(20);
        ArrayList<Commentaire> c = new ArrayList<>();
        try {
            c = sc.findCommentByBook(idBook);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        displayComments();
        convert(c);

        btnComment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean valide = true;
                Commentaire com = new Commentaire();
                if ((tfCommentaire.getText().length() < 2) && valide) {
                    LbErreur.setText("Please write a comment");
                    valide = false;
                }
                com.setText(tfCommentaire.getText());
                com.setId_user(idUser); // connected user
                com.setId_book(idBook); // book affichier

                if (valide) {
                    try {
                        sc.insert(com);
                        convert(sc.findCommentByBook(idBook));
                        tfCommentaire.setText("");
                        displayComments();
                        LbErreur.setText("");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
    }
    public void displayComments(){
        ServiceCommentaire sc=new ServiceCommentaire();
        try {
            ArrayList<Book> books=sc.findCommentByUser(idUser);
            userComments.getChildren().clear();
            userComments.setSpacing(30);
            for (Book book : books){
                HBox box = new HBox();
               // System.out.println(book.getPhoto());
                ImageView photo=new ImageView(new Image(book.getPhoto()));
                photo.setFitHeight(100);
                photo.setFitWidth(70);
                Circle cir2 = new Circle(250,250,40);
                cir2.setStroke(Color.SEAGREEN);
                cir2.setFill(new ImagePattern(new Image(book.getPhoto())));
                cir2.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));

                Label title=new Label(book.getTitle());
                title.setMinWidth(100);
                title.setMinHeight(100);
                title.setStyle("-fx-font-weight:bold");
                box.setSpacing(20);
                box.getChildren().add(cir2);
                box.getChildren().add(title);
                box.setPadding(new Insets(30,0,0,20));
                userComments.getChildren().add(box);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void convert(ArrayList<Commentaire> c){
        UserServiceImpl us = UserServiceImpl.getInstance();
        commentlist.getChildren().clear();
        for (Commentaire commentaire : c ){
        VBox v = new VBox();

        User user= us.findById(commentaire.getId_user());
        Label nameUser = new Label(user.getName()+" "+user.getLastname());
        nameUser.setStyle("-fx-font-weight:bold");
        Label comment = new Label(commentaire.getText());
       comment.setMinHeight(80);
        Label created_at= new Label(commentaire.getCreated_at().toString());



            v.setPadding(new Insets(10,30,10,20));
            comment.setPadding(new Insets(0,30,0,10));

        comment.setWrapText(true);
            v.getChildren().add(nameUser);
            v.getChildren().add(comment);
            HBox h=new HBox();
            h.setMinWidth(700);
            h.setAlignment(Pos.BOTTOM_RIGHT);
            if (commentaire.getId_user() == idUser) {
                Hyperlink delete = new Hyperlink("delete");
                Hyperlink update = new Hyperlink("update");
                h.getChildren().add(delete);

                delete.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ServiceCommentaire sc = new ServiceCommentaire();
                        //Alert
                        Stage dialogStage = new Stage();
                        dialogStage.initModality(Modality.WINDOW_MODAL);
                        JFXButton del=new JFXButton("delete");
                        del.setStyle("-fx-background-color:  #49c7f0");
                        VBox vbox = new VBox(new Text("Are you sure you want to delete your comment ?"), del);
                        vbox.setSpacing(20);
                        vbox.setAlignment(Pos.CENTER);
                        vbox.setPadding(new Insets(15));

                        dialogStage.setScene(new Scene(vbox));
                        dialogStage.show();
                        del.setOnAction(event1 -> {
                            try {
                                sc.deleteById(commentaire.getId());
                                convert(sc.findCommentByBook(commentaire.getId_book()));
                                dialogStage.close();
                                displayComments();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        });

                    }
                });

                update.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ServiceCommentaire sc = new ServiceCommentaire();
                        //Alert
                        Stage dialogStage = new Stage();
                        dialogStage.initModality(Modality.WINDOW_MODAL);
                        JFXButton updatebtn=new JFXButton("Update");
                        updatebtn.setStyle("-fx-background-color:  #49c7f0");
                        TextArea newcomment = new TextArea();
                        newcomment.setText(comment.getText());
                        VBox vbox = new VBox(new Text("Here you can update your comment"),newcomment, updatebtn);
                        vbox.setAlignment(Pos.CENTER);
                        vbox.setPadding(new Insets(15));
                        vbox.setSpacing(20);
                        dialogStage.setScene(new Scene(vbox));
                        dialogStage.show();
                        updatebtn.setOnAction(event1 -> {
                            try {
                                commentaire.setText(newcomment.getText());
                                sc.update(commentaire);
                                convert(sc.findCommentByBook(commentaire.getId_book()));
                                dialogStage.close();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        });

                    }
                });
                h.getChildren().add(update);
            }// connected user
            h.getChildren().add(created_at);
            v.getChildren().add(h);

            commentlist.getChildren().add(v);
        }
    }
}
