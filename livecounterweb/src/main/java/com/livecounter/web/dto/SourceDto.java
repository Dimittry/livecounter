package com.livecounter.web.dto;


import com.livecounter.persistence.model.SourceData;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class SourceDto {

    private Long id;

    @NotNull
    private String address;

    @NotNull
    private String name;

    @NotNull
    private String checkName;

    private List<SourceDataDto> sourceDataList = new ArrayList<>();

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

    public void setSourceData(final List<SourceDataDto> sourceDataList) {
        this.sourceDataList = sourceDataList;
    }

    public List<SourceDataDto> getSourceData() {
        return sourceDataList;
    }

    @Override
    public String toString() {
        return "SourceDto{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", checkName='" + checkName + '\'' +
                ", sourceDataList=" + sourceDataList +
                '}';
    }
}
