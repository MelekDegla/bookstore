package com.vermeg.bookstore.service.implementation;
import com.vermeg.bookstore.model.Feedback;
import com.vermeg.bookstore.service.IFeedbackService;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class ServiceFeedback implements IFeedbackService {
    private Connection cnx;

    public ServiceFeedback() {
        cnx = DBConnection.getInstance().getConnection();
    }

    public void insert(Feedback f) throws SQLException {
        String request = "INSERT INTO `feedback` (`id`, `name`, `lastname`, `email`, `phone`, `message`)"
                + " VALUES (NULL, '" + f.getName() + "', '" + f.getLastname() +"', '" + f.getEmail()+
                "', '" + f.getPhone()+"', '" + f.getMessage()+"')";

        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<Feedback> findAll() throws SQLException {
        ArrayList<Feedback> results = new ArrayList<>();
        String request = "SELECT * FROM `Feedback`";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        while (rst.next()) {
            Feedback f = new Feedback();
            f.setId(rst.getInt("id"));
            f.setName(rst.getString(2));
            f.setLastname(rst.getString(3));
            f.setEmail(rst.getString(4));
            f.setPhone(rst.getString(5));
            f.setMessage(rst.getString(6));
            results.add(f);
        }

        return results;
    }

    public Feedback findById(int id) throws SQLException {
        String request = "SELECT * FROM `feedback` WHERE id =" + id;
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        if (rst.next()) {
            Feedback f = new Feedback();
            f.setId(rst.getInt("id"));
            f.setName(rst.getString(2));
            f.setLastname(rst.getString(3));
            f.setEmail(rst.getString(4));
            f.setPhone(rst.getString(5));
            f.setMessage(rst.getString(6));
            return f;
        }

        return null;
    }

    public void update(Feedback f) throws SQLException {
        String request = "UPDATE `feedback` SET `name`=?,`lastname`=?,`email`=?,`phone`=?,`message`=? "
                + "WHERE `id` = ?";
        PreparedStatement pst = cnx.prepareStatement(request);

        pst.setString(1, f.getName());
        pst.setString(2, f.getLastname());
        pst.setString(3, f.getEmail());
        pst.setString(4, f.getPhone());
        pst.setString(5, f.getMessage());
        pst.setInt(6, f.getId());
        pst.executeUpdate();

    }

    @Override
    public void delete(Feedback entity) throws SQLException {

    }

    public void deleteById(int id) throws SQLException {
        String request = "DELETE FROM `feedback` WHERE id =" + id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
}
