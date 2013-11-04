package com.xpanxion.skeleton.dto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "users.userVerification", query = "from UserEntity users where users.username=:username and users.password=:password"),
        @NamedQuery(name = "users.getAllUsers", query = "from UserEntity") })
public class UserEntity {

    // RW: should I even worry about including id here?
    private long id;
    private String username;
    private String password;

    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    /**
     * 
     * @return user's ID
     */
    @Id
    @GeneratedValue
    public long getID() {
        return this.id;
    }

    /**
     * 
     * @return user's Password
     */
    @Column
    public String getPassword() {
        return this.password;
    }

    @Column
    /**
     * 
     * @return user's username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 
     * @param id
     *            set user's id to
     */
    public void setID(long id) {
        this.id = id;
    }

    /**
     * 
     * @param password
     *            set user's Password to
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @param username
     *            set user's username to
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
