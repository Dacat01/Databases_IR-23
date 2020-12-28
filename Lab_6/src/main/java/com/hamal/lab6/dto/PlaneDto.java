package com.hamal.lab6.dto;


import com.hamal.lab6.domain.Airline;
import com.hamal.lab6.domain.CurrentLocation;


public class PlaneDto {

    private Integer id;
    private Airline airlineByAirlineId;
    private CurrentLocation currentLocationByCurrentLocationId;


    public PlaneDto(Integer id,Airline airlineByAirlineId1, CurrentLocation currentLocationByCurrentLocationId1) {
        this.id = id;
        this.airlineByAirlineId = airlineByAirlineId1;
        this.currentLocationByCurrentLocationId=currentLocationByCurrentLocationId1;
    }

    public PlaneDto() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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


}
