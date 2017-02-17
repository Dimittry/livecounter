package com.livecounter.saver.service;

import java.util.List;

public interface DataPreparatorService<T> {
    List<T> get();
}
