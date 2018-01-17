package org.ostroukh.model.service.impl;

import org.ostroukh.model.dao.OrderedProductDAO;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.OrderedProduct;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.service.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("orderedProductService")
@Transactional
public class OrderedProductServiceImpl implements OrderedProductService{
    @Autowired
    OrderedProductDAO dao;

    @Override
    public List<OrderedProduct> getOrderedProductsByProduct(Product product) {
        return dao.getByProduct(product);
    }

    @Override
    public List<OrderedProduct> getOrderedProductByOrder(Order order) {
        return dao.getByOrder(order);
    }

    @Override
    public List<OrderedProduct> getAllOrderedProduct() {
        return dao.getAll();
    }

    @Override
    public void saveOrderedProduct(OrderedProduct orderedProduct) {
        dao.save(orderedProduct);
    }

    @Override
    public Optional<OrderedProduct> getOrderedProductById(Integer id) {
        return Optional.ofNullable(dao.getById(id));
    }

    @Override
    public void deleteOrderedProduct(OrderedProduct orderedProduct) {
        dao.delete(orderedProduct);
    }
}
