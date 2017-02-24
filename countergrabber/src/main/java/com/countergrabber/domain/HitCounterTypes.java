package com.countergrabber.domain;

public enum HitCounterTypes implements CounterTypes {
    MONTH("month", 8),
    WEEK("week", 6),
    DAY("day", 4),
    TODAY("today", 2);

    private String name;
    private int type;
    private String suffix = "_hit";

    HitCounterTypes(final String name, final int type) {
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
