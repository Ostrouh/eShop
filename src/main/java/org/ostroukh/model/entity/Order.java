package org.ostroukh.model.entity;

import org.ostroukh.model.entity.base.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Entity that contains data of a specific order
 * @author Eugene Ostroukh
 */
@Table(name = "ORDER")
@Entity
public class Order extends AbstractEntity {
    /**
     * User who placed an order
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;
;
    /**
     * List of products in specific order
     *In one order there may be many instances of the product, therefore used List.
     */
    @ManyToMany
    @JoinTable(name = "ORDER_PRODUCT",
                joinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID"),
                inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID"))
    private List<Product> products;

    public Order(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public Order() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
