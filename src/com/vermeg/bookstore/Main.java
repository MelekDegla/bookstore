//package com.vermeg.bookstore;
//
//
//import com.vermeg.bookstore.model.Ebook;
//import com.vermeg.bookstore.service.implementation.ServiceEbook;
//import com.vermeg.bookstore.utils.DBConnection;
//
//import java.sql.SQLException;
//
//
//
//
//public class Main  {
//    public static void main(String[] args) {
//<<<<<<< HEAD
//    	User user= new User();
//    	user.setName("wiem");
//    	user.setBirthdate("1/08/1997");
//    	user.setId(14);
//    	user.setLastname("rekik");
//
//
//
//    	UserDaoImpl.getInstance().delete(user);
//
//
//
//    System.out.println(UserDaoImpl.getInstance().findAll());
//
//=======
//
//        DBConnection.getInstance().getConnection();
//
//        ServiceEbook serviceEbook=new ServiceEbook();
//
//        try {
//
//            System.out.println(serviceEbook.findAll());
//            serviceEbook.insert(new Ebook(1,589,"kljhabdmzefz","hahaha",
//                    "mlgh:","ftsyrdyfgl",432));
//            serviceEbook.insert(new Ebook(2,289,"akjzblfhazùo","hohohh",
//                    "","",432));
//            serviceEbook.insert(new Ebook( 3,980,"hgkiaglabflor","hihih",
//                    "","",432));
//            System.out.println(serviceEbook.findAll());
//
//
//
//
//            System.out.println("SUPRESSION");
//            serviceEbook.deleteById(  3 );
//            System.out.println(serviceEbook.findAll());
//            Ebook E = new Ebook(1,2,"fatma w al pc al meskin ","looooool",
//                    "jakglo:aj!z","qhgkzuyegm",432);
//            serviceEbook.update(E);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//>>>>>>> 3be53a6d137fc6914ea62b49767bb5497389bf51
//    }
//
//}
//
//
