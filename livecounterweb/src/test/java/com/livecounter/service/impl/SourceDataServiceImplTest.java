package com.livecounter.service.impl;

import com.livecounter.persistence.model.SourceData;
import com.livecounter.service.SourceDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-config.xml"})
public class SourceDataServiceImplTest {
    @Autowired
    private SourceDataService sourceDataService;
    @Test
    public void testSourceDataSave() {
        SourceData sourceData = new SourceData();
        sourceData.setDay(new Date());
        sourceData.setValue(777L);
        sourceData.setType(7);
        sourceData.setIdSource(7L);
        sourceData.setCreated(new Date());
        sourceDataService.save(sourceData);
        assertNotNull(sourceDataService);
    }
}