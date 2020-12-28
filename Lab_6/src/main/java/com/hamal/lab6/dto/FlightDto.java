package com.hamal.lab6.dto;


import com.hamal.lab6.domain.Plane;
import com.hamal.lab6.domain.State;

import java.sql.Timestamp;

public class FlightDto {

    private Integer id;
    private String flightNumber;
    private String direction;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private Plane planeByPlaneId;
    private State stateByStateId;

    public FlightDto(Integer id,Plane planeByPlaneId, String flightNumber,String direction,Timestamp departureTime,Timestamp arrivalTime,State stateByStateId) {
        this.id = id;
        this.planeByPlaneId = planeByPlaneId;
        this.flightNumber = flightNumber;
        this.direction = direction;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.planeByPlaneId = planeByPlaneId;
        this.stateByStateId = stateByStateId;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public State getStateByStateId() {return stateByStateId; }
    public void setStateByStateId(State stateByStateId) {this.stateByStateId = stateByStateId;}

    public Plane getPlaneByPlaneId() {return planeByPlaneId; }
    public void setPlaneByPlaneId(Plane planeByPlaneId) {this.planeByPlaneId = planeByPlaneId;}


}
