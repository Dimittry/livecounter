package com.livecounter.persistence.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
abstract public class BaseRepoImpl {
    private SessionFactory sessionFactory;

    @Autowired
    public BaseRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session session() {
        return sessionFactory.getCurrentSession();
    }
}
