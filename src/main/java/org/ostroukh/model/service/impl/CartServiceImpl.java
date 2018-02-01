package org.ostroukh.model.service.impl;

import org.ostroukh.model.dao.CartDAO;
import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.CartItem;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService{
    @Autowired
    CartDAO dao;

    @Override
    public Cart getCartByUser(User user) {
        return dao.getByUser(user);
    }

    @Override
    public void saveCart(Cart cart) {
        dao.save(cart);
    }

    @Override
    public Optional<Cart> getCartById(Integer id) {
        return Optional.ofNullable(dao.getById(id));
    }

    @Override
    public void deleteCart(Cart cart) {
        dao.delete(cart);
    }

    @Override
    public int getTotalCost(Cart cart) {
        List<CartItem> items = cart.getCartItems();
        int sum = 0;

        for(CartItem item: items){
            sum += item.getQuantity() * item.getProduct().getPrice();
        }
        return sum;
    }

    @Override
    public int getItemsInCart(Cart cart) {
        return cart.getCartItems().stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    @Override
    public void clearCart(Cart cart) {
        List<CartItem> items = cart.getCartItems();
        items.clear();
        cart.setCartItems(items);
        cart.setTotalCost(0);
        cart.setItemsAmount(0);
    }
}
