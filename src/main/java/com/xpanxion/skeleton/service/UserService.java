package com.xpanxion.skeleton.service;

import java.util.List;

import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.dto.entity.UserEntity;

public interface UserService {

    List<UserBean> getUserBeans();

    UserBean returnUserFromUserName(String username);

    void setLastLoginFor(UserBean user);

    UserBean verifyUserCredentials(UserEntity ent);
}
