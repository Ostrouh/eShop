package org.ostroukh.model.dao.impl;

import org.ostroukh.model.dao.UserDAO;
import org.ostroukh.model.entity.User;

import java.util.List;

/**
 * Implementation of UserDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getByName(String name) {
        return null;
    }

    @Override
    public List<User> getBySurname(String surname) {
        return null;
    }

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
