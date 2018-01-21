package org.ostroukh.model.entity;

import org.ostroukh.model.entity.base.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Entity that encapsulates user of the application
 * @author Eugene Ostroukh
 */
@Table(name = "USER")
@Entity
public class User extends AbstractEntity {

    @Size(min=3, max=16, message = "Invalid length")
    @Column(name = "NAME", nullable = false)
    private String name;

    @Size(min=3, max=16, message = "Invalid length")
    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    /**
     * Discount that provided to specific user
     */
    @Column(name = "DISCOUNT")
    private int discount;

    /**
     * Credentials of this user
     */
    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="CREDENTIAL_ID", unique = true, nullable = false, updatable = false)
    private Credential credential;

    /**
     * Set of orders that specific user placed
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)
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

    @Override
    public String toString() {
        return "User{"  +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
