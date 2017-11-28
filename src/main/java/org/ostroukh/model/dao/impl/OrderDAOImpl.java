package org.ostroukh.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.ostroukh.model.dao.OrderDAO;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Implementation of OrderDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public List<Order> getByUser(User user) {
        return null;
    }

    @Override
    public List<Order> getByProduct(Product product) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        Criteria criteria = getSession().createCriteria(Order.class);
        return (List<Order>) criteria.list();
    }

    @Override
    public void save(Order entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public Order getById(Integer id) {
        Criteria criteria = getSession().createCriteria(Order.class);
        criteria.add(Restrictions.eq("id",id));
        return (Order) criteria.uniqueResult();
    }
}
