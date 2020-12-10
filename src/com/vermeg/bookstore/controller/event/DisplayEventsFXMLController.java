package com.vermeg.bookstore.controller.event;

import com.vermeg.bookstore.model.Events;
import com.vermeg.bookstore.service.implementation.EventsService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisplayEventsFXMLController implements Initializable {

       @FXML
    private AnchorPane affichage;
    ArrayList<Events> Eventss;



    public DisplayEventsFXMLController() {
    }

    public void initialize(URL url, ResourceBundle rb){
        try{
            this.Eventss =(new EventsService().findAll());
        }catch (SQLException var6) {
            Logger.getLogger(DisplayEventsFXMLController.class.getName()).log(Level.SEVERE, (String)null, var6);
        }
VBox EventsGraphiques = new VBox();
        String cssLayout = "-fx-border-color: red;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-border-style: dashed;\n";

       Iterator var4 = this.Eventss.iterator();
       while (var4.hasNext()){
           Events e= (Events) var4.next();
            EventsGraphiques.getChildren().add(this.convertEvents(e));
            EventsGraphiques.setSpacing(25);
           EventsGraphiques.setStyle(cssLayout);
        }
        this.affichage.getChildren().add(EventsGraphiques);



    }

    public HBox convertEvents(Events e){
        Label lbTitle =new Label(e.getTitle());
        Label LbDescription= new Label(e.getDescription());
        Label lbId = new Label(Integer.toString(e.getID()));
        SimpleDateFormat datef = new SimpleDateFormat("MM ,dd, yyyy");
        java.sql.Timestamp date =new java.sql.Timestamp( e.getDate().getTime());
        //new java.sql.Date(date1.getTime())
        System.out.println(date);

        //DateFormat datef= new SimpleDateFormat("yyyy-mm-dd");
        String  string = datef.format(date);
        System.out.println(string);
        Label LbDate = new Label(string);

        Label LbMaxparticipants = new Label(String.valueOf(e.getMAX_PARTICIPANTS()));
        Label LbLieu =new Label(e.getLieu());
        HBox EventsGraphique = new HBox();
        EventsGraphique.setSpacing(10);



        String cssLayout = "-fx-border-color: red;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-border-style: dashed;\n";

         VBox Vdesc =new VBox();
        Vdesc.getChildren().add(LbDescription);
        Vdesc.setStyle(cssLayout);
        Vdesc.setMaxSize(100,100);
        EventsGraphique.getChildren().add(Vdesc);


        VBox VId =new VBox();
        VId.getChildren().add(lbId);
        VId.setStyle(cssLayout);
        VId.setMaxSize(100,100);
        EventsGraphique.getChildren().add(VId);

        VBox VLieu =new VBox();
        VLieu.getChildren().add(LbLieu);
        VLieu.setStyle(cssLayout);
        VLieu.setMaxSize(100,100);
        EventsGraphique.getChildren().add(VLieu);



        VBox Vpar=new VBox();
        Vpar.getChildren().add(LbMaxparticipants);
        Vpar.setStyle(cssLayout);
        Vpar.setMaxSize(100,100);
        EventsGraphique.getChildren().add(Vpar);


        VBox Vdate =new VBox();
        Vdate.getChildren().add(LbDate);
        Vdate.setStyle(cssLayout);
        Vdate.setMaxSize(100,100);
        EventsGraphique.getChildren().add(Vdate);

       // VBox Vbutton =new VBox();
        // Button btn = new Button("update");
        // btn.setOnAction(event ->  {

          //   try {
           /*Parent root=  FXMLLoader.load(getClass().getResource("/AddEventsFXML.fxml"));
           Scene newscene = new Scene(root);
            Stage stage= (stage) ((node) event.getSource().getScene().getStage();
            stage.setScene(new Scene(root));
           stage.show();
                 Parent tableViewParent = FXMLLoader.load(getClass().getResource("com/vermeg/bookstore/GUI/AddEventsFXML.fxml"));
                 Scene tableViewScene = new Scene(tableViewParent);

                 //This line gets the Stage information
                 Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                 window.setScene(tableViewScene);
                 window.show();*/
        //public void update (ActionEvent event) throws IOException{



      //  } catch (Exception ioException) {
        //         System.out.println(ioException);
        //         ioException.printStackTrace();
       //}




     // Vbutton.getChildren().add(btn);
    //  EventsGraphique.getChildren().add(Vbutton);



       // EventsGraphique.setStyle(cssLayout);

return EventsGraphique;
    }
   // public void update (int id){

    //    try {
        /*    EventsService es = new EventsService();
            Events e = new Events();
            e.setID(id);
            es.update(e);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
*/








       /* FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("GUI/AddEventsFXML.fxml"));
        Parent tableViewParent = loader.load();

        Scene tableViewScene = new Scene(tableViewParent);

        //access the controller and call a method
        AddEventsFXMLController controller = loader.getController();
        //  controller.initData(tableView.getSelectionModel().getSelectedItem());

        //This line gets the Stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }*/
       public void update(ActionEvent actionEvent) throws IOException {
        Parent root=  FXMLLoader.load(getClass().getResource("/AddEventsFXML.fxml"));
        Scene newscene = new Scene(root);
        Stage stage= (Stage) actionEvent.getSource();
        stage.setScene(new Scene(root));
        stage.show();
       /* Parent tableViewParent = FXMLLoader.load(getClass().getResource("com/vermeg/bookstore/GUI/AddEventsFXML.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();*/
}
}
