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

    public SourceRepoImpl() {

    }
    @Override
    public List<Source> findAll() {
        return em.createQuery("from Source s").getResultList();
    }

    @Override
    public Source findSourceByName(String name) {
        return (Source)em.createQuery("from Source s where s.name = :name")
                .setParameter("name", name).getSingleResult();
    }

    @Override
    public Source persist(final Source source) {
        if(source.isNew()) {
            em.persist(source);
            return source;
        } else {
            return em.merge(source);
        }
    }
}
