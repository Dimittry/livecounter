package com.livecounter.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livecounter.helpers.DateHelper;
import com.livecounter.helpers.ModelMapperHelper;
import com.livecounter.persistence.model.Source;
import com.livecounter.service.SourceService;
import com.livecounter.web.dto.SourceDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-config.xml"})
public class SourceServiceImplTest {
    @Autowired
    private SourceService sourceService;

    @Test
    public void getByStartEndDate() throws Exception {
        List<Source> sourceList = sourceService.getByStartEndDate(DateHelper.decreaseDaysFromNow(25), LocalDate.now());
        assertNotNull(sourceList);
        System.out.println(sourceList);
        List<SourceDto> sourceDtos = sourceList.stream()
                .map(source -> ModelMapperHelper.convertToDto(SourceDto.class, source)).collect(Collectors.toList());
        assertNotNull(sourceDtos);
        String result = new ObjectMapper().writeValueAsString(sourceDtos);
        assertNotNull(result);
    }
}