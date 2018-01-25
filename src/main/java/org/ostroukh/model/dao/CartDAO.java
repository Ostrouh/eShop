package org.ostroukh.model.dao;

import org.ostroukh.model.dao.base.AbstractDAO;
import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.User;

public interface CartDAO extends AbstractDAO<Cart, Integer> {

    /**
     * Returns list of orders that belong to specific user
     *
     * @param user@return
     */
    Cart getByUser(User user);

}
