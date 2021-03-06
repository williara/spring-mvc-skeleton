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
    private String firstName;
    private String lastName;

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
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param Password
     * @param lastLogin
     */
    public UserEntity(String username, String password, String firstName, String lastName, DateTime lastLogin) {
        this.setUsername(username);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setLastLogin(lastLogin);
    }

    /**
     * 
     * @return user's first name
     */
    @Column
    public String getFirstName() {
        return this.firstName;
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
     * @return user's last name
     */
    @Column
    public String getLastName() {
        return this.lastName;
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
     * @param firstName
     *            user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
     * @param lastName
     *            user's last name
     **/
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
