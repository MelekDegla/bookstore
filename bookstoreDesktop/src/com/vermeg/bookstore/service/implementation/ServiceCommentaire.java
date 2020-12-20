package com.vermeg.bookstore.service.implementation;

import com.vermeg.bookstore.model.Book;
import com.vermeg.bookstore.model.Commentaire;

import com.vermeg.bookstore.service.ICommentaireService;

import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class ServiceCommentaire implements ICommentaireService {
    private Connection cnx;
    public ServiceCommentaire() {
        cnx = DBConnection.getInstance().getConnection();
    }


    public ArrayList<Book> findCommentByUser(int id) throws SQLException {
        ArrayList<Book> results = new ArrayList<>();
        String request = "SELECT b.id, b.title, b.photo FROM Commentaire c,Book b WHERE id_user="+id+" AND c.id_book=b.id GROUP BY b.id order by created_at ASC ";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        while (rst.next()) {
            Book b = new Book();
            b.setTitle(rst.getString("title"));
            b.setId(rst.getInt("id"));
            b.setPhoto(rst.getString("photo"));
            results.add(b);
        }
        return results;
    }

    public ArrayList<Commentaire> findCommentByBook(int id) throws SQLException {
        ArrayList<Commentaire> results = new ArrayList<>();
        String request = "SELECT * FROM `Commentaire` WHERE id_book="+id+" order by created_at ASC ";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        while (rst.next()) {
            Commentaire c = new Commentaire();
            c.setId(rst.getInt("id"));
            c.setText(rst.getString(2));
            c.setId_book(rst.getInt(3));
            c.setId_user(rst.getInt(4));
            c.setCreated_at(rst.getDate(5));
            c.setUpdated_at(rst.getDate(6));
            results.add(c);
        }
        return results;
    }
    public ArrayList<Commentaire> findAll() throws SQLException {
        ArrayList<Commentaire> results = new ArrayList<>();
        String request = "SELECT * FROM `Commentaire` order by created_at DESC";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        while (rst.next()) {
            Commentaire c = new Commentaire();
            c.setId(rst.getInt("id"));
            c.setText(rst.getString(2));
            c.setId_book(rst.getInt(3));
            c.setId_user(rst.getInt(4));
            c.setCreated_at(rst.getDate(5));
            c.setUpdated_at(rst.getDate(6));
            results.add(c);
        }
        return results;
    }

    public Commentaire findById(int id) throws SQLException {
        String request = "SELECT * FROM `commentaire` WHERE id =" + id;
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        if (rst.next()) {
            Commentaire c = new Commentaire();
            c.setId(rst.getInt("id"));
            c.setText(rst.getString(2));
            c.setId_book(rst.getInt(3));
            c.setId_user(rst.getInt(4));
            c.setCreated_at(rst.getDate(5));
            c.setUpdated_at(rst.getDate(6));
            return c;
        }
        return null;
    }
    @Override
    public void insert(Commentaire c) throws SQLException {
        String request = "INSERT INTO `commentaire` (`id`, `text`, `id_book`, `id_user`, `created_at`, `updated_at`)"
                + " VALUES (NULL, '" + c.getText() + "', '" + c.getId_book() +"', '" + c.getId_user()+
                "',current_timestamp(),current_timestamp ())";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    @Override
    public void update(Commentaire c) throws SQLException {
        String request = "UPDATE `commentaire` SET `text`=?,`updated_at`= current_timestamp()"
                + "WHERE `id` = ?";
        PreparedStatement pst = cnx.prepareStatement(request);
        pst.setString(1, c.getText());
        pst.setInt(2, c.getId());
        pst.executeUpdate();
    }

    @Override
    public void delete(Commentaire entity) throws SQLException {

    }
    public void deleteById(int id) throws SQLException {
        String request = "DELETE FROM `commentaire` WHERE id =" + id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
}
