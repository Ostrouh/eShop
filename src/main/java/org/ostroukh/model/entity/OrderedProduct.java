package org.ostroukh.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;

    /**
     * Product added by the customer in the specified order
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OrderedProduct that = (OrderedProduct) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(quantity, that.quantity)
                .append(order, that.order)
                .append(product, that.product)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(order)
                .append(product)
                .append(quantity)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "OrderedProduct{" +
                "orderID=" + order.getId() +
                ", productID=" + product.getId() +
                ", quantity=" + quantity +
                '}';
    }
}
