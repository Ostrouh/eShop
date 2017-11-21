package org.ostroukh.model.entity;

import org.ostroukh.model.entity.base.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @Column(name = "IS_ADMIN", nullable = false)
    private boolean isAdmin;

    @Column(name = "IS_IN_BLACK_LIST", nullable = false)
    private boolean isInBlackList;

    /**
     * User who has this credentials
     */
    @OneToOne(optional = false, mappedBy = "credential")
    private User user;

    public Credential(String login, String password, String email, boolean isAdmin, boolean isInBlackList, User user) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
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
