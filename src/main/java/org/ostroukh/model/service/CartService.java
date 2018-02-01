package org.ostroukh.model.service;

import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.User;

import java.util.Optional;

public interface CartService {
    Cart getCartByUser(User user);

    void saveCart(Cart cart);

    Optional<Cart> getCartById(Integer id);

    void deleteCart(Cart cart);

    int getTotalCost(Cart cart);

    int getItemsInCart(Cart cart);

    void clearCart(Cart cart);
}
