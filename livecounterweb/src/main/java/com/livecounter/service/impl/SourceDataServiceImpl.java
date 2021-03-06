package com.livecounter.service.impl;


import com.livecounter.persistence.dao.SourceDataRepo;
import com.livecounter.persistence.model.SourceData;
import com.livecounter.service.SourceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceDataServiceImpl implements SourceDataService {

    @Autowired
    private SourceDataRepo sourceDataRepo;

    public SourceData save(SourceData sourceData) {
        return sourceDataRepo.save(sourceData);
    }

    public void saveAll(List<SourceData> sourceDatas) {
        sourceDataRepo.saveAll(sourceDatas);
    }
}
