package com.hamal.model;

import javax.persistence.*;

@Entity
@Table(name = "Plane", schema = "hamal_db")
public class Plane {
    private Integer id;
    private Airline airlineByAirlineId;
    private CurrentLocation currentLocationByCurrentLocationId;

    @Id
    @Column(name = "id")
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

    @ManyToOne
    @JoinColumn(name = "airline_id", referencedColumnName = "id", nullable = false)
    public Airline getAirlineByAirlineId() {
        return airlineByAirlineId;
    }

    public void setAirlineByAirlineId(Airline airlineByAirlineId) {
        this.airlineByAirlineId = airlineByAirlineId;
    }

    @ManyToOne
    @JoinColumn(name = "Current_location_id", referencedColumnName = "id", nullable = false)
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
