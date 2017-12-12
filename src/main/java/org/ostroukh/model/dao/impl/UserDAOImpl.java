package org.ostroukh.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ostroukh.model.dao.UserDAO;
import org.ostroukh.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of UserDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    //not correct
    @Override
    public List<User> getByNameAndSurname(String name, String surname) {
        Query query = getSession().createQuery("from User where name = :name and surname = :surname");
        query.setParameter("name", name);
        query.setParameter("surname", surname);

        return query.list();
    }

    @Override
    public List<User> getBySurname(String surname) {
        Query query = getSession().createQuery("from User where surname = :surname");
        query.setParameter("surname", surname);

        return query.list();
    }

    @Override
    public List<User> getAll() {
        return getSession().createQuery("from User").list();

    }

    @Override
    public void save(User entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public User getById(Integer id) {
        return getSession().get(User.class, id);
    }

    @Override
    public void delete(User entity) {
        getSession().delete(entity);
    }
}
