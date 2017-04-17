package com.livecounter.service.impl;

import com.livecounter.persistence.dao.SourceRepo;
import com.livecounter.persistence.model.Source;
import com.livecounter.service.GrabberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GrabberServiceImpl implements GrabberService{
    @Autowired
    private SourceRepo sourceRepo;

    public Map<Source, List<String>> readAll() {
        Map<Source, List<String>> result = new HashMap<>();
        List<Source> sources = sourceRepo.findAll();
        for (Source source : sources) {
            List<String> sourceData = new ArrayList<>();
            try {
                URL link = new URL(source.getAddress());
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(link.openStream())
                );
                String inputLine;
                while((inputLine = in.readLine()) != null) {
                    sourceData.add(inputLine);
                }
                result.put(source, sourceData);
                in.close();
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

}
