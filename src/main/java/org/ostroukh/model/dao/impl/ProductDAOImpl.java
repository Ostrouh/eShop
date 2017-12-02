package org.ostroukh.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.ostroukh.model.dao.ProductDAO;
import org.ostroukh.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of ProductDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Product getByName(String name) {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.eq("name",name));
        return (Product) criteria.uniqueResult();
    }

    @Override
    public List<Product> getByCategory(String category) {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.eq("category",category));
        return criteria.list();
    }

    @Override
    public List<Product> getAll() {
        Criteria criteria = getSession().createCriteria(Product.class);
        return (List<Product>) criteria.list();
    }

    @Override
    public void save(Product entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public Product getById(Integer id) {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.eq("id",id));
        return (Product) criteria.uniqueResult();
    }
}
