package org.ostroukh.model.service;

import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.CartItem;

import java.util.List;
import java.util.Optional;

public interface CartItemService {

    List<CartItem> getAllCartItems();

    void saveCartItem(CartItem cartItem);

    Optional<CartItem> getCartItemById(Integer id);

    void deleteCartItem(CartItem cartItem);

    List<CartItem> getCartItemsByCart(Cart cart);
}
