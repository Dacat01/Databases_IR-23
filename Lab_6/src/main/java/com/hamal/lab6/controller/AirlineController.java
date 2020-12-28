
package com.hamal.lab6.controller;

import com.hamal.lab6.domain.Airline;
import com.hamal.lab6.dto.AirlineDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hamal.lab6.service.AirlineService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Airline")
@RestController
public class AirlineController {
    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AirlineDto>> getAll() {
        List<Airline> airlines  = airlineService.getAll();
        List<AirlineDto> airlineDtos = new ArrayList<>();
        for (Airline airline : airlines) {
            AirlineDto airlineDto = new AirlineDto(
                    airline.getId(),
                    airline.getName()

            );
            airlineDtos.add(airlineDto);
        }
        return new ResponseEntity<>(airlineDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<AirlineDto> getById(@PathVariable Integer id) {
        Airline airline = airlineService.getById(id);
        if (airline != null) {
            AirlineDto airlineDto = new AirlineDto(
                    airline.getId(),
                    airline.getName()
            );
            return new ResponseEntity<>(airlineDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Airline newAirline) {
        airlineService.create(newAirline);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AirlineDto> update(@PathVariable Integer id,
                                              @RequestBody Airline airline) {
        Airline airline1 = airlineService.getById(id);
        if (airline1 != null) {
            airlineService.update(id, airline);
            AirlineDto airlineDto = new AirlineDto(
                    airline.getId(),
                    airline.getName()
            );
            return new ResponseEntity<>(airlineDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (airlineService.getById(id) != null) {
            airlineService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
