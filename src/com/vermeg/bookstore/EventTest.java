package com.vermeg.bookstore;

import com.vermeg.bookstore.model.Events;
import com.vermeg.bookstore.service.implementation.EventsService;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.SQLException;

public class EventTest {

    public static void main(String[] args) {
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
            e.printStackTrace();
            System.out.println("exception");
        }
    }



}
