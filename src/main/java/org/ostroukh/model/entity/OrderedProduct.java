package org.ostroukh.model.entity;

import org.ostroukh.model.entity.base.AbstractEntity;

import javax.persistence.*;

/**
 * Entity that contains the ordered product and its quantity
 * @author Eugene Ostroukh
 */
@Table(name = "ORDERED_PRODUCT")
@Entity
public class OrderedProduct extends AbstractEntity{

    /**
     * Order that contains specified product
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;

    /**
     * Product added by the customer in the specified order
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    /**
     * The number of products that were added in the order
     */
    @Column(name = "QUANTITY")
    private int quantity;

    public OrderedProduct() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
