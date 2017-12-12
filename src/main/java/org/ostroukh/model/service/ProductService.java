package org.ostroukh.model.service;

import org.ostroukh.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product getProductByName(String name);

    List<Product> getProductByCategory(String category);

    List<Product> getAllProducts();

    void saveProduct(Product product);

    Optional<Product> getProductById(Integer id);

    void deleteProduct(Product product);

    List<Product> getProductByPriceInterval(int min, int max);
}
