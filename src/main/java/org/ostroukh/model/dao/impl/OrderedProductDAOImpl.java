package org.ostroukh.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ostroukh.model.dao.OrderedProductDAO;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.OrderedProduct;
import org.ostroukh.model.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderedProductDAO")
public class OrderedProductDAOImpl implements OrderedProductDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderedProductDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<OrderedProduct> getByProduct(Product product) {
        Query query = getSession().createQuery("from OrderedProduct where product = :product");
        query.setParameter("product", product);

        List<OrderedProduct> orderedProducts = query.list();
        for(OrderedProduct orderedProduct: orderedProducts){
            LOGGER.info("OrderedProduct by product: " + orderedProduct);
        }
        return orderedProducts;
    }

    @Override
    public List<OrderedProduct> getByOrder(Order order) {
        Query query = getSession().createQuery("from OrderedProduct where order = :order");
        query.setParameter("order", order);

        List<OrderedProduct> orderedProducts = query.list();
        for(OrderedProduct orderedProduct: orderedProducts){
            LOGGER.info("OrderedProduct by order: " + orderedProduct);
        }
        return orderedProducts;
    }

    @Override
    public List<OrderedProduct> getAll() {
        List<OrderedProduct> orderedProducts = getSession().createQuery("from OrderedProduct ").list();

        for(OrderedProduct orderedProduct: orderedProducts){
            LOGGER.info("Orders list: " + orderedProduct);
        }
        return orderedProducts;
    }

    @Override
    public void save(OrderedProduct entity) {
        entity.prePersist();
        getSession().saveOrUpdate(entity);

        LOGGER.info("Save or update successful. OrderedProduct details: " + entity);
    }

    @Override
    public OrderedProduct getById(Integer id) {
        OrderedProduct orderedProduct = getSession().get(OrderedProduct.class, id);

        LOGGER.info("Successfully loaded. OrderedProduct details: " + orderedProduct);
        return orderedProduct;
    }

    @Override
    public void delete(OrderedProduct entity) {
        getSession().delete(entity);

        LOGGER.info("Successfully deleted. OrderedProduct details: " + entity);
    }
}
