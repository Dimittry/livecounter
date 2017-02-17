package com.livecounter.parser;

import com.livecounter.parser.impl.SysCountersParserImpl;
import com.livecounter.parser.impl.SysCountersSaverImpl;

public class ParserApp {
    public static void main(String[] args) {
        ParserDataHolder parserDataHolder = new ParserDataHolder(
                new SysCountersParserImpl(), new SysCountersSaverImpl());
        parserDataHolder.run();
    }
}
