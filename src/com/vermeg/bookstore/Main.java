package com.vermeg.bookstore;

import com.vermeg.bookstore.model.Order;
import com.vermeg.bookstore.service.OrderService;
import com.vermeg.bookstore.model.Ebook;
import com.vermeg.bookstore.service.ServiceEbook;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.SQLException;


import java.sql.SQLException;

public class Main  {





    public static void main(String[] args) {

        DBConnection.getInstance().getConnection();

        ServiceEbook serviceEbook=new ServiceEbook();

        try {

            System.out.println(serviceEbook.getEBooks());
            serviceEbook.addEbook(new Ebook(1,589,"kljhabdmzefz","hahaha",
                    "mlgh:","ftsyrdyfgl",432));
            serviceEbook.addEbook(new Ebook(2,289,"akjzblfhazùo","hohohh",
                    "","",432));
            serviceEbook.addEbook(new Ebook( 3,980,"hgkiaglabflor","hihih",
                    "","",432));
            System.out.println(serviceEbook.getEBooks());




            System.out.println("SUPRESSION");
            serviceEbook.deleteEbook(  3 );
            System.out.println(serviceEbook.getEBooks());
            Ebook E = new Ebook(1,2,"fatma w al pc al meskin ","looooool",
                    "jakglo:aj!z","qhgkzuyegm",432);
            serviceEbook.updateEbook(E);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
