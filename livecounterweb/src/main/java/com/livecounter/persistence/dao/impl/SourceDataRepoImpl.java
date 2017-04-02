package com.livecounter.persistence.dao.impl;

import com.livecounter.persistence.dao.SourceDataRepo;
import com.livecounter.persistence.model.SourceData;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SourceDataRepoImpl extends BaseRepoImpl implements SourceDataRepo {

    @Autowired
    public SourceDataRepoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public SourceData save(final SourceData sourceData) {
        session().saveOrUpdate(sourceData);
        return sourceData;
    }

    @Override
    public void saveAll(final List<SourceData> sourceDatas) {

    }
}
