package com.livecounter.saver.service;

import com.livecounter.saver.domain.Counter;

import java.util.List;

public interface DataPreparatorService {
    List<Counter> getAsCountersObj();
    List<String> getAsStrings();
    void load();
}
