package org.ostroukh.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
        Query query = getSession().createQuery("from Product where name = :name");
        query.setParameter("name", name);

        return (Product) query.uniqueResult();
    }

    @Override
    public List<Product> getByCategory(String category) {
        Query query = getSession().createQuery("from Product where category = :category");
        query.setParameter("category", category);

        return query.list();
    }

    @Override
    public List<Product> getByPriceInterval(int min, int max) {
        Query query = getSession().createQuery("from Product P where P.price >= :minPrice and P.price <= :maxPrice" +
                " order by P.price");
        query.setParameter("minPrice", min);
        query.setParameter("maxPrice", max);

        return query.list();
    }

    @Override
    public List<Product> getAll() {
        return getSession().createQuery("from Product").list();
    }

    @Override
    public void save(Product entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public Product getById(Integer id) {
        return getSession().get(Product.class, id);
    }

    @Override
    public void delete(Product entity) {
        getSession().delete(entity);
    }
}
