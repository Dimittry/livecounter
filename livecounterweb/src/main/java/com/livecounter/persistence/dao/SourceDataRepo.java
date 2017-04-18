package com.livecounter.persistence.dao;


import com.livecounter.persistence.model.SourceData;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface SourceDataRepo {
    SourceData save(final SourceData sourceData);
    void saveAll(final List<SourceData> sourceDatas);
    List<SourceData> getByStartEndDate(final LocalDate startDate, final LocalDate endDate);
}
