package com.livecounter.helpers.parser.species;


import com.livecounter.helpers.parser.Extractors;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CommonParser implements Function<List<String>, Map<String, Long>> {

    @Override
    public Map<String, Long> apply(final List<String> sourceDetails) {
        System.out.println(getFilter());
        return Extractors.extractCertainMetricValues(sourceDetails, getFilter());
    }

    protected String getFilter() {
        return "all";
    }
}
