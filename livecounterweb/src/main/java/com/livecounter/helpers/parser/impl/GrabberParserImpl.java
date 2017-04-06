package com.livecounter.helpers.parser.impl;

import com.livecounter.exceptions.MetricParseException;
import com.livecounter.factory.LiveInternetSourceCreator;
import com.livecounter.helpers.parser.GrabberParser;
import com.livecounter.persistence.model.Source;
import com.livecounter.persistence.model.SourceData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class GrabberParserImpl implements GrabberParser {
    private static final String DAY_FILTER = "day";
    private static final String WEEK_FILTER = "week";

    @Override
    public List<SourceData> parse(final Map<Source, List<String>> sourceListMap,
                                  Function<List<String>, Map<String, Long>> extractor) {
        List<SourceData> result = new ArrayList<>();
        for(Map.Entry<Source, List<String>> item : sourceListMap.entrySet()) {
            List<SourceData> sourceDatas;
            Source source = item.getKey();
            List<String> sourceDetails = item.getValue();
            boolean isCorrectDetails = validate(sourceDetails, source.getCheckName());
            Map<String, Long> metricValuesForSource;
            if(isCorrectDetails == true) {
                metricValuesForSource = extractor.apply(sourceDetails);
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

}
