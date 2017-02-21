package com.livecounter.saver.domain;

public enum Sources {
    CHITARU(1, "chitaru"),
    IRCITY(2, "ircity"),
    ZABINFO(3, "zabinfo"),
    ZABMED(4, "zabmed");

    private int value;
    private String name;

    private Sources(final int value, final String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
