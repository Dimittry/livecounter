package com.livecounter.service;

import com.livecounter.persistence.model.Source;

import java.util.List;
import java.util.Map;

public interface GrabberService {
    Map<Source, List<String>> readAll();
}
