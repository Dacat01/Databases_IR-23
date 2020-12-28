package com.hamal.lab6.dto;


public class StateDto {

    private Integer id;
    private String state;

    public StateDto(Integer id, String state) {
        this.id = id;
        this.state = state;
    }

    public StateDto(String state) {
        this.state = state;
    }

    public StateDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
