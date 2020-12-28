
package com.hamal.lab6.controller;

import com.hamal.lab6.domain.Plane;
import com.hamal.lab6.dto.PlaneDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hamal.lab6.service.PlaneService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Plane")
@RestController
public class PlaneController {
    private final PlaneService planeService;

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PlaneDto>> getAll() {
        List<Plane> planes  = planeService.getAll();
        List<PlaneDto> planeDtos = new ArrayList<>();
        for (Plane plane : planes) {
            PlaneDto planeDto = new PlaneDto(
                    plane.getId(),
                    plane.getAirlineByAirlineId(),
                    plane.getCurrentLocationByCurrentLocationId()

            );
            planeDtos.add(planeDto);
        }
        return new ResponseEntity<>(planeDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<PlaneDto> getById(@PathVariable Integer id) {
        Plane plane = planeService.getById(id);
        if (plane != null) {
            PlaneDto planeDto = new PlaneDto(
                    plane.getId(),
                    plane.getAirlineByAirlineId(),
                    plane.getCurrentLocationByCurrentLocationId()

            );
            return new ResponseEntity<>(planeDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Plane newPlane) {
        planeService.create(newPlane);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PlaneDto> update(@PathVariable Integer id,
                                              @RequestBody Plane plane) {
        Plane plane1 = planeService.getById(id);
        if (plane1 != null) {
            planeService.update(id, plane);
            PlaneDto planeDto = new PlaneDto(
                    plane.getId(),
                    plane.getAirlineByAirlineId(),
                    plane.getCurrentLocationByCurrentLocationId()
            );
            return new ResponseEntity<>(planeDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (planeService.getById(id) != null) {
            planeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
