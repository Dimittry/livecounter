package com.livecounter.parser;

import java.util.List;

public interface Parser {
    String parse(String toParse);
    String getFolderToParse();
}
