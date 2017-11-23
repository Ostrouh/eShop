package org.ostroukh.model.dao.impl;

import org.ostroukh.model.dao.ProductDAO;
import org.ostroukh.model.entity.Product;

import java.util.List;

/**
 * Implementation of ProductDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
public class ProductDAOImpl implements ProductDAO {
    @Override
    public Product getByName(String name) {
        return null;
    }

    @Override
    public List<Product> getByCategory(String category) {
        return null;
    }

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
