package com.livecounter.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.livecounter.helpers.DateHelper;
import com.livecounter.helpers.ModelMapperHelper;
import com.livecounter.persistence.model.Source;
import com.livecounter.service.SourceService;
import com.livecounter.web.dto.SourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/")
public class MainController {
    private static final String indexTemplate = "index";

    @Autowired
    private SourceService sourceService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        System.out.println("FROM INDEX");
        ModelAndView modelAndView = new ModelAndView(indexTemplate);
        String result = "";
        try {
            List<Source> sourceList = sourceService.getByStartEndDate(
                    DateHelper.decreaseDaysFromNow(30), LocalDate.now());
            List<SourceDto> sourceDtos = sourceList.stream()
                    .map(source -> ModelMapperHelper.convertToDto(SourceDto.class, source)).collect(Collectors.toList());
            result = new ObjectMapper().writeValueAsString(sourceDtos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("sources", result);
        return modelAndView;
    }
}
