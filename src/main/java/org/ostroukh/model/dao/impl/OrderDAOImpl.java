package org.ostroukh.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ostroukh.model.dao.OrderDAO;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of OrderDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public List<Order> getByUser(User user) {
        Query query = getSession().createQuery("from Order where user = :user");
        query.setParameter("user", user);
        List<Order> orders = query.list();

        for(Order order: orders){
            LOGGER.info("Orders by user: " + order);
        }
        return orders;
    }

    @Override
    public List<Order> getByProduct(Product product) {
        List<Order> orders = getAll().stream()
                .filter(order -> order.getProducts().contains(product))
                .collect(Collectors.toList());

        for(Order order: orders){
            LOGGER.info("Orders by product: " + order);
        }
        return orders;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = getSession().createQuery("from Order").list();

        for(Order order: orders){
            LOGGER.info("Orders list: " + order);
        }
        return orders;
    }

    @Override
    public void save(Order entity) {
        entity.prePersist();
        getSession().saveOrUpdate(entity);

        LOGGER.info("Save or update successful. Order details: " + entity);
    }

    @Override
    public Order getById(Integer id) {
        Order order = getSession().get(Order.class, id);

        LOGGER.info("Successfully loaded. Order details: " + order);
        return order;
    }

    @Override
    public void delete(Order entity) {
        getSession().delete(entity);

        LOGGER.info("Successfully deleted. Order details: " + entity);
    }
}
