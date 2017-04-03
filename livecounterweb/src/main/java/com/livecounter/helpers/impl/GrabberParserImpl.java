package com.livecounter.helpers.impl;

import com.livecounter.exceptions.MetricParseException;
import com.livecounter.factory.LiveInternetSourceCreator;
import com.livecounter.helpers.GrabberParser;
import com.livecounter.persistence.model.Source;
import com.livecounter.persistence.model.SourceData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GrabberParserImpl implements GrabberParser {
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

    @Override
    public List<SourceData> parse(final Map<Source, List<String>> sourceListMap) {
        List<SourceData> result = new ArrayList<>();
        for(Map.Entry<Source, List<String>> item : sourceListMap.entrySet()) {
            List<SourceData> sourceDatas = new ArrayList<>();
            Source source = item.getKey();
            List<String> sourceDetails = item.getValue();
            boolean isCorrectDetails = validate(sourceDetails, source.getCheckName());
            Map<String, Long> metricValuesForSource = new HashMap<>();
            if(isCorrectDetails == true) {
                metricValuesForSource = extractValues(sourceDetails);
                sourceDatas = LiveInternetSourceCreator.createAll(metricValuesForSource, source);
                result.addAll(sourceDatas);
            } else {
            }
        }
        return result;
    }

    private boolean validate(final List<String> details, final String checkName) {
        if(details.isEmpty()) {
            throw new IllegalStateException("Empty source details list.");
        }
        if(checkName == null) {
            throw new IllegalStateException("Wrong check name.");
        }
        return (details.get(0).contains(checkName));
    }

    private Map<String, Long> extractValues(final List<String> details) {
        Map<String, Long> metricValues = new HashMap<>();
        for(String detail : details) {
            metricValues.putAll(checkForMetrics(detail));
        }
        return metricValues;
    }

    private Map<String, Long> checkForMetrics(final String detail) {
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

    private long extractMetricValue(final String metric) {
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
