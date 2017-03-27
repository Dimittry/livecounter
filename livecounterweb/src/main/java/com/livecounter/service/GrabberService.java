package com.livecounter.service;

import com.livecounter.persistence.model.Source;

import java.util.List;
import java.util.Map;

public interface GrabberService {
//    List<Source> readAll();
    Map<String, List<String>> readAll();
}
