package com.livecounter.parser.impl;


import com.livecounter.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SysCountersParserImpl implements Parser {
    private final static String FOLDER_TO_PARSE = "toparse";

    @Override
    public String parse(String toParse) {
        String pattern = "^\\(([^\\(]+)\\);$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(toParse);
        String found;
        while (m.find()) {
            found = (m.group(1)).replaceAll("'", "");
            return prepareData(found);
        }
        return "";
    }

    @Override
    public String getFolderToParse() {
        return FOLDER_TO_PARSE;
    }

    private String prepareData(String toSplit) {
        List<String> tmp = new ArrayList<>();
        String[] splitedData = toSplit.split(",");
        for(int i = 0; i < splitedData.length; i++) {
            String viewedWord = splitedData[i].trim();
            if((!viewedWord.contains(" ")) && viewedWord.contains(":")) {
                String[] splitedViewedWord = viewedWord.split(":");
                if(splitedViewedWord.length > 0) {
                    tmp.add(splitedViewedWord[0]);
                }
                if(splitedViewedWord.length > 1) {
                    tmp.add(splitedViewedWord[1]);
                }
                continue;
            }
            tmp.add(viewedWord);
        }
        return tmp.stream().collect(Collectors.joining(","));
    }
}
