package org.ostroukh.model.service;

import org.ostroukh.model.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUserByNameAndSurname(String name, String surname);

    List<User> getUserBySurname(String surname);

    List<User> getAllUsers();

    void saveUser(User user);

    public User getUserById(Integer id);



}
