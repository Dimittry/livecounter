package com.livecounter.persistence.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.livecounter.persistence.dao.SourceRepo;
import com.livecounter.persistence.model.Source;
import com.livecounter.persistence.model.SourceData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
//    @Transactional
    public void findSourceByNameTest() throws Exception {
        Source s = sourceRepo.findSourceByName("chitaru");
        assertNotNull(s);
        assertEquals(s.getId(), new Long(23));
        System.out.println(s);
//        System.out.println(s.getSourceData());
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
    @Test
    public void getByStartEndDate() throws Exception {
        List<Source> sourceList = sourceRepo.getByStartEndDate(startDate(2), LocalDate.now());
        assertNotNull(sourceList);
//        sourceList.stream().forEach(System.out::println);
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(sourceList));
        String result = new ObjectMapper().writeValueAsString(sourceList);
        System.out.println(result);
//        for(Source source : sourceList) {
//            System.out.println(source.getId());
////            System.out.println(source.getSourceData());
//            source.getSourceData().stream().forEach(System.out::println);
////            System.out.println(source.getSource());
//            System.out.println("------------------");
//        }
    }

    private LocalDate startDate(final int interval) {
        LocalDate today = LocalDate.now();
        LocalDate before = today.minus(interval, ChronoUnit.WEEKS);
        return before;
    }

}