package com.livecounter.saver.service.impl;

import com.livecounter.saver.service.DataPreparatorService;

import java.util.ArrayList;
import java.util.List;

public class SysCountersDataPreparatorServiceImpl<T> implements DataPreparatorService<T> {
    @Override
    public List<T> get() {
        return new ArrayList<>();
    }
}
