package org.ostroukh.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ostroukh.model.dao.OrderDAO;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of OrderDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public List<Order> getByUser(User user) {
        Query query = getSession().createQuery("from Order where user = :user");
        query.setParameter("user", user);

        return query.list();
    }

    @Override
    public List<Order> getByProduct(Product product) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return getSession().createQuery("from Order").list();
    }

    @Override
    public void save(Order entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public Order getById(Integer id) {
        return getSession().get(Order.class, id);
    }

    @Override
    public void delete(Order entity) {
        getSession().delete(entity);
    }
}
