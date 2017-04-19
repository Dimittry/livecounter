package com.livecounter.service;

import com.livecounter.persistence.model.Source;

import java.time.LocalDate;
import java.util.List;

public interface SourceService {
    List<Source> findAll();
    Source findSourceByName(String name);
    Source persist(final Source source);
    List<Source> getByStartEndDate(final LocalDate startDate, final LocalDate endDate);
}
