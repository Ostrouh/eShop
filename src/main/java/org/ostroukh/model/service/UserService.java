package org.ostroukh.model.service;

import org.ostroukh.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUserByNameAndSurname(String name, String surname);

    List<User> getUserBySurname(String surname);

    List<User> getAllUsers();

    void saveUser(User user);

    Optional<User> getUserById(Integer id);

    void deleteUser(User user);

}
