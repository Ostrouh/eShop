package org.ostroukh.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.ostroukh.model.entity.base.AbstractEntity;
import org.ostroukh.model.entity.enums.OrderStatus;

import javax.persistence.*;
import java.util.List;

/**
 * Entity that contains data of a specific order
 * @author Eugene Ostroukh
 */
@Table(name = "ORDERS") // Name of table is "ORDERS" because the "ORDER" is keyword in SQL
@Entity
public class Order extends AbstractEntity {
    /**
     * User who placed an order
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    /**
     * Status of order
     */
    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

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

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(user, order.user)
                .append(products, order.products)
                .append(status, order.status)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(user)
                .append(products)
                .append(status)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + getId() + '\'' +
                ", status='" + status.toString() + '\'' +
                '}';
    }
}
