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

    @Override
    public List<UserBean> getUserBeans(UserEntity ent) {

        List<UserEntity> users = this.userDao.verifyUser(ent.getUsername(), ent.getPassword());
        List<UserBean> output = new ArrayList<UserBean>();
        for (UserEntity user : users) {
            UserBean bean = new UserBean();
            BeanUtils.copyProperties(user, bean);
            bean.setUsername(user.getUsername());
            bean.setPassword(user.getPassword());
            output.add(bean);
        }
        return output;

    }

    @Resource
    public void setUserDao(UserDao dao) {
        this.userDao = dao;
    }

}
