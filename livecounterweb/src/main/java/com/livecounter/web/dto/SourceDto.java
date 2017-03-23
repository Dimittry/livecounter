package com.livecounter.web.dto;


import javax.validation.constraints.NotNull;

public class SourceDto {

    private Long id;

    @NotNull
    private String address;

    @NotNull
    private String name;

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

    @Override
    public String toString() {
        return "SourceDto{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
