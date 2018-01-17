package org.ostroukh.model.service;

import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.OrderedProduct;
import org.ostroukh.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface OrderedProductService {

    List<OrderedProduct> getOrderedProductsByProduct(Product product);

    List<OrderedProduct> getOrderedProductByOrder(Order order);

    List<OrderedProduct> getAllOrderedProduct();

    void saveOrderedProduct(OrderedProduct orderedProduct);

    Optional<OrderedProduct> getOrderedProductById(Integer id);

    void deleteOrderedProduct(OrderedProduct orderedProduct);
}
