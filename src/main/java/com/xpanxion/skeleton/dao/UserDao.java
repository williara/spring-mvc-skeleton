package com.xpanxion.skeleton.dao;

import java.util.List;

import com.xpanxion.skeleton.dto.entity.UserEntity;

public interface UserDao {

    public List<UserEntity> getAllUsers();

    public UserEntity getUserByCredentials(UserEntity ent) throws IndexOutOfBoundsException;

    public UserEntity getUserByUserName(String username);

    public void setLastLoginFor(UserEntity ent);
}
