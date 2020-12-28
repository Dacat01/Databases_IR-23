package com.hamal.lab6.service;

import com.hamal.lab6.domain.State;
import com.hamal.lab6.repository.StateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService implements AbstractService<State, Integer> {

    private final StateRepository stateRepository;


    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }


    @Override
    public List<State> getAll() {
        return stateRepository.findAll();
    }


    @Override
    public State getById(Integer id) {
        return stateRepository.getOne(id);
    }

    @Override
    public State create(State state) {
        return stateRepository.save(state);
    }

    @Override
    public State update(Integer id, State state) {
        if (stateRepository.findById(id).isPresent()) {
            return stateRepository.save(state);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (stateRepository.findById(id).isPresent()) {
            stateRepository.deleteById(id);
        }
    }

}


