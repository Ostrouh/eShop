package org.ostroukh.model.service.impl;

import org.ostroukh.model.dao.CartItemDAO;
import org.ostroukh.model.entity.CartItem;
import org.ostroukh.model.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("cartItemService")
@Transactional
public class CartItemServiceImpl implements CartItemService{
    @Autowired
    CartItemDAO dao;

    @Override
    public List<CartItem> getAllCartItems() {
        return dao.getAll();
    }

    @Override
    public void saveCartItem(CartItem cartItem) {
        dao.save(cartItem);
    }

    @Override
    public Optional<CartItem> getCartItemById(Integer id) {
        return Optional.ofNullable(dao.getById(id));
    }

    @Override
    public void deleteCartItem(CartItem cartItem) {
        dao.delete(cartItem);
    }
}
