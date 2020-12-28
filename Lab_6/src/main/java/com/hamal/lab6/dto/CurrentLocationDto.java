package com.hamal.lab6.dto;


public class CurrentLocationDto {

    private Integer id;
    private String country;
    private String city;
    private String airport;

    public CurrentLocationDto(Integer id, String country,String city,String airport) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.airport = airport;
    }


    public CurrentLocationDto() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getAirport() {
        return airport;
    }
    public void setAirport(String airport) {
        this.airport = airport;
    }


}
