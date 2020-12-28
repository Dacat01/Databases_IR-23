
package com.hamal.lab6.controller;

import com.hamal.lab6.domain.CurrentLocation;
import com.hamal.lab6.dto.CurrentLocationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hamal.lab6.service.CurrentLocationService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/CurrentLocation")
@RestController
public class CurrentLocationController {
    private final CurrentLocationService currentLocationService;

    public CurrentLocationController(CurrentLocationService currentLocationService) {
        this.currentLocationService = currentLocationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CurrentLocationDto>> getAll() {
        List<CurrentLocation> currentLocations  = currentLocationService.getAll();
        List<CurrentLocationDto> currentLocationDtos = new ArrayList<>();
        for (CurrentLocation currentLocation : currentLocations) {
            CurrentLocationDto currentLocationDto = new CurrentLocationDto(
                    currentLocation.getId(),
                    currentLocation.getCountry(),
                    currentLocation.getCity(),
                    currentLocation.getAirport()
            );
            currentLocationDtos.add(currentLocationDto);
        }
        return new ResponseEntity<>(currentLocationDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<CurrentLocationDto> getById(@PathVariable Integer id) {
        CurrentLocation currentLocation = currentLocationService.getById(id);
        if (currentLocation != null) {
            CurrentLocationDto currentLocationDto = new CurrentLocationDto(
                    currentLocation.getId(),
                    currentLocation.getCountry(),
                    currentLocation.getCity(),
                    currentLocation.getAirport()
            );
            return new ResponseEntity<>(currentLocationDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody CurrentLocation newCurrentLocation) {
        currentLocationService.create(newCurrentLocation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CurrentLocationDto> update(@PathVariable Integer id,
                                              @RequestBody CurrentLocation currentLocation) {
        CurrentLocation currentLocation1 = currentLocationService.getById(id);
        if (currentLocation1 != null) {
            currentLocationService.update(id, currentLocation);
            CurrentLocationDto currentLocationDto = new CurrentLocationDto(
                    currentLocation.getId(),
                    currentLocation.getCountry(),
                    currentLocation.getCity(),
                    currentLocation.getAirport()
            );
            return new ResponseEntity<>(currentLocationDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (currentLocationService.getById(id) != null) {
            currentLocationService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
