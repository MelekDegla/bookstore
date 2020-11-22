package com.vermeg.bookstore;

import com.vermeg.bookstore.model.Order;
import com.vermeg.bookstore.model.OrderDetails;
import com.vermeg.bookstore.service.implementation.OrderDetailsService;
import com.vermeg.bookstore.service.implementation.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderTest {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        OrderDetailsService orderDetailsService = new OrderDetailsService();
        try {
            System.out.println("*-*-*-*-*-*-*- ORDER -*--*-*-*-*-*-*-*");
            orderService.add(new Order(5,6));
            orderService.add(new Order(5,8));
            List<Order> orderList = orderService.findAll();
            System.out.println("------------ list -------------");
            orderList.forEach(System.out::println);
            System.out.println("-------------end list ----------");
            Order orderToUpdate = orderList.get(0);
            orderToUpdate.setStatus(105998);
            orderService.update(orderToUpdate);
            orderService.delete(orderService.findAll().get(1).getId());

            System.out.println("------------updated list -----------");
            List<Order> ordersUpdated = orderService.findAll();
            ordersUpdated.forEach(System.out::println);
            System.out.println("----------------end updated list ------------");
            System.out.println("*-*-*-*-*-*-*- END ORDER -*--*-*-*-*-*-*-*");
            System.out.println("-------------------------------------------");
            System.out.println("-------------------------------------------");
            System.out.println("*-*-*-*-*-*-*- ORDER Details-*--*-*-*-*-*-*-*");
            orderDetailsService.add(new OrderDetails(ordersUpdated.get(1).getId(),5,2));
            orderDetailsService.add(new OrderDetails(ordersUpdated.get(2).getId(),6,1));
            List<OrderDetails> orderDetails = orderDetailsService.findAll();
            System.out.println("--------------------- order details list ------------");
            orderDetails.forEach(System.out::println);
            System.out.println("--------------------- end order details list ------------");

            orderDetailsService.delete(orderDetails.get(0).getOrderId(), orderDetails.get(0).getBookId());
            OrderDetails orderDetailsToUpdate = orderDetails.get(1);
            orderDetailsToUpdate.setQuantity(6);
            orderDetailsService.update(orderDetailsToUpdate);
            System.out.println("------------------ updated order Details list ------------------");
            orderDetailsService.findAll().forEach(System.out::println);
            System.out.println("------------------ updated order Details list ------------------");
            System.out.println("*-*-*-*-*-*-*- END ORDER Details -*--*-*-*-*-*-*-*");


        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
