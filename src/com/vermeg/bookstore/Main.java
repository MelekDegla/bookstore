package com.vermeg.bookstore;


import com.vermeg.bookstore.model.Ebook;
import com.vermeg.bookstore.service.implementation.ServiceEbook;
import com.vermeg.bookstore.utils.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;




public class Main extends Application {


     /*   DBConnection.getInstance().getConnection();

        ServiceEbook serviceEbook=new ServiceEbook();

        try {

            System.out.println(serviceEbook.findAll());
            serviceEbook.insert(new Ebook(1,589,"kljhabdmzefz","hahaha",
                    "mlgh:","ftsyrdyfgl",432));
            serviceEbook.insert(new Ebook(2,289,"akjzblfhazùo","hohohh",
                    "","",432));
            serviceEbook.insert(new Ebook( 3,980,"hgkiaglabflor","hihih",
                    "","",432));
            System.out.println(serviceEbook.findAll());




            System.out.println("SUPRESSION");
            serviceEbook.deleteById(  3 );
            System.out.println(serviceEbook.findAll());
            Ebook E = new Ebook(1,2,"fatma w al pc al meskin ","looooool",
                    "jakglo:aj!z","qhgkzuyegm",432);
            serviceEbook.update(E);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
        @Override
        public void start(Stage stage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("gui/EbookClient.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("gui/AjouterFXML.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        }

    public static void main(String[] args)  {
       launch(args);
//        ServiceEbook serviceEbook = new ServiceEbook();
//        try {
//            serviceEbook.findAll().forEach(ebook -> {
//                ebook.setPhoto("t.jpg");
//                try {
//                    serviceEbook.update(ebook);
//                } catch (SQLException exception) {
//                    exception.printStackTrace();
//                }
//            });
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
    }




}


