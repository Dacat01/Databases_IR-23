package com.hamal.model.implementation;

import com.hamal.model.BasicModel;

import javax.persistence.*;


public class Flight implements BasicModel {
    private Integer id;
    private Integer planeId;
    private String flightNumber;
    private String direction;
    private String departureTime;
    private String arrivalTime;
    private Integer state;

    private Plane planeByPlaneId;
    private State stateByStateId;

    public Flight(final Integer id,final Integer planeId,final String flightNumber,final String direction,final String departureTime,final String arrivalTime, final Integer state) {
        this.id = id;
        this.planeId = planeId;
        this.flightNumber = flightNumber;
        this.direction = direction;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.state = state;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Basic
    @Column(name = "flight_number")
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Basic
    @Column(name = "direction")
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Basic
    @Column(name = "departure_time")
    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }


    @Basic
    @Column(name = "arrival_time")
    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (id != null ? !id.equals(flight.id) : flight.id != null) return false;
        if (flightNumber != null ? !flightNumber.equals(flight.flightNumber) : flight.flightNumber != null)
            return false;
        if (direction != null ? !direction.equals(flight.direction) : flight.direction != null) return false;
        if (departureTime != null ? !departureTime.equals(flight.departureTime) : flight.departureTime != null)
            return false;
        if (arrivalTime != null ? !arrivalTime.equals(flight.arrivalTime) : flight.arrivalTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (flightNumber != null ? flightNumber.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        return result;
    }

    public final Integer getState() {return state;}
    public final void setState(final Integer state) {this.state = state;}

    public final Integer getPlaneId() {return planeId;}
    public final void setPlaneId (final Integer planeId) {this.planeId = planeId; }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", direction='" + direction + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", planeByPlaneId=" + planeByPlaneId +
                ", stateByStateId=" + stateByStateId +
                '}';
    }

}

