package com.livecounter.service;


import com.livecounter.persistence.model.SourceData;

import java.util.List;

public interface SourceDataService {
    SourceData save(SourceData sourceData);
    void saveAll(List<SourceData> sourceDatas);
}
