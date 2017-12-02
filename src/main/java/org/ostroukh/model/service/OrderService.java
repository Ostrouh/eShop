package org.ostroukh.model.service;

import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.entity.User;

import java.util.List;

public interface OrderService {

    List<Order> getOrderByUser(User user);

    List<Order> getOrderByProduct(Product product);

    List<Order> getAllOrders();

    void saveOrder(Order order);

    Order getOrderById(Integer id);
}
