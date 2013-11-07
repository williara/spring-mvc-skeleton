package com.xpanxion.skeleton.dto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "users.userVerification", query = "from UserEntity users where users.username=:username and users.password=:password"),
        @NamedQuery(name = "users.getAllUsers", query = "from UserEntity"),
        @NamedQuery(name = "users.getByUsername", query = "from UserEntity users where users.username=:username"),
        @NamedQuery(name = "users.updateLoginTime", query = "Update UserEntity users set lastLogin = :lastLogin  where users.username=:username") })
public class UserEntity {

    // RW: should I even worry about including id here?
    private long id;
    private String username;
    private String password;
    private DateTime lastLogin;

    public UserEntity() {
    }

    /**
     * 
     * @param username
     *            set a user's username
     * @param password
     *            set a user's password
     */
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
     * @return user's last login date/time
     */
    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getLastLogin() {
        return this.lastLogin;
    }

    /**
     * 
     * @return user's Password
     */
    @Column
    public String getPassword() {
        return this.password;
    }

    /**
     * 
     * @return user's username
     */
    @Column
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
     * @param lastLogin
     *            set user's lastLogin to
     */
    public void setLastLogin(DateTime lastLogin) {
        this.lastLogin = lastLogin;
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

    /**
     * String representation of a UserEntity
     */
    @Override
    public String toString() {
        return "username = " + this.getUsername() + " password: " + this.getPassword();
    }
}
