package org.ostroukh.model.dao.impl;

import org.ostroukh.model.dao.AbstractDAO;
import org.ostroukh.model.entity.Product;

import java.util.List;

public class ProductDAO implements AbstractDAO<Product, Integer> {
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public void save(Product entity) {

    }

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
