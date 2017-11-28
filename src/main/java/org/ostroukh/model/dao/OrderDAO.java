package org.ostroukh.model.dao;

import org.ostroukh.model.dao.base.AbstractDAO;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.entity.User;

import java.util.List;

/**
 * Defines CRUD methods to access Order objects in the DB
 * @author Eugene Ostroukh
 */
public interface OrderDAO extends AbstractDAO<Order, Integer> {

    /**
     * Returns list of orders that belong to specific user
     *
     * @param user@return
     */
    List<Order> getByUser(User user);

    /**
     * Returns list of orders that contains specific product
     *
     * @param product@return
     */
    List<Order> getByProduct(Product product);
}
