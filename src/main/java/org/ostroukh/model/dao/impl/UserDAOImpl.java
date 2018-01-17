package org.ostroukh.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ostroukh.model.dao.UserDAO;
import org.ostroukh.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of UserDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);


    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<User> getByNameAndSurname(String name, String surname) {
        Query query = getSession().createQuery("from User where name = :name and surname = :surname");
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        List<User> users = query.list();

        for(User user: users){
            LOGGER.info("Users list: " + user);
        }
        return users;
    }

    @Override
    public List<User> getBySurname(String surname) {
        Query query = getSession().createQuery("from User where surname = :surname");
        query.setParameter("surname", surname);
        List<User> users = query.list();

        for(User user: users){
            LOGGER.info("Users list: " + user);
        }
        return users;
    }

    @Override
    public User getByLogin(String login) {
        Query query = getSession().createQuery("from User where credential.login = :login");
        query.setParameter("login", login);
        User user = (User) query.uniqueResult();

        LOGGER.info("Successfully loaded. User details: " + user);
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = getSession().createQuery("from User").list();

        for(User user: users){
            LOGGER.info("Users list: " + user);
        }
        return users;
    }

    @Override
    public void save(User entity) {
        entity.prePersist();
        getSession().saveOrUpdate(entity);

        LOGGER.info("Save or update successful. User details: " + entity);
    }

    @Override
    public User getById(Integer id) {
        User user = getSession().get(User.class, id);

        LOGGER.info("Successfully loaded. User details: " + user);
        return user;
    }

    @Override
    public void delete(User entity) {
        getSession().delete(entity);

        LOGGER.info("Successfully deleted. User details: " + entity);
    }
}
