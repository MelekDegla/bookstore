package com.vermeg.bookstore.service.implementation;
import com.vermeg.bookstore.model.Events;
import com.vermeg.bookstore.service.IEventService;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;

public class EventsService implements IEventService {

    private Connection cnx;

    public EventsService() {
        cnx = DBConnection.getInstance().getConnection();
    }

    public void insert(Events e) throws SQLException {
        try {
           // Date date = new SimpleDateFormat("yyyy-MM-dd").parse(e.getDate());
            Date date= e.getDate();
            String request = "INSERT INTO events (`ID`, `title`, `description`, `date`, `MAX_PARTICIPANTS`, `lieu`) " +
                    "VALUES (NULL,'" + e.getTitle() + "','"+ e.getDescription()+ "','"+ new java.sql.Date(date.getTime()) + "','"+ e.getMAX_PARTICIPANTS() + "','"+ e.getLieu() +"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(request);
        } catch (SQLException parseException) {
            parseException.printStackTrace();
        }


    }

    public ArrayList<Events> findAll() throws SQLException {
        ArrayList<Events> results = new ArrayList<>();
        String request = " SELECT * FROM events ";

        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        while (rst.next()) {
            Events e = new Events();
            e.setID(rst.getInt("id"));
            e.setTitle(rst.getString(2));
            e.setDescription(rst.getString(3));
            e.setDate(rst.getDate("date"));
           //e.setDate(new java.sql.Date(4));
            e.setMAX_PARTICIPANTS(rst.getInt(5));
            e.setLieu(rst.getString(6));
            results.add(e);

        }

        return results;
    }

    public Events findById(int ID) throws SQLException {
        String request = "SELECT * FROM `events` WHERE id =" + ID;
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);

        if (rst.next()) {
            Events e = new Events();
            e.setID(rst.getInt("id"));
            e.setTitle(rst.getString(2));
            e.setDescription(rst.getString(3));
            e.setDate(rst.getDate(4));
            e.setMAX_PARTICIPANTS(rst.getInt(5));
            e.setLieu(rst.getString(6));

            return e;
        }

        return null;
    }


    public void update(Events e) throws SQLException {
        try {
            //Date date = new SimpleDateFormat("yyyy-MM-dd").parse(e.getDate());
            Date date = e.getDate();
            String request = "UPDATE `events` SET `lieu`=?,`MAX_PARTICIPANTS`=? ,`date`=?,`description`=?,`title`=? "
                    + "WHERE `id` = ?";
            PreparedStatement pst = cnx.prepareStatement(request);

            pst.setString(1, e.getLieu());
            pst.setInt(2, e.getMAX_PARTICIPANTS());
            pst.setDate(3, new java.sql.Date(date.getTime()));
            pst.setString(4, e.getDescription());
            pst.setString(5, e.getTitle());
            pst.setInt(6, e.getID());
            pst.executeUpdate();
        } catch (SQLException parseException) {
            parseException.printStackTrace();
        }




    }

    @Override
    public void delete(Events entity) throws SQLException {

    }


    public void deleteById(int ID) throws SQLException {
        String request = "DELETE FROM `events` WHERE id =" + ID;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }




}
