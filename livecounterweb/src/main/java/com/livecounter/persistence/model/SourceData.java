package com.livecounter.persistence.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@NamedQueries({
    @NamedQuery(
            name = SourceData.FIND_BETWEEN_DATES,
            query = "from SourceData sd where sd.day BETWEEN :startDate and :endDate"
    )
})
@Entity
@Table(name = "source_data")
public class SourceData {
    public static final String FIND_BETWEEN_DATES = "SourceData.findBetweenDates";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "id_source")
    @ManyToOne
    @JoinColumn(name = "id_source")
    private Source source;

    private LocalDate day;

    private Integer type;

    private Long value;

    private LocalDate created;

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
