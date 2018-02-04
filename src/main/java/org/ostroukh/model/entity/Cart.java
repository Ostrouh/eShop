package org.ostroukh.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.ostroukh.model.entity.base.AbstractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity that contains data of a specific order
 * @author Eugene Ostroukh
 */
@Table(name = "CART")
@Entity
public class Cart extends AbstractEntity{

    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID", unique = true, nullable = false, updatable = false)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true,
            targetEntity = CartItem.class, mappedBy = "cart")
    private List<CartItem> cartItems = new ArrayList<>();

    /**
     * The total cost of all products in the cart
     */
    @Column(name = "TOTAL_COST")
    private int totalCost;

    @Column(name = "ITEMS_AMOUNT")
    private int itemsAmount;


    public Cart() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getItemsAmount() {
        return itemsAmount;
    }

    public void setItemsAmount(int itemsInCart) {
        this.itemsAmount = itemsInCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(user, cart.user)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(user)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "user=" + user.getCredential().getLogin() +
                '}';
    }
}
