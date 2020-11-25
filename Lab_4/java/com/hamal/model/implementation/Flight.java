package com.hamal.model.implementation;

import com.hamal.model.BasicModel;


public class Flight implements BasicModel {
    private Integer id;
    private Integer planeId;
    private String flightNumber;
    private String direction;
    private String departureTime;
    private String arrivalTime;
    private Integer state;

    public Flight(final Integer id,final Integer planeId,final String flightNumber,final String direction,final String departureTime,final String arrivalTime, final Integer state) {
        this.id = id;
        this.planeId = planeId;
        this.flightNumber = flightNumber;
        this.direction = direction;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.state = state;
    }

    public final Integer getId() {return id;}
    public final void setId(final Integer id) {this.id = id;}

    public final Integer getPlaneId() {return planeId;}
    public final void setPlaneId (final Integer planeId) {this.planeId = planeId; }

    public final String getFlightNumber() {
        return flightNumber;
    }
    public final void setFlightNumber(final String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public final String getDepartureTime() {
        return departureTime;
    }
    public final void setDepartureTime(final String departureTime) {this.departureTime = departureTime; }

    public final String getArrivalTime() {
        return arrivalTime;
    }
    public final void setArrivalTimeTime(final String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public final String getDirection() {
        return direction;
    }
    public final void setDirection(final String direction) {
        this.direction = direction;
    }


    public final Integer getState() {return state;}
    public final void setState(final Integer state) {this.state = state;}

    @Override
    public final String toString() {
        return "{"
                + "id = " + id
                + ", plane id  = " + planeId
                + ", flight number  = " + flightNumber
                + ", direction  = " + direction
                + ", departure time  = " + departureTime
                + ", arrival time  = " + arrivalTime
                + ", state  = " + state
                +'}';
    }
}

