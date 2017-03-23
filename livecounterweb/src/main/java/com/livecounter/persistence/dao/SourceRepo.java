package com.livecounter.persistence.dao;


import com.livecounter.persistence.model.Source;

import java.util.List;

public interface SourceRepo {
    List<Source> findAll();
    Source findSourceByName(String name);
    Source persist(final Source source);
}
