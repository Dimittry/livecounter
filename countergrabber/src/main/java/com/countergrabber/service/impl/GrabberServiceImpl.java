package com.countergrabber.service.impl;

import com.countergrabber.dao.SourceDAO;
import com.countergrabber.domain.*;
import com.countergrabber.service.GrabberService;
import com.gargoylesoftware.htmlunit.JavaScriptPage;
import com.gargoylesoftware.htmlunit.WebClient;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GrabberServiceImpl implements GrabberService {

    private static final int PARTS_IN_LINE = 2;
    private SourceDAO sourceDAO;
    private List<Counter> counters = new ArrayList<>();

    public GrabberServiceImpl(SourceDAO sourceDAO) {
        this.sourceDAO = sourceDAO;
    }

    @Override
    public void grab() {
        List<Source> sources = sourceDAO.findAll();
        for(Source source : sources) {
            System.out.println(source.getAddress());
            String[] parts = getPage(source.getAddress());
            buildCounter(parts, source.getId());
        }
    }

    @Override
    public List<Counter> getCounters() {
        return counters;
    }

    private String[] getPage(final String url) {
        String[] parts;
        final WebClient webClient = new WebClient();
        try {
            final JavaScriptPage page = webClient.getPage(url);
            final String pageAsText = page.getContent();
            parts = pageAsText.split("\\r\\n");
        } catch(IOException e) {
            parts = new String[0];
        }
        return parts;
    }

    private void buildCounter(final String[] parts, final long idSource) {
        if(parts.length == 0) {
            return;
        }
        if(!parts[0].contains("site")) {
            return;
        }
        Map<String, Integer> valueTypeMap = new HashMap<>();
        for(int i = 1; i < parts.length; i++) {
            valueTypeMap = recognizePart(parts[i]);
            if(valueTypeMap.size() > 0) {
                Date now = new Date();
                counters.add(new Counter(
                        0,
                        idSource,
                        now,
                        valueTypeMap.get("counterType"),
                        valueTypeMap.get("counterValue"),
                        now
                ));
            }
        }
    }

    private Map<String, Integer> recognizePart(final String line) {
        Map<String, Integer> result = new HashMap<>();

        if(line == null) return result;

        Map<String, String> parts;
        try {
            parts = splitLine(line);
        } catch(IllegalStateException | NumberFormatException ignore) {
            return result;
        }

        int counterValue = getCounterValue(parts);
        int counterType = getCounterType(parts);

        if(counterType == 0) {
            return result;
        }

        result.put("counterValue", counterValue);
        result.put("counterType", counterType);
        return result;
    }

    private Map<String, String> splitLine(final String line) {
        String[] parts = line.split("=");
        if(parts.length < PARTS_IN_LINE) {
            throw new IllegalStateException("Not enough parameters.");
        }
        Map<String, String> partMap = new HashMap<>();
        partMap.put("counterName", parts[0]);
        partMap.put("counterValue", parts[1]);
        return partMap;
    }

    private int getCounterValue(final Map<String, String> parts) {
        String value = parts.get("counterValue").trim().replace(";", "");
        return Integer.parseInt(value);
    }

    private int getCounterType(final Map<String, String> parts) {
        String counterName = parts.get("counterName");

        CounterTypes[] hitTypes = HitCounterTypes.values();
        CounterTypes[] visTypes = VisCounterTypes.values();

        int typesCount = hitTypes.length + visTypes.length;
        CounterTypes[] counterTypes = new CounterTypes[typesCount];

        System.arraycopy(hitTypes, 0, counterTypes, 0, hitTypes.length);
        System.arraycopy(visTypes, 0, counterTypes, hitTypes.length, visTypes.length);

        int counterType = 0;
        for (CounterTypes type : counterTypes) {
            if(counterName.contains(type.getName())) {
                counterType = type.getType();
                break;
            }
        }
        return counterType;
    }


}
