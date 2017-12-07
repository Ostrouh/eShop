package org.ostroukh.model.entity;

import org.ostroukh.model.entity.base.AbstractEntity;
import org.ostroukh.model.entity.enums.UserRole;

import javax.persistence.*;

/**
 * Entity that contains specific user's data
 * @author Eugene Ostroukh
 */
@Table(name = "CREDENTIAL")
@Entity
public class Credential extends AbstractEntity {

    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "PASSWORD", nullable = false, unique = true)
    private String password;

    @Column(name = "EMAIL", nullable = false, length = 64, unique = true)
    private String email;

    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "IS_IN_BLACK_LIST", nullable = false)
    private boolean isInBlackList;

    /**
     * User who has this credentials
     */
    @OneToOne(optional = false, mappedBy = "credential")
    private User user;

    /**
     * You shouldn't create credential object directly
     * because order can't exist without user. Use
     * {@link User} functionality instead
     * @param user
     */
    public Credential(User user) {
        this.user = user;
    }

    public Credential() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole isRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isInBlackList() {
        return isInBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        isInBlackList = inBlackList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
