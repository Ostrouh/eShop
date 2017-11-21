package org.ostroukh.model.dao.impl;

import org.ostroukh.model.dao.AbstractDAO;
import org.ostroukh.model.entity.Order;

import java.util.List;

public class OrderDAO implements AbstractDAO<Order, Integer> {
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
