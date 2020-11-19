package com.vermeg.bookstore.service;

import com.vermeg.bookstore.model.Author;
import com.vermeg.bookstore.model.Categorie;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class AuthorService {
    private Connection cnx;

    public AuthorService() {
        cnx = DBConnection.getInstance().getConnection();
    }

    public void addAuthor(Author a) throws SQLException {
        String request = "INSERT INTO `Author` (`id`,`name`, `lastname`,`birthdate`,`photo`)"
                + " VALUES (NULL,'"+a.getName()+"', '" + a.getLastname() + "', '" + a.getBirthdate() .toString()+ "','" + a.getPhoto() + "')";

        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<Author> getAuthors() throws SQLException {
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

    public void updateAuthor(Author a) throws SQLException {
        String request = "UPDATE `Author` SET `name`=?,`lastname`=?,`birthdate`=?,`photo`=? "
                + "WHERE `id` = ?";
        PreparedStatement pst = cnx.prepareStatement(request);

        pst.setString(1, a.getName());
        pst.setString(2, a.getLastname());
        pst.setString(3,  a.getBirthdate());
        pst.setString(4, a.getPhoto());
        pst.setInt(5, a.getId());
        pst.executeUpdate();

    }

    public void deleteAuthor(int id) throws SQLException {
        String request = "DELETE FROM `Author` WHERE id=" + id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
}
