package com.livecounter.service.impl;


import com.livecounter.persistence.dao.SourceRepo;
import com.livecounter.persistence.model.Source;
import com.livecounter.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SourceServiceImpl implements SourceService {

    @Autowired
    private SourceRepo sourceRepo;

    @Override
    public List<Source> findAll() {
        return sourceRepo.findAll();
    }

    @Override
    public Source findSourceByName(String name) {
        return sourceRepo.findSourceByName(name);
    }

    @Override
    public Source persist(final Source source) {
        return sourceRepo.persist(source);
    }

    public List<Source> getByStartEndDate(final LocalDate startDate, final LocalDate endDate) {
        return sourceRepo.getByStartEndDate(startDate, endDate);
    }
}
