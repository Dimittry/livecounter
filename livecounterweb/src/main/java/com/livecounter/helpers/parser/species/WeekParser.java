package com.livecounter.helpers.parser.species;

import com.livecounter.helpers.parser.Extractors;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class WeekParser extends CommonParser {
    protected String getFilter() {
        return "week";
    }
}
