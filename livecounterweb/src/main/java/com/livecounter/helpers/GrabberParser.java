package com.livecounter.helpers;


import com.livecounter.persistence.model.Source;
import com.livecounter.persistence.model.SourceData;

import java.util.List;
import java.util.Map;

public interface GrabberParser {
    SourceData parse(final Map<Source, List<String>> sourceListMap);
}