package com.livecounter.helpers.impl;

import com.livecounter.helpers.GrabberParser;
import com.livecounter.persistence.model.Source;
import com.livecounter.persistence.model.SourceData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public SourceData parse(final Map<Source, List<String>> sourceListMap) {
        List<SourceData> result = new ArrayList<>();
        for(Map.Entry<Source, List<String>> item : sourceListMap.entrySet()) {
            Source source = item.getKey();
            List<String> sourceDetails = item.getValue();
            System.out.println(sourceDetails);
            boolean isCorrectDetails = validate(sourceDetails, source.getCheckName());
            if(isCorrectDetails == true) {

            }
            System.out.println(item.getKey());
        }
        return new SourceData();
    }

    private boolean validate(final List<String> details, final String checkName) {
        if(details.isEmpty()) {
            throw new IllegalStateException("Empty source details list.");
        }
        if(checkName == null) {
            throw new IllegalStateException("Wrong check name.");
        }
        return (checkName.contains(details.get(0)));
    }

    private void extractValues(final List<String> details) {
        for(String detail : details) {

        }
    }

    private void checkForMetrics(final String detail) {
        for(Map.Entry<String, String> metric : metricsName.entrySet()) {
            if(detail.contains(metric.getValue())) {

            }
        }
    }

    private int extractMetricValue(final String metric) {
        String[] parts = metric.split("=");
        if(parts.length != PARTS_IN_METRIC) {
            throw new IllegalStateException("Wrong metric: " + metric);
        }
        //TODO get number
        return 0;
    }
}
