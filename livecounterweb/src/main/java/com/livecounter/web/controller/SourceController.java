package com.livecounter.web.controller;

import com.livecounter.persistence.model.Source;
import com.livecounter.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SourceController {
    @Autowired
    private SourceService sourceService;

    @RequestMapping(value = "/sources", method = RequestMethod.GET)
    public ModelAndView showAllSources() {
        List<Source> sources = sourceService.findAll();
        return new ModelAndView("sourceList", "sources", sources);
    }

    @RequestMapping(value="/sources/{sourceName}")
    public ModelAndView showSourceByName(@PathVariable("sourceName")String sourceName) {
        Source source = sourceService.findSourceByName(sourceName);
        return new ModelAndView("sourceItem", "source", source);
    }
}
