package org.ostroukh.model.dao;

import org.ostroukh.model.dao.base.AbstractDAO;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.OrderedProduct;
import org.ostroukh.model.entity.Product;

import java.util.List;

/**
 * Defines CRUD methods to access OrderedProduct objects in the DB
 * @author Eugene Ostroukh
 */
public interface OrderedProductDAO extends AbstractDAO<OrderedProduct, Integer>{

    /**
     * Returns list of ordered products that contains to specific product
     *
     * @param product
     * @return
     */
    List<OrderedProduct> getByProduct(Product product);

    /**
     * Returns a list of ordered products that are contained in a specific order
     *
     * @param order
     * @return
     */
    List<OrderedProduct> getByOrder(Order order);
}
