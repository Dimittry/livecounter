package com.livecounter.persistence.dao.impl;

import com.livecounter.persistence.dao.SourceDataRepo;
import com.livecounter.persistence.model.SourceData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-config.xml"})
public class SourceDataRepoImplTest {
    @Autowired
    private SourceDataRepo sourceDataRepo;

    @Test
    public void getByStartEndDate() throws Exception {
        List<SourceData> sourceDataList = sourceDataRepo.getByStartEndDate(startDate(2), LocalDate.now());
        assertNotNull(sourceDataList);
        sourceDataList.stream().forEach(System.out::println);
    }

    private LocalDate startDate(final int interval) {
        LocalDate today = LocalDate.now();
        LocalDate before = today.minus(interval, ChronoUnit.WEEKS);
        return before;
    }

}