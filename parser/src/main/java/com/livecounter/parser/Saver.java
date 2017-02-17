package com.livecounter.parser;

import java.util.List;

public interface Saver {
    boolean save(List<String> data);
    String getPathToSave();
}
