package com.livecounter.service;

import com.livecounter.persistence.model.Source;

import java.util.List;

public interface SourceService {
    List<Source> findAll();
    Source findSourceByName(String name);

}
