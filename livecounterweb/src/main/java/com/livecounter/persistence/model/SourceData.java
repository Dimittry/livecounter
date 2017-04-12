package com.livecounter.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "source_data")
public class SourceData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "id_source")
    @ManyToOne
    @JoinColumn(name = "id_source")
    private Source source;

    private Date day;

    private Integer type;

    private Long value;

    private Date created;

    public SourceData() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Source getIdSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "SourceData{" +
                "id=" + id +
                ", Source=" + source +
                ", day=" + day +
                ", type=" + type +
                ", value=" + value +
                ", created=" + created +
                '}';
    }
}
