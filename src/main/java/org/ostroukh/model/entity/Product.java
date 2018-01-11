package org.ostroukh.model.entity;

import org.ostroukh.model.entity.base.AbstractEntity;
import org.ostroukh.model.entity.enums.ProductCategory;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Entity that contains data of a specific product
 * @author Eugene Ostroukh
 */
@Table(name = "PRODUCT")
@Entity
public class Product extends AbstractEntity {

    @Size(min=3, max=16, message = "Invalid length")
    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * Category of product
     */
    @Column(name = "CATEGORY", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

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
     * Set of orderedProducts that contains this product.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<OrderedProduct> orderedProducts;

    public Product(String name, ProductCategory category, int price, int quantity, Set<OrderedProduct> orderedProducts) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.orderedProducts = orderedProducts;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
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
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
