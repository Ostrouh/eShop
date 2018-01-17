package org.ostroukh.model.dao;

import org.ostroukh.model.dao.base.AbstractDAO;
import org.ostroukh.model.entity.User;

import java.util.List;

/**
 * Defines CRUD methods to access User objects in the DB
 * @author Eugene Ostroukh
 */
public interface UserDAO extends AbstractDAO<User, Integer> {

    /**
     * Gets list of users who has specific name and surname
     * @param name
     * @param surname
     * @return
     */
    List<User> getByNameAndSurname(String name, String surname);

    /**
     * Gets list of users who has specific surname
     * @param surname
     * @return
     */
    List<User> getBySurname(String surname);

    /**
     * Returns user by login
     * @param login
     * @return
     */
    User getByLogin(String login);

}
