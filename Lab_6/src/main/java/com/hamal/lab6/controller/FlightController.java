
package com.hamal.lab6.controller;

import com.hamal.lab6.domain.Flight;
import com.hamal.lab6.dto.FlightDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hamal.lab6.service.FlightService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Flight")
@RestController
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FlightDto>> getAll() {
        List<Flight> flights  = flightService.getAll();
        List<FlightDto> flightDtos = new ArrayList<>();
        for (Flight flight : flights) {
            FlightDto flightDto = new FlightDto(
                    flight.getId(),
                    flight.getPlaneByPlaneId(),
                    flight.getFlightNumber(),
                    flight.getDirection(),
                    flight.getDepartureTime(),
                    flight.getArrivalTime(),
                    flight.getStateByStateId()

            );
            flightDtos.add(flightDto);
        }
        return new ResponseEntity<>(flightDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<FlightDto> getById(@PathVariable Integer id) {
        Flight flight = flightService.getById(id);
        if (flight != null) {
            FlightDto flightDto = new FlightDto(
                    flight.getId(),
                    flight.getPlaneByPlaneId(),
                    flight.getFlightNumber(),
                    flight.getDirection(),
                    flight.getDepartureTime(),
                    flight.getArrivalTime(),
                    flight.getStateByStateId()
            );
            return new ResponseEntity<>(flightDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Flight newFlight) {
        flightService.create(newFlight);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FlightDto> update(@PathVariable Integer id,
                                              @RequestBody Flight flight) {
        Flight flight1 = flightService.getById(id);
        if (flight1 != null) {
            flightService.update(id, flight);
            FlightDto flightDto = new FlightDto(
                    flight.getId(),
                    flight.getPlaneByPlaneId(),
                    flight.getFlightNumber(),
                    flight.getDirection(),
                    flight.getDepartureTime(),
                    flight.getArrivalTime(),
                    flight.getStateByStateId()
            );
            return new ResponseEntity<>(flightDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (flightService.getById(id) != null) {
            flightService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
