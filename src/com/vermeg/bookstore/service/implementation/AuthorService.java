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

public class AuthorService implements IAuthorService {
    private Connection cnx;

    public AuthorService() {
        cnx = DBConnection.getInstance().getConnection();
    }

    public void insert(Author a) throws SQLException {
        String request = "INSERT INTO `Author` (`id`,`name`, `lastname`,`birthdate`,`photo`)"
                + " VALUES (NULL,'"+a.getName()+"', '" + a.getLastname() + "', ? ,'" + a.getPhoto() + "')";

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(a.getBirthdate());
            PreparedStatement stm = cnx.prepareStatement(request);
            stm.setDate(1, new java.sql.Date(date.getTime()));
            stm.executeUpdate();
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
            a.setBirthdate(rst.getString(4));
            a.setPhoto(rst.getString(5));
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
            a.setBirthdate(rst.getString(4));
            a.setPhoto(rst.getString(5));
            return a;
        }

        return null;
    }

    public void update(Author a) throws SQLException {
        String request = "UPDATE `Author` SET `name`=?,`lastname`=?,`birthdate`=?,`photo`=? "
                + "WHERE `id` = ?";
        PreparedStatement pst = cnx.prepareStatement(request);
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(a.getBirthdate());

            pst.setString(1, a.getName());
            pst.setString(2, a.getLastname());
            pst.setDate(3,  new java.sql.Date(date.getTime()));
            pst.setString(4, a.getPhoto());
            pst.setInt(5, a.getId());
            pst.executeUpdate();
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void delete(Author entity) throws SQLException {

    }


    public void deleteById(int id) throws SQLException {
        String request = "DELETE FROM `Author` WHERE id=" + id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
}
