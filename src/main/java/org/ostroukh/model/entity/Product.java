package org.ostroukh.model.entity;

import org.ostroukh.model.entity.base.AbstractEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Entity that contains data of a specific product
 * @author Eugene Ostroukh
 */
@Table(name = "PRODUCT")
@Entity
public class Product extends AbstractEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * Category of product
     */
    @Column(name = "CATEGORY", nullable = false)
    private String category;

    /**
     * Unit price
     */
    @Column(name = "PRICE", nullable = false)
    private int price;

    /**
     * Quantity in stock
     */
    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

    /**
     * Set of orders that contains this product.
     */
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
    private Set<Order> orders;

    public Product(String name, String category, int price, int quantity, Set<Order> orders) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.orders = orders;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{"  +
                "id=" + getId() +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
