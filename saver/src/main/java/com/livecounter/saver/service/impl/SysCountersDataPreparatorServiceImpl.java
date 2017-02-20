package com.livecounter.saver.service.impl;

import com.livecounter.saver.domain.Counter;
import com.livecounter.saver.domain.Sources;
import com.livecounter.saver.service.DataPreparatorService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysCountersDataPreparatorServiceImpl implements DataPreparatorService {
    private static final String PATH_TO_LOAD;
    private static final int WORDS_LIMIT_PER_LINE = 5;
    private List<Counter> counters = new ArrayList<>();

    static {
        PATH_TO_LOAD = System.getProperty("user.dir") + File.separator
                + ".." + File.separator + "temp" + File.separator + "counters_parsed.cps";
    }

    @Override
    public List<Counter> get() {
        return counters;
    }

    @Override
    public void load() {
        try(BufferedReader bf = new BufferedReader(new FileReader(PATH_TO_LOAD))) {
            String line;
            Counter counterItem;
            while((line = bf.readLine()) != null) {
                counterItem = createCounter(parse(line));
                if(counterItem != null) {
                    counters.add(counterItem);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private String[] parse(String line) {
        String[] parts = line.split(",");
        return parts;
    }

    private Counter createCounter(String[] items) {
        Counter counterItem = null;
        if(items.length >= WORDS_LIMIT_PER_LINE) {
            counterItem = new Counter(0, getSourceId(items[0]), formateDate(items[1], "yyyy-mm-dd"),
                    Byte.parseByte(items[2]), Long.parseLong(items[3]), formateDate(items[4], "yyyy-mm-dd HH:mm:ss"));
        }
        return counterItem;
    }

    private int getSourceId(final String sourceName) {
        for(Sources source : Sources.values()) {
            if(source.getName().equals(sourceName)) {
                return source.getValue();
            }
        }
        return -1;
    }

    private Date formateDate(final String date, final String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        Date result;
        try {
            result = df.parse(date);
        } catch (ParseException e) {
            result = new Date();
        }
        return result;
    }
}
