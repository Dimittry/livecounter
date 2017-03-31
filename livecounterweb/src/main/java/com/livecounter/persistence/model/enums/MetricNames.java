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

    private String metricName;
    private int metricCode;

    MetricNames(final String metricName, final Integer metricCode) {
        this.metricName =  metricName;
        this.metricCode = metricCode;
    }

    public String getMetricName() {
        return metricName;
    }

    public int getMetricCode() {
        return metricCode;
    }

}
