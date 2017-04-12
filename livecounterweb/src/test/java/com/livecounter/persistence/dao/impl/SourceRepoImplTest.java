package com.livecounter.persistence.dao.impl;

import com.livecounter.persistence.dao.SourceRepo;
import com.livecounter.persistence.model.Source;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.NoResultException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-config.xml"})
public class SourceRepoImplTest {
    @Autowired
    private SourceRepo sourceRepo;

    @Test
    public void findAllTest() throws Exception {
        List<Source> sources = sourceRepo.findAll();
        assertEquals(sources.size(), 6);
    }

    @Test
    public void findSourceByNameTest() throws Exception {
        Source s = sourceRepo.findSourceByName("chitaru");
        assertNotNull(s);
        assertEquals(s.getId(), new Long(23));
    }

    @Test(expected = NoResultException.class)
    public void notFindSourceByNameTest() throws Exception {
        Source s = sourceRepo.findSourceByName("chitaru1");
        assertNotNull(s);
        assertEquals(s.getId(), new Long(23));
    }

    @Test
    public void persistAddTest() throws Exception {
        Source s = new Source();
        s.setAddress("testAddress");
        s.setName("testName");
        s.setCheckName("testCheckname");
        sourceRepo.persist(s);
        assertNotNull(s.getId());
    }

    @Test
    public void persistEditTest() throws Exception {
        Source s = sourceRepo.findSourceByName("test3");
        long id = s.getId();
        s.setAddress("test3Address");
        sourceRepo.persist(s);
        assertEquals(s.getId(), new Long(id));
    }

}