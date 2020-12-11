package com.vermeg.bookstore;

import com.vermeg.bookstore.controller.user.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*public class UserMain {
    public static void main(String[] args) {
        UserServiceImpl userService = UserServiceImpl.getInstance();
        User user = new User();
        user.setBirthdate("2020-11-11");
        userService.insert(user);*/
   // }
    
//}
public class UserMain extends Application {
 
    
 
    
 
    
    public void start(Stage primaryStage) throws IOException {

        

        
        Parent root =  FXMLLoader.load(getClass().getResource("gui/user/Login.fxml"));

        Scene scene = new Scene(root);
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("gui/user/Login.fxml"));
      // RegisterController controller =Loader.getController();
      LoginController controller =Loader.getController();
      //  GereProfilController controller =Loader.getController();



        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

	
	public static void main(String[] args) {
		launch(args);
	}}
