package com.livecounter.persistence.model.enums;


import java.util.HashMap;
import java.util.Map;

public enum MetricNames {
    DAY_HITS("dayHits", 1),
    DAY_VISITS("dayVisits",2),
    WEEK_HITS("weekHits", 3),
    WEEK_VISITS("weekVisits", 4),
    MONTH_HITS("monthHits", 5),
    MONTH_VISITS("monthVisits", 6);

    private Map<String, Integer> nameCodeMap = new HashMap<>();

    MetricNames(final String metricName, final Integer metricCode) {
        nameCodeMap.put(metricName, metricCode);
    }

    public Map<String, Integer> getNameCodeMap() {
        return nameCodeMap;
    }

}
