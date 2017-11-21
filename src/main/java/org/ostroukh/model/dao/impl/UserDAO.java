package org.ostroukh.model.dao.impl;

import org.ostroukh.model.dao.AbstractDAO;
import org.ostroukh.model.entity.User;

import java.util.List;

public class UserDAO implements AbstractDAO<User, Integer> {

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
