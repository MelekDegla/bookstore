package com.vermeg.bookstore.service.implementation;

import com.vermeg.bookstore.model.Author;
import com.vermeg.bookstore.model.Categorie;
import com.vermeg.bookstore.service.ICategoryService;
import com.vermeg.bookstore.utils.DBConnection;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategorieService implements ICategoryService {

    private Connection cnx;

    public CategorieService() {
        cnx = DBConnection.getInstance().getConnection();
    }

    public void insert(Categorie c) throws SQLException {
        String request = "INSERT INTO `Categorie` (`id`,`libelle`, `description`,`dateajout`,`datemodif`)"
                + " VALUES (NULL,'"+c.getLibelle()+"', '" + c.getDescription() + "','" + c.getDateajout() + "','" + c.getDatemodif() + "')";

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
            c.setLibelle(rst.getString("libelle"));
            c.setDescription(rst.getString("description"));
            c.setDateajout(rst.getDate("dateajout"));
            c.setDatemodif(rst.getDate("datemodif"));
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
            c.setLibelle(rst.getString("libelle"));
            c.setDescription(rst.getString("description"));
            c.setDateajout(rst.getDate("dateajout"));
            c.setDatemodif(rst.getDate("datemodif"));
            return c;
        }

        return null;
    }

    public void update(Categorie c) throws SQLException {
 String request = "UPDATE `Categorie` SET `libelle`=?,`description`=?,`dateajout`=?,`datemodif`=? "
             + "WHERE `id` =?";

        PreparedStatement pst = cnx.prepareStatement(request);

        pst.setString(2, c.getLibelle());
        pst.setString(1, c.getDescription());
        Date sDate = new java.sql.Date(c.getDateajout().getTime());
        Date sDate1 = new java.sql.Date(c.getDatemodif().getTime());
        pst.setDate(3, sDate);
        pst.setDate(4, sDate1);
        pst.setInt(5, c.getId());
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



    public void addCategorie (Categorie c) throws SQLException {
            String request = "INSERT INTO `Categorie` (`id`,`libelle`, `description`,`dateajout`,`datemodif`)"
                    + " VALUES (NULL, '" + c.getLibelle() + "', '" + c.getDescription()+ "','" + c.getDateajout()+ "','" + c.getDatemodif()+ "')";

            Statement stm = cnx.createStatement();
            stm.executeUpdate(request);

    }


    public List<Categorie> trieParnb() {
        String req ="select * from `Categorie` ORDER BY datemodif DESC ";
        List<Categorie> list =new ArrayList<>();
        try {
            Statement ste=cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);

            while(rs.next())
            {         java.sql.Date d1 = new java.sql.Date(rs.getDate(3).getTime());
                    java.sql.Date d2 = new java.sql.Date(rs.getDate(4).getTime());
                list.add(new Categorie(rs.getInt(5),rs.getString(1),rs.getString(2),d1,d2));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }


}




