package com.livecounter.persistence.dao.impl;

import com.livecounter.persistence.dao.SourceDataRepo;
import com.livecounter.persistence.model.SourceData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.FlushModeType;
import java.util.List;

@Repository
public class SourceDataRepoImpl extends BaseRepoImpl implements SourceDataRepo {
        private static final int batchSize = 10;

    @Override
    public SourceData save(final SourceData sourceData) {
//        em.saveOrUpdate(sourceData);
        return sourceData;
    }

    @Override
    @Transactional
    public void saveAll(final List<SourceData> sourceDatas) {
        for(int i = 0; i < sourceDatas.size(); i++) {
            em.persist(sourceDatas.get(i));
            if(i % batchSize == 0 && i > 0) {
                em.flush();
                em.clear();
            }
        }
    }
}
