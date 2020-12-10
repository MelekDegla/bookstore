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
        String request = "INSERT INTO `feedback` (`id`, `name`, `lastname`, `email`, `phone`, `subject`, `message`,`created_at`,`is_answered`,`answer`)"
                + " VALUES (NULL, '" + f.getName() + "', '" + f.getLastname() +"', '" + f.getEmail()+
                "', '" + f.getPhone()+"', '"+ f.getSubject()+"', '" + f.getMessage()+"',current_timestamp(),0,'"+f.getAnswer()+"')";

        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);

    }

    public ArrayList<Feedback> findAll() throws SQLException {
        ArrayList<Feedback> results = new ArrayList<>();
        String request = "SELECT * FROM `Feedback` order by created_at DESC";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        while (rst.next()) {
            Feedback f = new Feedback();
            f.setId(rst.getInt("id"));
            f.setName(rst.getString(2));
            f.setLastname(rst.getString(3));
            f.setEmail(rst.getString(4));
            f.setPhone(rst.getString(5));
            f.setSubject(rst.getString(6));
            f.setMessage(rst.getString(7));
            f.setCreated_at(rst.getTimestamp(8));
            f.setIs_answered(rst.getInt(9));
            f.setAnswer(rst.getString(10));

            results.add(f);
        }


        return results;
    }

    public ArrayList<Feedback> findAllByUser(int id) throws SQLException {
        ArrayList<Feedback> results = new ArrayList<>();
        String request = "SELECT * FROM `Feedback` WHERE id_user="+id+" order by created_at DESC";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        while (rst.next()) {
            Feedback f = new Feedback();
            f.setId(rst.getInt("id"));
            f.setName(rst.getString(2));
            f.setLastname(rst.getString(3));
            f.setEmail(rst.getString(4));
            f.setPhone(rst.getString(5));
            f.setSubject(rst.getString(6));
            f.setMessage(rst.getString(7));
            f.setCreated_at(rst.getTimestamp(8));
            f.setIs_answered(rst.getInt(9));
            f.setAnswer(rst.getString(10));

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

    public void updateAnswered(Feedback f) throws SQLException {
        String request = "UPDATE `feedback` SET `is_answered`=1, answer=? WHERE `id` = ?";
        PreparedStatement pst = cnx.prepareStatement(request);
        pst.setString(1, f.getAnswer());
        pst.setInt(2, f.getId());
        pst.executeUpdate();

    }

    public ArrayList<Feedback> search(String search) throws SQLException {
        ArrayList<Feedback> results = new ArrayList<>();
        search="%"+search+"%";
        String request = "SELECT * FROM `Feedback` where (name LIKE ?) or (lastname LIKE ?) or (email LIKE ?) " +
                "or (phone LIKE ?) or (subject LIKE ?) or (message LIKE ?) or (created_at LIKE ?) order by created_at DESC";
        PreparedStatement pst = cnx.prepareStatement(request);
        pst.setString(1, search);
        pst.setString(2, search);
        pst.setString(3, search);
        pst.setString(4, search);
        pst.setString(5, search);
        pst.setString(6, search);
        pst.setString(7, search);
        ResultSet rst = pst.executeQuery();

        while (rst.next()) {
            Feedback f = new Feedback();
            f.setId(rst.getInt("id"));
            f.setName(rst.getString(2));
            f.setLastname(rst.getString(3));
            f.setEmail(rst.getString(4));
            f.setPhone(rst.getString(5));
            f.setSubject(rst.getString(6));
            f.setMessage(rst.getString(7));
            f.setCreated_at(rst.getTimestamp(8));
            f.setIs_answered(rst.getInt(9));
            f.setAnswer(rst.getString(10));

            results.add(f);
        }
        return results;
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
