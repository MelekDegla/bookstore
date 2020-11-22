package com.vermeg.bookstore.service;
import com.vermeg.bookstore.model.Events;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class EventsService {

    private Connection cnx;

    public EventsService() {
        cnx = DBConnection.getInstance().getConnection();
    }

    public void addEvents(Events e) throws SQLException {
        String request = "INSERT INTO events (`ID`, `title`, `description`, `date`, `MAX_PARTICIPANTS`, `lieu`) " +
                "VALUES (NULL,'" + e.getTitle() + "','"+ e.getDescription()+ "','"+ e.getDate() + "','"+ e.getMAX_PARTICIPANTS() + "','"+ e.getLieu() +"')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<Events> getEvents() throws SQLException {
        ArrayList<Events> results = new ArrayList<>();
        String request = " SELECT * FROM events ";

        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        while (rst.next()) {
            Events e = new Events();
            e.setID(rst.getInt("id"));
            e.setTitle(rst.getString(2));
            e.setDescription(rst.getString(3));
            e.setDate(rst.getString(4));
            e.setMAX_PARTICIPANTS(rst.getInt(5));
            e.setLieu(rst.getString(6));
            results.add(e);

        }

        return results;
    }

    public Events getEvents(int ID) throws SQLException {
        String request = "SELECT * FROM `events` WHERE id =" + ID;
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        if (rst.next()) {
            Events e = new Events();
            e.setID(rst.getInt("id"));
            e.setTitle(rst.getString(2));
            e.setDescription(rst.getString(3));
            e.setDate(rst.getString(4));
            e.setMAX_PARTICIPANTS(rst.getInt(5));
            e.setLieu(rst.getString(6));

            return e;
        }

        return null;
    }


    public void updateEvents(Events e) throws SQLException {
        String request = "UPDATE `events` SET `lieu`=?,`MAX_PARTICIPANTS`=? ,`date`=?,`description`=?,`title`=? "
                + "WHERE `id` = ?";
        PreparedStatement pst = cnx.prepareStatement(request);

        pst.setString(1, e.getLieu());
        pst.setInt(2, e.getMAX_PARTICIPANTS());
        pst.setString(3,  e.getDate());
        pst.setString(4, e.getDescription());
        pst.setString(5, e.getTitle());
        pst.setInt(6, e.getID());
        pst.executeUpdate();


    }


    public void deleteEvents(int ID) throws SQLException {
        String request = "DELETE FROM `events` WHERE id =" + ID;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }



}
