package com.livecounter.saver.domain;

public class Source {
    private long id;
    private String name;
    private byte isVisible;
    private String address;

    public Source() {}

    public Source(final long id, final String name, final byte isVisible, final String address) {
        this.id = id;
        this.name = name;
        this.isVisible = isVisible;
        this.address = address;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsVisible(byte isVisible) {
        this.isVisible = isVisible;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte getIsVisible() {
        return isVisible;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isVisible=" + isVisible +
                ", address='" + address + '\'' +
                '}';
    }
}
