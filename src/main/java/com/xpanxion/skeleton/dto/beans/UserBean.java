package com.xpanxion.skeleton.dto.beans;

import org.joda.time.DateTime;

public class UserBean {

    private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    private DateTime lastLogin;

    /**
     * 
     * @return user's first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * 
     * @return a user's ID
     */
    public long getId() {
        return this.id;
    }

    /**
     * 
     * @return a user's last login
     */
    public DateTime getLastLogin() {
        return this.lastLogin;
    }

    /**
     * 
     * @return user's last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * 
     * @return a user's password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 
     * @return a user's Name
     */
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
     *            value to set a user's ID to
     */
    public void setID(long id) {
        this.id = id;
    }

    /**
     * 
     * @param lastLogin
     *            value to set user's last login to
     */
    public void setLastLogin(DateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * 
     * @param lastName
     *            user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @param password
     *            value to set a user's Password to
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @param username
     *            value to set a user's Name to
     */
    public void setUsername(String username) {
        this.username = username;
    }

}
