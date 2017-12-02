package org.ostroukh.model.service;

import org.ostroukh.model.entity.Product;

import java.util.List;

public interface ProductService {

    Product getProductByName(String name);

    List<Product> getProductByCategory(String category);

    List<Product> getAllProducts();

    void saveProduct(Product product);

    Product getProductById(Integer id);
}
