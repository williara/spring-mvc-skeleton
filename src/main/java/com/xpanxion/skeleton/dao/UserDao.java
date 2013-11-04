package com.xpanxion.skeleton.dao;

import java.util.List;

import com.xpanxion.skeleton.dto.entity.UserEntity;

public interface UserDao {

    public List<UserEntity> getAllUsers();

    public List<UserEntity> verifyUser(String username, String password);
}
