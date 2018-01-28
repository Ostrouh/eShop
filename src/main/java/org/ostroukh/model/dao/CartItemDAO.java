package org.ostroukh.model.dao;

import org.ostroukh.model.dao.base.AbstractDAO;
import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.CartItem;

import java.util.List;

public interface CartItemDAO extends AbstractDAO<CartItem, Integer> {

    /**
     * Returns list of items in specific cart
     *
     * @param cart@return
     */
    List<CartItem> getByCart(Cart cart);
}
