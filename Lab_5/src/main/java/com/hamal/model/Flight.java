package com.hamal.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Flight {
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "flight_number")
    private String flightNumber;
    @Basic
    @Column(name = "direction")
    private String direction;
    @Basic
    @Column(name = "departure_time")
    private Timestamp departureTime;
    @Basic
    @Column(name = "arrival_time")
    private Timestamp arrivalTime;

    @ManyToOne
    @JoinColumn(name = "Plane_id", referencedColumnName = "id", nullable = false)
    private Plane planeByPlaneId;

    @ManyToOne
    @JoinColumn(name = "State_id", referencedColumnName = "id", nullable = false)
    private State stateByStateId;

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

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", Plane_id=" + planeByPlaneId.getId() +
                ", flightNumber='" + flightNumber + '\'' +
                ", direction='" + direction + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", State_id=" + stateByStateId.getId() +
                '}';
    }
}
