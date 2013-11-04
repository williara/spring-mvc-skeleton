package com.xpanxion.skeleton.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xpanxion.skeleton.dto.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> getAllUsers() {
        return this.sessionFactory.openSession().getNamedQuery("users.getAllUsers").list();
    }

    @Resource
    public void setSesionFactory(SessionFactory factory) {
        this.sessionFactory = factory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> verifyUser(String username, String password) {

        Query q = this.sessionFactory.openSession().getNamedQuery("users.userVerification");

        q.setParameter("username", username);
        q.setParameter("password", password);

        return q.list();
    }
}
