package com.countergrabber.service.impl;

import com.countergrabber.dao.CounterDAO;
import com.countergrabber.domain.Counter;
import com.countergrabber.service.CounterService;

import java.util.ArrayList;
import java.util.List;

public class CounterServiceImpl implements CounterService {

    private final CounterDAO counterDAO;

    public CounterServiceImpl(CounterDAO counterDAO) {
        this.counterDAO = counterDAO;
    }

    @Override
    public int saveCounters(final List<Counter> counters) {
        int saved = counterDAO.saveBatch(counters);
        return saved;
    }


}
