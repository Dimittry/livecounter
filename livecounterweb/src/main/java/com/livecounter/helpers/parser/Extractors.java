package com.livecounter.helpers.parser;


import com.livecounter.exceptions.MetricParseException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Extractors {
    private static Map<String, String> metricsName = new HashMap<>();
    private static final int PARTS_IN_METRIC = 2;


    static {
        metricsName.put("monthHits", "month_hit");
        metricsName.put("monthVisits", "month_vis");
        metricsName.put("weekHits", "week_hit");
        metricsName.put("weekVisits", "week_vis");
        metricsName.put("dayHits", "day_hit");
        metricsName.put("dayVisits", "day_vis");
    }

    public static Map<String, Long> extractValues(final List<String> details) {
        Map<String, Long> metricValues = new HashMap<>();
        for(String detail : details) {
            metricValues.putAll(checkForMetrics(detail));
        }
        return metricValues;
    }

    public static Map<String, Long> extractCertainMetricValues(final List<String> details, final String filter) {
        Map<String, Long> metricValues = new HashMap<>();
        for(String detail : details) {
            Map<String, Long> checkedMetrics = checkForMetrics(detail);
            Map<String, Long> filteredMetrics = filter(checkedMetrics, filter);
            metricValues.putAll(filteredMetrics);
        }
        System.out.println("metricValues");
        System.out.println(metricValues);
        return metricValues;
    }

    private static Map<String, Long> checkForMetrics(final String detail) {
        Map<String, Long> result = new HashMap<>();
        for(Map.Entry<String, String> metric : metricsName.entrySet()) {
            long metricValue;
            if(detail.contains(metric.getValue())) {
                metricValue = extractMetricValue(detail);
                result.put(metric.getKey(), metricValue);
            }
        }
        return result;
    }

    private static Map<String, Long> filter(final Map<String, Long> metrics, final String filter) {
        Map<String, Long> result = new HashMap<>();
        if(filter != null) {
            result = metrics.entrySet().stream().filter(map -> map.getKey().contains(filter))
                    .collect(Collectors.toMap(p ->p.getKey(), p -> p.getValue()));
        }
        return result;
    }

    private static long extractMetricValue(final String metric) {
        String[] parts = metric.split("=");
        if(parts.length != PARTS_IN_METRIC) {
            throw new MetricParseException("Wrong metric: " + metric);
        }
        long metricValue;
        try {
            metricValue = Integer.valueOf(parts[1].replace(";", "").trim());
        } catch(NumberFormatException e) {
            throw new MetricParseException("Wrong metric: " + metric);
        }
        return metricValue;
    }
}
