package org.ostroukh.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ostroukh.model.dao.CartDAO;
import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of OrderDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Cart getByUser(User user) {
        Query query = getSession().createQuery("from Cart where user = :user");
        query.setParameter("user", user);
        Cart cart = (Cart) query.uniqueResult();

        LOGGER.info("Successfully loaded. Cart details: " + cart);
        return cart;
    }

    @Override
    public List<Cart> getAll() {
        List<Cart> carts = getSession().createQuery("from Cart ").list();

        for(Cart cart: carts){
            LOGGER.info("Carts list: " + cart);
        }
        return carts;
    }

    @Override
    public void save(Cart entity) {
        entity.prePersist();
        getSession().saveOrUpdate(entity);

        LOGGER.info("Save or update successful. Cart details: " + entity);
    }

    @Override
    public Cart getById(Integer id) {
        Cart cart = getSession().get(Cart.class, id);

        LOGGER.info("Successfully loaded. Cart details: " + cart);
        return cart;
    }

    @Override
    public void delete(Cart entity) {
        getSession().delete(entity);

        LOGGER.info("Successfully deleted. Cart details: " + entity);
    }
}
