package com.countergrabber.domain;

import java.util.Date;

public class Counter {
    private long id;
    private long idSource;
    private Date day;
    private int type;
    private long value;
    private Date created;

    public Counter() {}

    public Counter(long id, long idSource, Date day, int type, long value, Date created) {
        this.id = id;
        this.idSource = idSource;
        this.day = day;
        this.type = type;
        this.value = value;
        this.created = created;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIdSource(long idSource) {
        this.idSource = idSource;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public long getIdSource() {
        return idSource;
    }

    public Date getDay() {
        return day;
    }

    public int getType() {
        return type;
    }

    public long getValue() {
        return value;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id=" + id +
                ", idSource=" + idSource +
                ", day=" + day +
                ", type=" + type +
                ", value=" + value +
                ", created=" + created +
                '}';
    }
}
