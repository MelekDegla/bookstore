package com.vermeg.bookstore.service;

import com.vermeg.bookstore.model.Author;
import com.vermeg.bookstore.model.Categorie;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieService {

    private Connection cnx;

    public CategorieService() {
        cnx = DBConnection.getInstance().getConnection();
    }

      public ArrayList<Categorie> getCategories() throws SQLException {
        ArrayList<Categorie> results = new ArrayList<>();
        String request = "SELECT * FROM `Categorie`";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        while (rst.next()) {
            Categorie c = new Categorie();
            c.setId(rst.getInt("id"));
            c.setLibelle(rst.getString(2));
            c.setDescription(rst.getString(3));
            c.setImage(rst.getString(3));
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
            c.setLibelle(rst.getString(2));
            c.setDescription(rst.getString(3));
            c.setImage(rst.getString(4));
            return c;
        }

        return null;
    }

   public void updateCategorie(Categorie c) throws SQLException {
        String request = "UPDATE `Categorie` SET `title`=?,`description`=? ,`image`=?"
                + "WHERE `id` = ?";
        PreparedStatement pst = cnx.prepareStatement(request);

        pst.setString(1, c.getLibelle());
        pst.setString(2, c.getDescription());
       pst.setString(3,c.getImage());
        pst.setInt(3, c.getId());

        pst.executeUpdate();

    }

   public void deleteCategorie(int id) throws SQLException {
        String request = "DELETE FROM `Categorie` WHERE id=" + id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    public Categorie ChercherCategorie(String libelle) {
        Categorie c = new Categorie();
        try {
            String request = "SELECT * from `Categorie` WHERE libelle="+libelle;
            PreparedStatement pst = cnx.prepareStatement(request);
            pst.setString(1, libelle);
            pst.executeQuery(request);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                System.out.println("rs=" + rs);
                c.setId(rs.getInt("id"));
                c.setLibelle(rs.getString("libelle"));
                c.setDescription(rs.getString("description"));
                c.setImage(rs.getString("image"));
            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return c;
    }

        public void addCategorie (Categorie c) throws SQLException {
            String request = "INSERT INTO `Categorie` (`id`,`libelle`, `description`,`image`)"
                    + " VALUES (NULL, '" + c.getLibelle() + "', '" + c.getDescription()+ "','" + c.getImage() + "')";

            Statement stm = cnx.createStatement();
            stm.executeUpdate(request);

        }

}




