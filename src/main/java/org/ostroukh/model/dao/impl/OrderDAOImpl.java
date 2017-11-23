package org.ostroukh.model.dao.impl;

import org.ostroukh.model.dao.OrderDAO;
import org.ostroukh.model.entity.Order;

import java.util.List;

/**
 * Implementation of OrderDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
public class OrderDAOImpl implements OrderDAO {
    @Override
    public List<Order> getByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<Order> getByProductId(Integer productId) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public void save(Order entity) {

    }

    @Override
    public Order getById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
