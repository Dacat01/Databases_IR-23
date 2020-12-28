package com.hamal.lab6.service;

import com.hamal.lab6.domain.Airline;
import com.hamal.lab6.repository.AirlineRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService implements AbstractService<Airline, Integer> {

    private final AirlineRepository airlineRepository;


    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }


    @Override
    public List<Airline> getAll() {
        return airlineRepository.findAll();
    }


    @Override
    public Airline getById(Integer id) {
        return airlineRepository.getOne(id);
    }

    @Override
    public Airline create(Airline state) {
        return airlineRepository.save(state);
    }

    @Override
    public Airline update(Integer id, Airline airline) {
        if (airlineRepository.findById(id).isPresent()) {
            return airlineRepository.save(airline);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (airlineRepository.findById(id).isPresent()) {
            airlineRepository.deleteById(id);
        }
    }

}


