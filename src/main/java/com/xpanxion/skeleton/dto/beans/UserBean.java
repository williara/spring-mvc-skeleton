package com.xpanxion.skeleton.dto.beans;

public class UserBean {

    private long id;
    private String username;
    private String password;

    /**
     * 
     * @return a user's ID
     */
    public long getId() {
        return this.id;
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
     * @param id
     *            value to set a user's ID to
     */
    public void setID(long id) {
        this.id = id;
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
