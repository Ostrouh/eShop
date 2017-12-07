package org.ostroukh.model.service.impl;

import org.ostroukh.model.dao.OrderDAO;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO dao;

    @Override
    public List<Order> getOrderByUser(User user) {
        return dao.getByUser(user);
    }

    @Override
    public List<Order> getOrderByProduct(Product product) {
        return dao.getByProduct(product);
    }

    @Override
    public List<Order> getAllOrders() {
        return dao.getAll();
    }

    @Override
    public void saveOrder(Order order) {
        dao.save(order);
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        return Optional.ofNullable(dao.getById(id));
    }

    @Override
    public void deleteOrder(Order order) {
        dao.delete(order);
    }
}
