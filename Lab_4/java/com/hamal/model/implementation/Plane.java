package com.hamal.model.implementation;

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

    public final Integer getId() {return id;}
    public final void setId(final Integer id) {this.id = id;}

    public final Integer getAirlineId() {return airlineId;}
    public final void setAirlineId(final Integer airlineId) {this.airlineId = airlineId;}

    public final Integer getCurrentLocationId() {return currentLocationId;}
    public final void setCurrentLocationId(final Integer currentLocationId) {this.currentLocationId = currentLocationId;}

    @Override
    public final String toString() {
        return "{"
                + "id = " + id
                + ", airline Id = " + airlineId
                + ", current location Id = " + currentLocationId
                +'}';
    }
}
