package org.ostroukh.model.service;

import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getOrdersByUser(User user);

    List<Order> getOrderByProduct(Product product);

    List<Order> getAllOrders();

    void saveOrder(Order order);

    Optional<Order> getOrderById(Integer id);

    void deleteOrder(Order order);


}
