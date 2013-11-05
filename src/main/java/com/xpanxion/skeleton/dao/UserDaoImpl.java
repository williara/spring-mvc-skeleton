package com.xpanxion.skeleton.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    @SuppressWarnings("unchecked")
    @Override
    public UserEntity getUserByCredentials(UserEntity ent) throws IndexOutOfBoundsException {

        Query q = this.sessionFactory.openSession().getNamedQuery("users.userVerification");

        q.setParameter("username", ent.getUsername());
        q.setParameter("password", ent.getPassword());

        List<UserEntity> lst = q.list();
        this.listHasOneValue(lst);
        return lst.get(0);

    }

    @SuppressWarnings("unchecked")
    @Override
    public UserEntity getUserByUserName(String username) throws IndexOutOfBoundsException {
        Query q = this.sessionFactory.openSession().getNamedQuery("users.userVerification");

        q.setParameter("username", username);
        List<UserEntity> lst = q.list();
        this.listHasOneValue(lst);

        return lst.get(0);
    }

    public void listHasOneValue(List<UserEntity> lst) {
        if (lst.size() != 1) {
            throw new IndexOutOfBoundsException("Multiple Users Exist for Credentials");
        }
    }

    @Override
    public void setLastLoginFor(UserEntity ent) {
        Session s = this.sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        tx.begin();
        s.update(ent);
        tx.commit();
        s.close();
    }

    @Resource
    public void setSesionFactory(SessionFactory factory) {
        this.sessionFactory = factory;
    }
}
