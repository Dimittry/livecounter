package com.livecounter.persistence.dao.impl;


import com.livecounter.persistence.dao.UserRepo;
import com.livecounter.persistence.model.Privilege;
import com.livecounter.persistence.model.Role;
import com.livecounter.persistence.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
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

    @Override
    public List<User> findAll() {
        return session().createQuery("from User u").list();
    }

    @Override
    public User findByEmail(final String email) {
        List<User> users =
                (List<User>)session().createQuery("from User u where email = :email").setParameter("email", email).list();
        return (users.size() > 0) ? users.get(0) : null;
    }

    @Override
    public User save(final User user) {
        session().persist(user);
        return user;
    }

}
