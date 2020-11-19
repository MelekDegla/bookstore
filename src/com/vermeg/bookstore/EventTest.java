package com.vermeg.bookstore;

import com.vermeg.bookstore.model.Events;
import com.vermeg.bookstore.service.EventsService;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.SQLException;

public class EventTest {

    public static void main(String[] args) {
        DBConnection.getInstance().getConnection();
        EventsService es = new EventsService();
        try{
            es.addEvents(new Events("hackfest","hackhaton","21/01/2020",50,"ezzahra"));
            es.addEvents(new Events("hackfest2","hackhaton2","21/02/2020",50,"marsa"));
            //  System.out.println("*************************************");

              System.out.println(es.getEvents());
              System.out.println("SUPRESSION");
              es.deleteEvents(3);
            Events ess = new Events(2,"hackfeeest3","hackhaton3","23/03/2023",50,"paris");
            es.updateEvents(ess);
            System.out.println(es.getEvents());
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("exception");
        }
    }



}
