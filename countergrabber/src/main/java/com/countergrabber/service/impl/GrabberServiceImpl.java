package com.countergrabber.service.impl;

import com.countergrabber.dao.CounterDAO;
import com.countergrabber.dao.SourceDAO;
import com.countergrabber.domain.Source;
import com.countergrabber.service.GrabberService;
import com.gargoylesoftware.htmlunit.JavaScriptPage;
import com.gargoylesoftware.htmlunit.WebClient;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GrabberServiceImpl implements GrabberService {

    private SourceDAO sourceDAO;

    public GrabberServiceImpl(SourceDAO sourceDAO) {
        this.sourceDAO = sourceDAO;
    }

    @Override
    public void grab() {
        List<Source> sources = sourceDAO.findAll();
        for(Source source : sources) {
            System.out.println(source.getAddress());
            String[] parts = getPage(source.getAddress());
            System.out.println(parts.length);
            System.out.println("--------------------------");
        }
    }

    private String[] getPage(final String url) {
        String[] parts;
        final WebClient webClient = new WebClient();
        try {
            final JavaScriptPage page = webClient.getPage(url);
            final String pageAsText = page.getContent();
            parts = pageAsText.split("\\r\\n");
            Arrays.stream(parts).forEach(System.out::println);
        } catch(IOException e) {
            parts = new String[0];
        }
        return parts;
    }

    private void buildCounter(String[] parts) {
        if(parts.length == 0) {
            return;
        }


    }
}
