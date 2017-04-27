package com.livecounter.web.controller;

import com.livecounter.helpers.DateHelper;
import com.livecounter.helpers.ModelMapperHelper;
import com.livecounter.persistence.dao.SourceRepo;
import com.livecounter.persistence.model.Source;
import com.livecounter.service.SourceService;
import com.livecounter.web.dto.SourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tests")
public class TestController {
    @Autowired
    private SourceService sourceService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SourceDto> test() {
        List<Source> sourceList = sourceService.getByStartEndDate(
                DateHelper.decreaseDaysFromNow(14), LocalDate.now());
        List<SourceDto> sourceDtos = sourceList.stream()
                .map(source -> ModelMapperHelper.convertToDto(SourceDto.class, source)).collect(Collectors.toList());
        return sourceDtos;
    }
}
