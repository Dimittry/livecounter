package com.livecounter.web.dto;

import java.time.LocalDate;

/**
 * Created by Dimon on 27.04.2017.
 */
public class SourceDataDto {
    private LocalDate day;

    private Integer type;

    private Long value;

    private LocalDate created;

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SourceDataDto that = (SourceDataDto) o;

        if (!day.equals(that.day)) return false;
        if (!type.equals(that.type)) return false;
        if (!value.equals(that.value)) return false;
        return created.equals(that.created);

    }

    @Override
    public int hashCode() {
        int result = day.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + created.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SourceDataDto{" +
                "day=" + day +
                ", type=" + type +
                ", value=" + value +
                ", created=" + created +
                '}';
    }
}
