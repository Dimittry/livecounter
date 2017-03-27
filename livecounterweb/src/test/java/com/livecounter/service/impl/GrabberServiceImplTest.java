package com.livecounter.service.impl;

import com.livecounter.persistence.dao.SourceRepo;
import com.livecounter.persistence.model.Source;
import com.livecounter.service.GrabberService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-config.xml"})
public class GrabberServiceImplTest {
    @Autowired
    private GrabberService grabberService;

    @Before
    public void setUp() {
    }

    @Test
    public void read() throws Exception {
        Map<String, List<String>> sourceData = grabberService.readAll();
        assertEquals(4, sourceData.size());
        for (Map.Entry<String, List<String>> item : sourceData.entrySet()) {
            assertEquals(11,item.getValue().size());
        }
    }

}