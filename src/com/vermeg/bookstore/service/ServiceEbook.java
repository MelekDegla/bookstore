package com.vermeg.bookstore.service;

import com.vermeg.bookstore.model.Ebook;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class ServiceEbook {
    private Connection connexion ;
    public  ServiceEbook () {connexion =  DBConnection . getInstance () . getConnection ();}



    public void addEbook(Ebook Ebook) throws SQLException {
        String request=" INSERT INTO 'ebook' ('id', 'author' ,'title', 'description', 'fileURL','photo', 'price')" +
                " VALUES ('"+  Ebook.getId()+ "','"+Ebook.getAuthor()+ "','"+ "','"+Ebook.getTitle()+ "','"+
                Ebook.getDescription()+ "','"+Ebook.getFileURL()+
                "',"+Ebook.getPhoto()+ "','"+Ebook.getPrice() +")";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<Ebook> getEBooks() throws SQLException {
        ArrayList<Ebook> Ebooks= new ArrayList<>();
        String request = "SELECT * FROM 'ebook'";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(request);
        while (rst.next()) {
            Ebook EBook = new Ebook();
            EBook.setId(rst.getInt(1));
            EBook.setAuthor(rst.getInt(2));
            EBook.setTitle(rst.getString(3));
            EBook.setDescription(rst.getString(4));
            EBook.setFileURL(rst.getString(5));
            EBook.setPhoto(rst.getString(6));
            EBook.setPrice(rst.getFloat(7));
            Ebooks.add(EBook);
        }
        return Ebooks;
    }


    public Ebook getEbook (int Author) throws SQLException {
        String request="SELECT * FROM 'ebook'  WHERE Author =" + Author;
        Statement stm=connexion.createStatement();
        ResultSet rst=stm.executeQuery(request);
        while (rst.next()){
            Ebook Ebook= new Ebook();
            Ebook.setId(rst.getInt(1));
            Ebook.setAuthor(rst.getInt(2));
            Ebook.setTitle(rst.getString(3));
            Ebook.setDescription(rst.getString(4));
            Ebook.setFileURL(rst.getString(5));
            Ebook.setPhoto(rst.getString(6));
           Ebook.setPrice(rst.getFloat(7));

            return Ebook;
        }
        return null;
    }


    public  void  updateEbook (Ebook Ebook ) throws SQLException {
        String request =  " UPDATE 'ebook' SET 'author' =?,' Title' =?, "  +
                " 'description' =?, 'fileURL' =?, 'photo' =?, ' price' =? WHERE 'id' =?; " ;
        PreparedStatement pst = connexion. prepareStatement (request);

        pst . setInt ( 1 , Ebook . getId ());
        pst . setInt ( 2 , Ebook . getAuthor());
        pst . setString ( 3 , Ebook. getTitle ());
        pst . setString ( 4 , Ebook . getDescription ());
        pst . setString ( 5 , Ebook. getFileURL ());
        pst . setString ( 6 , Ebook . getPhoto ());
        pst . setFloat ( 7 , Ebook. getPrice());
        pst . executeUpdate ();
    }

    public void deleteEbook(String Author)throws  SQLException{
        String request = "DELETE FROM 'ebook' WHERE Author ='" + Author+ "'";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(request);
    }


}

