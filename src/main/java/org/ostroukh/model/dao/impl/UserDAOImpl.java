package org.ostroukh.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("surname",surname));
        return criteria.list();    }

    @Override
    public List<User> getBySurname(String surname) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("surname",surname));
        return criteria.list();
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
