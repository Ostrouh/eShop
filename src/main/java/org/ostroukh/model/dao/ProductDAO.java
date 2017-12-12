package org.ostroukh.model.dao;

import org.ostroukh.model.dao.base.AbstractDAO;
import org.ostroukh.model.entity.Product;

import java.util.List;

/**
 * Defines CRUD methods to access Product objects in the DB
 * @author Eugene Ostroukh
 */
public interface ProductDAO extends AbstractDAO<Product, Integer> {

    /**
     * Returns product by name
     * @param name
     * @return
     */
    Product getByName (String name);

    /**
     * Returns list of products that contains in specific category
     * @param category
     * @return
     */
    List<Product> getByCategory(String category);

    /**
     * Returns a list of products whose price is in a certain price range
     * @param min
     * @param max
     * @return
     */
    List<Product> getByPriceInterval(int min, int max);
}
