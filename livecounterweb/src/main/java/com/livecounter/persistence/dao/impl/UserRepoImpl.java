package com.livecounter.persistence.dao.impl;


import com.livecounter.persistence.dao.UserRepo;
import com.livecounter.persistence.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @return the transactional session
     */
    protected Session session() {
        return sessionFactory.getCurrentSession();
    }


    public List<User> findAll() {
        return session().createQuery("from User u").list();
    }
}
