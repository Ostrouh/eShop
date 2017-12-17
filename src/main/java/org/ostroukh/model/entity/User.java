package org.ostroukh.model.entity;

import org.ostroukh.model.entity.base.AbstractEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entity that encapsulates user of the application
 * @author Eugene Ostroukh
 */
@Table(name = "USER")
@Entity
public class User extends AbstractEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    /**
     * Discount that provided to specific user
     */
    @Column(name = "DISCOUNT", nullable = false)
    private int discount;

    /**
     * Credentials of this user
     */
    @OneToOne(optional = false)
    @JoinColumn(name="CREDENTIAL_ID", unique = true, nullable = false, updatable = false)
    private Credential credential;

    /**
     * Set of orders that specific user placed
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
    private Set<Order> orders;

    public User(String name, String surname, String address, String phoneNumber, int discount) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.discount = discount;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    /**
     * Adds specified order to the user order list
     * @param
     */
    public Order addOrder(){
        if(orders == null) {
            orders = new HashSet<>();
        }
        Order order = new Order(this);
        orders.add(order);

        return order;
    }

    /**
     * Removes specified order from city order list
     * @param order
     */
    public void removeOrder(Order order) {
        Objects.requireNonNull(order, "order parameter is not initialized");
        if(orders == null) {
            return;
        }
        orders.remove(order);
    }

    /**
     * Adds specified credential to the user
     * @param
     */
    public Credential addCredential(){
        Credential credential = new Credential(this);
        this.setCredential(credential);
        return credential;
    }

    @Override
    public String toString() {
        return "User{"  +
                "id=" + getId()+
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
