package org.ostroukh.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.ostroukh.model.entity.base.AbstractEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity that contains data of a specific order
 * @author Eugene Ostroukh
 */
@Table(name = "CART")
@Entity
public class Cart extends AbstractEntity{

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    public Cart() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(user, cart.user)
                .append(cartItems, cart.cartItems)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(user)
                .append(cartItems)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "user=" + user.getCredential().getLogin() +
                '}';
    }
}
