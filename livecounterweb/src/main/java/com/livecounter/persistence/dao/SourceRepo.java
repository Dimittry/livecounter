package com.livecounter.persistence.dao;


import com.livecounter.persistence.model.Source;
import com.livecounter.persistence.model.SourceData;

import java.time.LocalDate;
import java.util.List;

public interface SourceRepo {
    List<Source> findAll();
    Source findSourceByName(String name);
    Source persist(final Source source);
    List<Source> getByStartEndDate(final LocalDate startDate, final LocalDate endDate);

}
