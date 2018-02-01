package org.ostroukh.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.ostroukh.model.entity.base.AbstractEntity;

import javax.persistence.*;

@Table(name = "CART_ITEM")
@Entity
public class CartItem extends AbstractEntity{
    /**
     * Product added by the customer in the specified order
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)//CascadeType:ALL
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    /**
     * Order that contains specified product
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)//CascadeType:ALL
    @JoinColumn(name = "CART_ID", nullable = false, referencedColumnName = "id")
    private Cart cart;

    /**
     * The number of products that were added in the order
     */
    @Column(name = "QUANTITY")
    private int quantity;

    public CartItem() {
    }

    public CartItem(Product product, Cart cart, int quantity) {
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

        CartItem cartItem = (CartItem) o;

        return new EqualsBuilder()
                .append(product, cartItem.product)
                .append(cart, cartItem.cart)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(product)
                .append(cart)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productID=" + product.getId() +
                ", cartID=" + cart.getId() +
                ", quantity=" + quantity +
                '}';
    }
}
