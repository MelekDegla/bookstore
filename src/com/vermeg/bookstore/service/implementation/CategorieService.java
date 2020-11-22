package com.vermeg.bookstore.service.implementation;

import com.vermeg.bookstore.model.Categorie;
import com.vermeg.bookstore.service.ICategoryService;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class CategorieService implements ICategoryService {

    private Connection cnx;

    public CategorieService() {
        cnx = DBConnection.getInstance().getConnection();
    }

    public void insert(Categorie c) throws SQLException {
        String request = "INSERT INTO `Categorie` (`id`,`title`, `description`)"
                + " VALUES (NULL,'"+c.getTitle()+"', '" + c.getDescription() + "')";

        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<Categorie> findAll() throws SQLException {
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

    public Categorie findById(int id) throws SQLException {
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

    public void update(Categorie c) throws SQLException {
        String request = "UPDATE `Categorie` SET `title`=?,`description`=? "
                + "WHERE `id` = ?";
        PreparedStatement pst = cnx.prepareStatement(request);

        pst.setString(1, c.getTitle());
        pst.setString(2, c.getDescription());
        pst.setInt(3, c.getId());
        pst.executeUpdate();

    }

    @Override
    public void delete(Categorie entity) throws SQLException {

    }

    public void deleteById(int id) throws SQLException {
        String request = "DELETE FROM `Categorie` WHERE id=" + id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
}

