package org.ostroukh.model.service.impl;

import org.ostroukh.model.dao.ProductDAO;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO dao;

    @Override
    public Product getProductByName(String name) {
        return dao.getByName(name);
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return dao.getByCategory(category);
    }

    @Override
    public List<Product> getAllProducts() {
        return dao.getAll();
    }

    @Override
    public void saveProduct(Product product) {
        dao.save(product);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return Optional.ofNullable(dao.getById(id));
    }

    @Override
    public void deleteProduct(Product product) {
        dao.delete(product);
    }

    @Override
    public List<Product> getProductByPriceInterval(int min, int max) {
        return dao.getByPriceInterval(min, max);
    }
}
