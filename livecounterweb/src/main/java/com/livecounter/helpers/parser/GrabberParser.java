package com.livecounter.helpers.parser;


import com.livecounter.persistence.model.Source;
import com.livecounter.persistence.model.SourceData;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface GrabberParser {
    List<SourceData> parse(final Map<Source, List<String>> sourceListMap, Function<List<String>, Map<String, Long>> extractor);
}
