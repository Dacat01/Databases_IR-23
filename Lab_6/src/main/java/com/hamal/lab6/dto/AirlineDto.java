package com.hamal.lab6.dto;


public class AirlineDto {

    private Integer id;
    private String name;

    public AirlineDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public AirlineDto(String name) {
        this.name = name;
    }

    public AirlineDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
