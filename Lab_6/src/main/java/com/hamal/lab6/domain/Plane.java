package com.hamal.lab6.domain;

import javax.persistence.*;

@Entity
@Table(name = "Plane", schema = "hamal_db")
public class Plane {
    @Id
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "airline_id", referencedColumnName = "id", nullable = false)
    private Airline airlineByAirlineId;
    @ManyToOne
    @JoinColumn(name = "Current_location_id", referencedColumnName = "id", nullable = false)
    private CurrentLocation currentLocationByCurrentLocationId;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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


    public Airline getAirlineByAirlineId() {
        return airlineByAirlineId;
    }
    public void setAirlineByAirlineId(Airline airlineByAirlineId) {
        this.airlineByAirlineId = airlineByAirlineId;
    }


    public CurrentLocation getCurrentLocationByCurrentLocationId() {
        return currentLocationByCurrentLocationId;
    }
    public void setCurrentLocationByCurrentLocationId(CurrentLocation currentLocationByCurrentLocationId) {
        this.currentLocationByCurrentLocationId = currentLocationByCurrentLocationId;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", AirlineId=" + airlineByAirlineId.getId() +
                ", currentLocationId=" + currentLocationByCurrentLocationId.getId() +
                '}';
    }
}
