package com.livecounter.persistence.dao.impl;

import com.livecounter.persistence.dao.SourceRepo;
import com.livecounter.persistence.model.Source;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SourceRepoImpl extends BaseRepoImpl implements SourceRepo {

    @Autowired
    public SourceRepoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Source> findAll() {
        return session().createQuery("from Source s").list();
    }

    @Override
    public Source findSourceByName(String name) {
        return (Source)session().createQuery("from Source s where s.name = :name")
                .setParameter("name", name).getSingleResult();
    }
}
