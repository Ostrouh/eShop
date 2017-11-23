package org.ostroukh.model.dao;

import org.ostroukh.model.dao.base.AbstractDAO;
import org.ostroukh.model.entity.Order;

import java.util.List;

/**
 * Defines CRUD methods to access Order objects in the DB
 * @author Eugene Ostroukh
 */
public interface OrderDAO extends AbstractDAO<Order, Integer> {

    /**
     * Returns list of orders that belong to specific user
     * @param userId
     * @return
     */
    List<Order> getByUserId(Integer userId);

    /**
     * Returns list of orders that contains specific product
     * @param productId
     * @return
     */
    List<Order> getByProductId(Integer productId);
}
