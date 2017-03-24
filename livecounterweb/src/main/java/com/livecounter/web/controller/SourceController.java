package com.livecounter.web.controller;

import com.livecounter.persistence.model.Source;
import com.livecounter.service.SourceService;
import com.livecounter.web.dto.SourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/sources")
public class SourceController {
    @Autowired
    private SourceService sourceService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllSources() {
        List<Source> sources = sourceService.findAll();
        return new ModelAndView("sourceList", "sources", sources);
    }

    @RequestMapping(value="/{sourceName}")
    public ModelAndView showSourceByName(@PathVariable("sourceName")String sourceName) {
        Source source = sourceService.findSourceByName(sourceName);
        return new ModelAndView("sourceItem", "source", source);
    }

    @RequestMapping(value = "/add")
    public ModelAndView showAddFrom() {
        Source source = new Source();
        return new ModelAndView("sourceItem", "source", source);
    }

    @RequestMapping(value="/perform_save_item")
    public String edit(@ModelAttribute("source") Source source, BindingResult result, Model model) {
        Source sourcePersisted = sourceService.persist(source);
        model.addAttribute(sourcePersisted);
        return "redirect:/sources";
    }

    private SourceDto makeSourceDto(final Source source) {
        SourceDto sourceDto = new SourceDto();
        sourceDto.setId(source.getId());
        sourceDto.setName(source.getName());
        sourceDto.setAddress(source.getAddress());
        return sourceDto;
    }
}
