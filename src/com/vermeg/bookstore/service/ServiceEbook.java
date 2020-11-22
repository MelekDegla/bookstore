package com.vermeg.bookstore.service;

import com.vermeg.bookstore.model.Ebook;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class ServiceEbook {
    private Connection connexion ;
    public  ServiceEbook () {connexion =  DBConnection . getInstance () . getConnection ();}



    public void addEbook(Ebook ebook) throws SQLException {
        String request=" INSERT INTO ebook ( author_id ,title, description, file_url,photo, price)" +
                " VALUES ("+ebook.getAuthor()+ ",'"+ebook.getTitle()+ "','"+
                ebook.getDescription()+ "','"+ebook.getFileURL()+
                "','"+ebook.getPhoto()+ "',"+ebook.getPrice() +")";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<Ebook> getEBooks() throws SQLException {
        ArrayList<Ebook> ebooks= new ArrayList<>();
        String request = "SELECT * FROM ebook";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(request);
        while (rst.next()) {
            Ebook ebook = new Ebook();
            ebook.setId(rst.getInt("id"));
            ebook.setAuthor(rst.getInt("author_id"));
            ebook.setTitle(rst.getString("title"));
            ebook.setDescription(rst.getString("description"));
            ebook.setFileURL(rst.getString("file_url"));
            ebook.setPhoto(rst.getString("photo"));
            ebook.setPrice(rst.getFloat("price"));
            ebooks.add(ebook);
        }
        return ebooks;
    }


    public Ebook getEbook (int author) throws SQLException {
        String request="SELECT * FROM 'ebook'  WHERE Author =" + author;
        Statement stm=connexion.createStatement();
        ResultSet rst=stm.executeQuery(request);
        while (rst.next()){
            Ebook ebook= new Ebook();
            ebook.setId(rst.getInt(1));
            ebook.setAuthor(rst.getInt(2));
            ebook.setTitle(rst.getString(3));
            ebook.setDescription(rst.getString(4));
            ebook.setFileURL(rst.getString(5));
            ebook.setPhoto(rst.getString(6));
           ebook.setPrice(rst.getFloat(7));

            return ebook;
        }
        return null;
    }


    public  void  updateEbook (Ebook ebook ) throws SQLException {
        String request =  " UPDATE ebook SET author_id =?, title =?, "  +
                " description =?, file_url =?, photo =?,  price =? WHERE id =?; " ;
        PreparedStatement pst = connexion. prepareStatement (request);

        pst . setInt ( 1 , ebook . getAuthor ());
        pst . setString ( 2 , ebook. getTitle ());
        pst . setString ( 3 , ebook . getDescription ());
        pst . setString ( 4 , ebook. getFileURL ());
        pst . setString (  5, ebook . getPhoto ());
        pst . setFloat ( 6 , ebook. getPrice());
        pst.setInt(7, ebook.getId());
        pst . executeUpdate ();
    }

    public void deleteEbook(int id)throws  SQLException{
        String request = "DELETE FROM ebook WHERE id =" + id;
        Statement stm = connexion.createStatement();
        stm.executeUpdate(request);
    }


}

