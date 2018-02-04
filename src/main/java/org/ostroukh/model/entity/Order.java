package org.ostroukh.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.ostroukh.model.entity.base.AbstractEntity;
import org.ostroukh.model.entity.enums.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity that contains data of a specific order
 * @author Eugene Ostroukh
 */
@Table(name = "ORDERS") // Name of table is "ORDERS" because the "ORDER" is keyword in SQL
@Entity
public class Order extends AbstractEntity {
    /**
     * The total cost of all products in the order
     */
    @Column(name = "TOTAL_COST")
    private int totalCost;

    /**
     * User who placed an order
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID")
    private User user;
;
    /**
     * Set of products in specific order
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    private List<OrderedProduct> orderedProducts = new ArrayList<>();

    /**
     * Status of order
     */
    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() {
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCosl) {
        this.totalCost = totalCosl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderedProduct> getProducts() {
        return orderedProducts;
    }

    public void setProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
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
                .append(orderedProducts, order.orderedProducts)
                .append(status, order.status)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(user)
                .append(orderedProducts)
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
