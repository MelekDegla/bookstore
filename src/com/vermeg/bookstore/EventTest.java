package com.vermeg.bookstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EventTest extends Application {


   /* public static void main(String[] args) {
        DBConnection.getInstance().getConnection();
        EventsService es = new EventsService();
        try{
            es.insert(new Events("hackfest","hackhaton","2020-05-11",50,"ezzahra"));
            es.insert(new Events("hackfest2","hackhaton2","2020-10-03",50,"marsa"));
            //  System.out.println("*************************************");

              System.out.println(es.findAll());
              System.out.println("SUPRESSION");
              es.deleteById(3);
            Events ess = new Events(2,"hackfeeest3","hackhaton3","2023-02-05",50,"paris");
            es.update(ess);
            System.out.println(es.findAll());
        }catch (SQLException e){
//            e.printStackTrace();
            System.out.println("exception");
        }
    }
*/




       @Override

       public void start(Stage stage) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("gui/event/ClientEventDisplay.fxml"));
           Scene scene= new Scene(root);
          stage.setScene(scene);
           stage.show();

       }

}
