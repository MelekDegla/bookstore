package com.vermeg.bookstore.service.implementation;

import com.vermeg.bookstore.model.Author;
import com.vermeg.bookstore.model.Categorie;
import com.vermeg.bookstore.service.IAuthorService;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorService implements IAuthorService {
    private Connection cnx;

    public AuthorService() {
        cnx = DBConnection.getInstance().getConnection();
    }

    public void insert(Author a) throws SQLException {
        String request = "INSERT INTO `Author` (`id`,`name`, `lastname`,`nbLivres`,`birthdate`,`photo`)"
                + " VALUES (NULL,'"+a.getName()+"', '" + a.getLastname() + "', '"+a.getNbLivres()+"' ,'"+a.getBirthdate()+"' ,'" + a.getPhoto() + "')";


           // java.sql.Date date = new java.sql.Date(a.getBirthdate().getTime());
            PreparedStatement stm = cnx.prepareStatement(request);
            //stm.setDate(4, new java.sql.Date(date.getTime()));
            stm.executeUpdate();


    }

    public ArrayList<Author> findAll() throws SQLException {
        ArrayList<Author> results = new ArrayList<>();
        String request = "SELECT * FROM `Author`";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        while (rst.next()) {
            Author a = new Author();
            a.setId(rst.getInt("id"));
            a.setName(rst.getString(2));
            a.setLastname(rst.getString(3));
            a.setNbLivres(rst.getInt(4));
            a.setBirthdate(rst.getDate(5));
            a.setPhoto(rst.getString(6));
            results.add(a);
        }

        return results;
    }

    @Override
    public Author findById(int id) {
        return null;
    }

    public Author getAuthor(int id) throws SQLException {
        String request = "SELECT * FROM `Author` WHERE id =" + id;
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        if (rst.next()) {
            Author a= new Author();
            a.setId(rst.getInt("id"));
            a.setName(rst.getString(2));
            a.setLastname(rst.getString(3));
            a.setNbLivres(rst.getInt(4));
            a.setBirthdate(rst.getDate(5));
            a.setPhoto(rst.getString(6));
            return a;
        }

        return null;
    }

    public void update(Author a) throws SQLException {
        String request = "UPDATE `Author` SET `name`=?,`lastname`=?,`nbLivres`=?,`birthdate`=?,`photo`=? "
                + "WHERE `id` = ?";
        PreparedStatement pst = cnx.prepareStatement(request);
           // Date date = new SimpleDateFormat("yyyy-MM-dd").parse(a.getBirthdate());
         java.sql.Date date = new java.sql.Date(a.getBirthdate().getTime());
            pst.setString(1, a.getName());
            pst.setString(2, a.getLastname());
        pst.setInt(3, a.getNbLivres());
            pst.setDate(4,  new java.sql.Date(date.getTime()));
            pst.setString(5, a.getPhoto());
            pst.setInt(6, a.getId());
            pst.executeUpdate();




    }

    @Override
    public void delete(Author entity) throws SQLException {

    }


    public void deleteById(int id) throws SQLException {
        String request = "DELETE FROM `Author` WHERE id=" + id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }


    public ResultSet statistic() throws SQLException  {

        String rec="SELECT count(*),nbLivres FROM `Author` group by nbLivres";
        PreparedStatement pre= cnx.prepareStatement(rec);
        ResultSet result = pre.executeQuery();
        return result;
    }
}
