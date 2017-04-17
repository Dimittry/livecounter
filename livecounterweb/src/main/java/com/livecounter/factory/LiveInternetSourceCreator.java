package com.livecounter.factory;

import com.livecounter.exceptions.MetricParseException;
import com.livecounter.persistence.model.Source;
import com.livecounter.persistence.model.SourceData;
import com.livecounter.persistence.model.enums.MetricNames;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class LiveInternetSourceCreator {
    /**
     * Create list of SourceData objects.
     * @param metricValues  map of metric's name and value
     * @param source        instance of Source
     * @return
     */
    public static List<SourceData> createAll(final Map<String, Long> metricValues,
                                    final Source source) {
        List<SourceData> result = new ArrayList<>();
        for(Map.Entry<String, Long> item : metricValues.entrySet()) {
            SourceData sd = new SourceData();
            int metricCode =  defineMetricCode(item.getKey());
//            sd.setIdSource(source.getId());
            sd.setSource(source);
            sd.setType(metricCode);
            sd.setValue(item.getValue());
            sd.setDay(new Date());
            result.add(sd);
        }
        return result;
    }

    private static int defineMetricCode(final String metricName) {
        for(MetricNames metric : MetricNames.values()) {
            if(metric.getMetricName().equals(metricName)) {
                return metric.getMetricCode();
            }
        }
        throw new MetricParseException("Can't define metric code");
    }
}
