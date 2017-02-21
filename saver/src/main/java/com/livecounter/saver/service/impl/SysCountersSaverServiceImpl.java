package com.livecounter.saver.service.impl;


import com.livecounter.saver.dao.SourceDAO;
import com.livecounter.saver.dao.impl.SourceDAOImpl;
import com.livecounter.saver.service.DataPreparatorService;
import com.livecounter.saver.service.SaverService;

import java.util.List;

public class SysCountersSaverServiceImpl implements SaverService {

    @Override
    public void save() {

    }

    @Override
    public int saveBatch(List<String> queries) {
        SourceDAO sourceDAO = new SourceDAOImpl();
        return sourceDAO.createSourcesBatch(queries);
    }
}
