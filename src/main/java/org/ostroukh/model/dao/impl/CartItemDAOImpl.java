package org.ostroukh.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ostroukh.model.dao.CartItemDAO;
import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.CartItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of CartItemDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
@Repository("cartItemDAO")
public class CartItemDAOImpl implements CartItemDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartItemDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List getAll() {
        List<CartItem> cartItems = getSession().createQuery("from CartItem ").list();

        for(CartItem cartItem: cartItems){
            LOGGER.info("Cart items list: " + cartItem);
        }
        return cartItems;
    }

    @Override
    public void save(CartItem entity) {
        entity.prePersist();
        getSession().saveOrUpdate(entity);

        LOGGER.info("Save or update successful. Cart item details: " + entity);
    }

    @Override
    public CartItem getById(Integer id) {
        CartItem cartItem = getSession().get(CartItem.class, id);

        LOGGER.info("Successfully loaded. Cart item details: " + cartItem);
        return cartItem;
    }

    @Override
    public void delete(CartItem entity) {
        getSession().delete(entity);

        LOGGER.info("Successfully deleted. Cart item details: " + entity);
    }

    @Override
    public List<CartItem> getByCart(Cart cart) {
        Query query = getSession().createQuery("from CartItem where cart = :cart");
        query.setParameter("cart", cart);
        List<CartItem> items = query.list();

        for(CartItem item: items){
            LOGGER.info("CartItems by Cart: " + item);
        }
        return items;
    }
}
