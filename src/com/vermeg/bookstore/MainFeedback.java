package com.vermeg.bookstore;

import com.vermeg.bookstore.model.Feedback;
import com.vermeg.bookstore.service.implementation.ServiceFeedback;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.SQLException;

public class MainFeedback {
    public static void main(String[] args) {
        DBConnection.getInstance().getConnection();
        ServiceFeedback sf = new ServiceFeedback();
        try {
            Feedback f1 = new Feedback(1,"ALI","Mohamed","ali.mohamed@esprit.tn","25889963","bkojqbs");
            Feedback f2 = new Feedback(2,"BATTIKH","Anis","anis.battikh@esprit.tn","93829700","Merci beaucoup!");
            Feedback f3 = new Feedback(3,"FERJANI","Iheb","ferjani.iheb@esprit.tn","99555666","bkojqbs");
            sf.insert(f1);
            sf.insert(f2);
            sf.insert(f3);
            sf.deleteById(7);
            Feedback f4 = new Feedback(12,"AHMeeeeED","Kamel","kamel.ahmed@esprit.tn","99665887","qsdqsd");
            sf.update(f4);
        } catch (SQLException e) {
            System.out.println("Exception");
            e.printStackTrace();
        }

    }
}
