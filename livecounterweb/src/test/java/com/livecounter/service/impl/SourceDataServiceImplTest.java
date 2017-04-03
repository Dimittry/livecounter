package com.livecounter.service.impl;

import com.livecounter.persistence.model.SourceData;
import com.livecounter.service.SourceDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-config.xml"})
public class SourceDataServiceImplTest {
    @Autowired
    private SourceDataService sourceDataService;

    @Test
    public void testSourceDataSaveFake() {
        sourceDataService.save(getSourceDataInstance());
        assertNotNull(sourceDataService);
    }

    @Test
    public void testSourceDataBatchSaveFake() {
        List<SourceData> sourceDatas = new ArrayList<>();
        sourceDatas.add(getSourceDataInstance());
        sourceDatas.add(getSourceDataInstance());
        sourceDatas.add(getSourceDataInstance());
        sourceDatas.add(getSourceDataInstance());
        sourceDataService.saveAll(sourceDatas);
        assertNotNull(sourceDataService);
    }

    private SourceData getSourceDataInstance() {
        long value = ThreadLocalRandom.current().nextLong(1,2000000);
        int type = ThreadLocalRandom.current().nextInt(1, 100);
        long idSource = ThreadLocalRandom.current().nextLong(1, 1500);

        SourceData sourceData = new SourceData();
        sourceData.setDay(new Date());
        sourceData.setValue(value);
        sourceData.setType(type);
        sourceData.setIdSource(idSource);
        sourceData.setCreated(new Date());
        return sourceData;
    }
}