package com.hamal.model.implementation;

import com.hamal.model.BasicModel;

public class CurrentLocation implements  BasicModel{

    private Integer id;
    private String country;
    private String city;
    private String airport;


    public CurrentLocation(final Integer id, final String country, final String city, final String airport) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.airport = airport;
    }

    public final Integer getId() {
        return id;
    }
    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getCountry() {return country;}
    public final void setCountry(final String country) {
        this.country = country;
    }

    public final String getCity() {return city;}
    public final void setCity(final String city) {
        this.city = city;
    }

    public final String getAirport() {return airport;}
    public final void setAirport(final String airport) {
        this.airport = airport;
    }

    @Override
    public final String toString() {
        return "{"
                + "id = " + id
                + ", country = " + country
                + ", city = " + city
                + ", airport = " + airport
                +'}';
    }

}
