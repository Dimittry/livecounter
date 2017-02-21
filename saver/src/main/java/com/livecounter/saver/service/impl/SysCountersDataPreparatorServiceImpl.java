package com.livecounter.saver.service.impl;

import com.livecounter.saver.dao.SourceDAO;
import com.livecounter.saver.domain.Counter;
import com.livecounter.saver.domain.Source;
import com.livecounter.saver.domain.Sources;
import com.livecounter.saver.service.DataPreparatorService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

public class SysCountersDataPreparatorServiceImpl implements DataPreparatorService {

    private static final String SOURCE_DATA_TABLE = "source_data";

    private static final String PATH_TO_LOAD;

    private static final int WORDS_LIMIT_PER_LINE = 5;

    private static final Map<String, Long> sourceMap = new HashMap<>();

    private List<Counter> counters = new ArrayList<>();

    private SourceDAO sourceDAO;

    static {
        PATH_TO_LOAD = System.getProperty("user.dir") + File.separator
                + ".." + File.separator + "temp" + File.separator + "counters_parsed.cps";
    }

    public SysCountersDataPreparatorServiceImpl(SourceDAO sourceDAO) {
        this.sourceDAO = sourceDAO;
        initSourceMap();
    }

    @Override
    public List<Counter> getAsCountersObj() {
        return counters;
    }

    @Override
    public List<String> getAsStrings() {
        List<String> queries = new ArrayList<>();
        for(Counter counter : counters) {
            queries.add("INSERT INTO " + SOURCE_DATA_TABLE + " (id_source, day, type, value, created) " +
                    " VALUES (" + counter.getIdSource() + ", " +
                    "'" + formateDateToString(counter.getDay(), "yyyy-MM-dd") + "', " +
                    "'" + counter.getType() + "', " + counter.getValue() + ", " +
                    "'" + formateDateToString(counter.getCreated(), "yyyy-MM-dd HH:mm:ss") + "')");
        }
        return queries;
    }


    /**
     * Loads data from file and adds it to List<Counter> counters
     */
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

    /**
     *  Parses line from a file
     * @param line a line from file to parse
     * @return the array of strings contained in line from file
     */
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

    private long getSourceId(final String sourceName) {
        return sourceMap.get(sourceName);
    }

    private void initSourceMap() {
        List<Source> sources = sourceDAO.findAll();
        for(Source source : sources) {
            sourceMap.put(source.getName(), source.getId());
        }
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

    private String formateDateToString(final Date date, final String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}
