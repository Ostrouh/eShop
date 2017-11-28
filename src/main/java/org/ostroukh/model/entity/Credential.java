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

    @Column(name = "LOGIN", nullable = false, length = 64)
    private String login;

    @Column(name = "PASSWORD", nullable = false, length = 64)
    private String password;

    @Column(name = "EMAIL", nullable = false, length = 64)
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

    public Credential(String login, String password, String email, UserRole role, boolean isInBlackList, User user) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.isInBlackList = isInBlackList;
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
