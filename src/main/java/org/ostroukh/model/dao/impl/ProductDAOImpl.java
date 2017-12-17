package org.ostroukh.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.ostroukh.model.dao.ProductDAO;
import org.ostroukh.model.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of ProductDAO interface that work with DB by Hibernate
 * @author Eugene Ostroukh
 */
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAOImpl.class);


    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Product getByName(String name) {
        Query query = getSession().createQuery("from Product where name = :name");
        query.setParameter("name", name);
        Product product = (Product) query.uniqueResult();

        LOGGER.info("Successfully loaded. Product details: " + product);
        return product;
    }

    @Override
    public List<Product> getByCategory(String category) {
        Query query = getSession().createQuery("from Product where category = :category");
        query.setParameter("category", category);
        List<Product> products = query.list();

        for(Product product: products){
            LOGGER.info("Products list: " + product);
        }
        return products;
    }

    @Override
    public List<Product> getByPriceInterval(int min, int max) {
        Query query = getSession().createQuery("from Product P where P.price >= :minPrice and P.price <= :maxPrice" +
                " order by P.price");
        query.setParameter("minPrice", min);
        query.setParameter("maxPrice", max);
        List<Product> products = query.list();

        for(Product product: products){
            LOGGER.info("Products list: " + product);
        }
        return products;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = getSession().createQuery("from Product").list();

        for(Product product: products){
            LOGGER.info("Products list: " + product);
        }
        return products;
    }

    @Override
    public void save(Product entity) {
        entity.prePersist();
        getSession().saveOrUpdate(entity);

        LOGGER.info("Save or update successful. Product details: " + entity);
    }

    @Override
    public Product getById(Integer id) {
        Product product =  getSession().get(Product.class, id);

        LOGGER.info("Successfully loaded. Product details: " + product);
        return product;
    }

    @Override
    public void delete(Product entity) {
        getSession().delete(entity);

        LOGGER.info("Successfully deleted. Product details: " + entity);

    }
}
