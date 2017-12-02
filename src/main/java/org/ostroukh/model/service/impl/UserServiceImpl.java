package org.ostroukh.model.service.impl;

import org.ostroukh.model.dao.UserDAO;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO dao;

    @Override
    public List<User> getUserByNameAndSurname(String name, String surname) {
        return dao.getByNameAndSurname(name, surname);
    }

    @Override
    public List<User> getUserBySurname(String surname) {
        return dao.getBySurname(surname);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAll();
    }

    @Override
    public void saveUser(User user) {
        dao.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return dao.getById(id);
    }
}
