package com.vermeg.bookstore;

import com.vermeg.bookstore.service.implementation.ServicePBook;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.SQLException;
import java.util.Properties;

public class PaperBookTest extends Application {
    public static void main(String[] args) {
//        ServicePBook servicePBook=new ServicePBook();
//        try {
//            servicePBook.findAll().forEach(pBook -> {
//                pBook.setPhoto(pBook.getPhoto().replace("5102ogTDCGL.jpg", "C:\\Users\\jridi\\Desktop\\Bookstore\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\resources\\9781789137897.jpg"));
//                try {
//                    servicePBook.update(pBook);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            });
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        launch(args);

//        try {
//
//            System.out.println(servicePBook.findAll());
//            servicePBook.insert(new PBook(1,2,"54q54DQFHNQKLS","ggg",
//                    "","",444,556));
//            servicePBook.insert(new PBook(2,2,"54jjjjDQFHNQKLS","ggg",
//                    "","",444,556));
//            servicePBook.insert(new PBook(3,2,"54q54DQFooooNQKLS","ggg",
//                    "","",444,556));
//            System.out.println("*************************************");
//            System.out.println(servicePBook.findAll());
//
//               System.out.println("SUPRESSION");
//             servicePBook.deleteByISBN(   "54q54DQFHNQKLS");
//              System.out.println(servicePBook.findAll());
//            PBook p = new PBook(19,2,"54q54DQFHNQKLS","ppppppppppppppppp",
//                    "ppppppppppppppp","ppppppppppppppppp",444,556);
//            servicePBook.update(p);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }

    @Override
    public void start(Stage stage) throws Exception {
     Parent root= FXMLLoader.load(getClass().getResource("gui/manage_pbooks.fxml"));
       //Parent root= FXMLLoader.load(getClass().getResource("gui/pbook/clientPBooks.fxml"));
       // Parent root= FXMLLoader.load(getClass().getResource("gui/PBookDetails.fxml"));
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
