package com.vermeg.bookstore.service.implementation;

import com.vermeg.bookstore.model.Categorie;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class CategorieService {

    private Connection cnx;

    public CategorieService() {
        cnx = DBConnection.getInstance().getConnection();
    }

    public void addCategorie(Categorie c) throws SQLException {
        String request = "INSERT INTO `Categorie` (`id`,`title`, `description`)"
                + " VALUES (NULL,'"+c.getTitle()+"', '" + c.getDescription() + "')";

        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<Categorie> getCategories() throws SQLException {
        ArrayList<Categorie> results = new ArrayList<>();
        String request = "SELECT * FROM `Categorie`";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        while (rst.next()) {
            Categorie c = new Categorie();
            c.setId(rst.getInt("id"));
            c.setTitle(rst.getString(2));
            c.setDescription(rst.getString(3));
            results.add(c);
        }

        return results;
    }

    public Categorie getCategorie(int id) throws SQLException {
        String request = "SELECT * FROM `Categorie` WHERE id =" + id;
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        if (rst.next()) {
            Categorie c = new Categorie();
            c.setId(rst.getInt("id"));
            c.setTitle(rst.getString(2));
            c.setDescription(rst.getString(3));
            return c;
        }

        return null;
    }

    public void updateCategorie(Categorie c) throws SQLException {
        String request = "UPDATE `Categorie` SET `title`=?,`description`=? "
                + "WHERE `id` = ?";
        PreparedStatement pst = cnx.prepareStatement(request);

        pst.setString(1, c.getTitle());
        pst.setString(2, c.getDescription());
        pst.setInt(3, c.getId());
        pst.executeUpdate();

    }

    public void deleteCategorie(int id) throws SQLException {
        String request = "DELETE FROM `Categorie` WHERE id=" + id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
}

