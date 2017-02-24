package com.countergrabber.domain;

public enum VisCounterTypes implements CounterTypes {
    MONTH("month", 7),
    WEEK("week", 5),
    DAY("day", 3),
    TODAY("today", 1);

    private String name;
    private int type;
    private String suffix = "_vis";

    VisCounterTypes(final String name, final int type) {
        this.name = name + suffix;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }
}
