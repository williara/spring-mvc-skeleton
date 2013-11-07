package com.xpanxion.skeleton.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xpanxion.skeleton.dao.UserDao;
import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.dto.entity.UserEntity;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    /**
     * @return all users
     */
    @Override
    public List<UserBean> getUserBeans() {

        List<UserEntity> users = this.userDao.getAllUsers();
        List<UserBean> output = new ArrayList<UserBean>();
        for (UserEntity user : users) {
            output.add(this.userToBean(user));
        }
        return output;

    }

    /**
     * @param User
     *            to set last logon timestamp
     */
    @Override
    public void setLastLoginTime(UserBean user) {
        UserEntity ent = new UserEntity();
        ent.setLastLogin(user.getLastLogin());
        ent.setUsername(user.getUsername());
        ent.setPassword(user.getPassword());
        this.userDao.setLastLoginFor(ent);
    }

    @Resource
    public void setUserDao(UserDao dao) {
        this.userDao = dao;
    }

    /**
     * 
     * @param ent
     *            UserEntity to convert to UserBean
     * @return UserBean returned
     */
    public UserBean userToBean(UserEntity ent) {
        UserBean bean = new UserBean();
        BeanUtils.copyProperties(ent, bean);
        bean.setUsername(ent.getUsername());
        bean.setPassword(ent.getPassword());
        bean.setID(ent.getID());
        return bean;
    }

    /**
     * @param ent
     *            user to verify
     */
    @Override
    public UserBean verifyUserCredentials(UserEntity ent) {
        try {
            return this.userToBean(this.userDao.getUserByCredentials(ent));
        } catch (IndexOutOfBoundsException e) {
            // user credentials weren't found
            return null;
        }
    }

    /**
     * @param username
     *            username to verify exists
     * @return user that was found
     */
    @Override
    public UserBean verifyUsernameExists(String username) {
        try {
            return this.userToBean(this.userDao.getUserByUserName(username));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
