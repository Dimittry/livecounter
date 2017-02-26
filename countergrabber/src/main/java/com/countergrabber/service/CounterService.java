package com.countergrabber.service;

import com.countergrabber.domain.Counter;

import java.util.List;

public interface CounterService {
    int saveCounters(final List<Counter> counters);
}
