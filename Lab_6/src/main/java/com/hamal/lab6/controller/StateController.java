
package com.hamal.lab6.controller;

import com.hamal.lab6.domain.State;
import com.hamal.lab6.dto.StateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hamal.lab6.service.StateService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/State")
@RestController
public class StateController {
    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StateDto>> getAll() {
        List<State> states  = stateService.getAll();
        List<StateDto> stateDtos = new ArrayList<>();
        for (State state : states) {
            StateDto stateDto = new StateDto(
                    state.getId(),
                    state.getState()

            );
            stateDtos.add(stateDto);
        }
        return new ResponseEntity<>(stateDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<StateDto> getById(@PathVariable Integer id) {
        State state = stateService.getById(id);
        if (state != null) {
            StateDto stateDto = new StateDto(
                    state.getId(),
                    state.getState()
            );
            return new ResponseEntity<>(stateDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody State newState) {
        stateService.create(newState);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StateDto> update(@PathVariable Integer id,
                                              @RequestBody State state) {
        State state1 = stateService.getById(id);
        if (state1 != null) {
            stateService.update(id, state);
            StateDto stateDto = new StateDto(
                    state.getId(),
                    state.getState()
            );
            return new ResponseEntity<>(stateDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (stateService.getById(id) != null) {
            stateService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
