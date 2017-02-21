package com.livecounter.saver.service;

import java.util.List;

/**
 * Saves data to the storage.
 */
public interface SaverService {
    void save();

    int saveBatch(List<String> queries);
}
