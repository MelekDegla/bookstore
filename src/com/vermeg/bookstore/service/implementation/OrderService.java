package com.vermeg.bookstore.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.vermeg.bookstore.model.Order;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class OrderService {

    private Connection connection;

    public OrderService() {
        connection = DBConnection.getInstance().getConnection();
    }

    public void add(Order order) throws SQLException {
        String request = "INSERT INTO `order` (`id`, `status`, `user_id`)"
                + " VALUES (NULL, " + order.getStatus() + ", " + order.getUserId() + ")";

        Statement stm = connection.createStatement();
        stm.executeUpdate(request);
    }


    public ArrayList<Order> findAll() throws SQLException {
        ArrayList<Order> results = new ArrayList<>();
        String request = "SELECT * FROM `order`";
        ResultSet rst = connection.createStatement().executeQuery(request);

        while (rst.next()) {
            results.add(new Order(rst.getInt("id"), rst.getInt("status"),rst.getInt("user_id") ));
        }

        return results;
    }

    public Order findById(int id) throws SQLException {
        String request = "SELECT * FROM `order` WHERE id =" + id;
        ResultSet rst = connection.createStatement().executeQuery(request);

        if (rst.next()) {

            return new Order(rst.getInt("id"), rst.getInt("status"),rst.getInt("user_id") );
        }

        return null;
    }

    public void update(Order order) throws SQLException {
        String request = "UPDATE `order` SET `status`=?,`user_id`=? "
                + "WHERE `id` = ?";
        PreparedStatement pst = connection.prepareStatement(request);

        pst.setInt(1, order.getStatus());
        pst.setInt(2, order.getUserId());
        pst.setInt(3, order.getId());
        pst.executeUpdate();

    }

    public void delete(int id) throws SQLException {
        String request = "DELETE FROM `order` WHERE id =" + id;

        connection.createStatement().executeUpdate(request);
    }
}
