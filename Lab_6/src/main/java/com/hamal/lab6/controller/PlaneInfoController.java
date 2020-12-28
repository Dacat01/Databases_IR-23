
package com.hamal.lab6.controller;

import com.hamal.lab6.domain.PlaneInfo;
import com.hamal.lab6.dto.PlaneInfoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hamal.lab6.service.PlaneInfoService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/PlaneInfo")
@RestController
public class PlaneInfoController {
    private final PlaneInfoService planeInfoService;

    public PlaneInfoController(PlaneInfoService planeInfoService) {
        this.planeInfoService = planeInfoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PlaneInfoDto>> getAll() {
        List<PlaneInfo> planeInfos  = planeInfoService.getAll();
        List<PlaneInfoDto> planeInfoDtos = new ArrayList<>();
        for (PlaneInfo planeInfo : planeInfos) {
            PlaneInfoDto planeInfoDto = new PlaneInfoDto(
                    planeInfo.getPlaneId(),
                    planeInfo.getPlaneIdentifier(),
                    planeInfo.getType(),
                    planeInfo.getMaxSpeed(),
                    planeInfo.getTotalHrs()
            );
            planeInfoDtos.add(planeInfoDto);
        }
        return new ResponseEntity<>(planeInfoDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<PlaneInfoDto> getById(@PathVariable Integer id) {
        PlaneInfo planeInfo = planeInfoService.getById(id);
        if (planeInfo != null) {
            PlaneInfoDto planeInfoDto = new PlaneInfoDto(
                    planeInfo.getPlaneId(),
                    planeInfo.getPlaneIdentifier(),
                    planeInfo.getType(),
                    planeInfo.getMaxSpeed(),
                    planeInfo.getTotalHrs()
            );
            return new ResponseEntity<>(planeInfoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody PlaneInfo newPlaneInfo) {
        planeInfoService.create(newPlaneInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PlaneInfoDto> update(@PathVariable Integer id,
                                              @RequestBody PlaneInfo planeInfo) {
        PlaneInfo planeInfo1 = planeInfoService.getById(id);
        if (planeInfo1 != null) {
            planeInfoService.update(id, planeInfo);
            PlaneInfoDto planeInfoDto = new PlaneInfoDto(
                    planeInfo.getPlaneId(),
                    planeInfo.getPlaneIdentifier(),
                    planeInfo.getType(),
                    planeInfo.getMaxSpeed(),
                    planeInfo.getTotalHrs()
            );
            return new ResponseEntity<>(planeInfoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (planeInfoService.getById(id) != null) {
            planeInfoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
