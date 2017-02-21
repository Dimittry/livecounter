package com.livecounter.saver.domain;

public enum Types {
    VIEWS(1), VISITORS(2);
    private int value;

    private Types(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
