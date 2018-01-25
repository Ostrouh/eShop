package org.ostroukh.model.service.impl;

import org.ostroukh.model.dao.CartDAO;
import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
