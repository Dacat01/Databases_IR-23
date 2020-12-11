package com.hamal.model.implementation;

import javax.persistence.*;

import com.hamal.model.BasicModel;

public class Plane implements BasicModel {
    private Integer id;
    private Integer airlineId;
    private Integer currentLocationId;

    public Plane(final Integer id, final Integer airlineId, final Integer currentLocationId) {
        this.id = id;
        this.airlineId = airlineId;
        this.currentLocationId = currentLocationId;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "Airline")
    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    @Id
    @Column(name = "Current_location")
    public Integer getCurrentLocationId() {
        return currentLocationId;
    }

    public void setCurrentLocationId(Integer currentLocationId) {
        this.currentLocationId = currentLocationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (id != null ? !id.equals(plane.id) : plane.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }



    @Override
    public final String toString() {
        return "{"
                + "id = " + id
                + ", airline Id = " + airlineId
                + ", current location Id = " + currentLocationId
                +'}';
    }
}
