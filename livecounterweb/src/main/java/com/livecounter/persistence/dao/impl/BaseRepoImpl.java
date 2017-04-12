package com.livecounter.persistence.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
abstract public class BaseRepoImpl {
    @PersistenceContext
    protected EntityManager em;

    public BaseRepoImpl() {

    }

//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public BaseRepoImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    protected Session session() {
//        return sessionFactory.getCurrentSession();
//    }
}
