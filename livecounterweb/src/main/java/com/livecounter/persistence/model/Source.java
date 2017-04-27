package com.livecounter.persistence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NamedQueries(
        @NamedQuery(name = Source.FIND_BETWEEN_DATES,
//        query = "select s from Source as s" +
            query = "select distinct s from Source s " +
                "join fetch s.sourceDataList as sdl " +
                "where sdl.day BETWEEN :startDate and :endDate"
        )
)
@Entity
@Table(name = "sources")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Source {
    public static final String FIND_BETWEEN_DATES = "Source.findBetweenDates3";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String name;

    @Column(name = "check_name")
    private String checkName;

    @OneToMany(mappedBy = "source", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<SourceData> sourceDataList= new ArrayList<>();

    public Source() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public List<SourceData> getSourceData() {
        return sourceDataList;
    }

    public boolean isNew() {
        return (id == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return id != null ? id.equals(source.id) : source.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", checkName='" + checkName + '\'' +
                '}';
    }
}
