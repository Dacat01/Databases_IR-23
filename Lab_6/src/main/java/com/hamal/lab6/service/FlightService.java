package com.hamal.lab6.service;

import com.hamal.lab6.domain.Flight;
import com.hamal.lab6.repository.FlightRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService implements AbstractService<Flight, Integer> {

    private final FlightRepository flightRepository;


    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }


    @Override
    public Flight getById(Integer id) {
        return flightRepository.getOne(id);
    }

    @Override
    public Flight create(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight update(Integer id, Flight flight) {
        if (flightRepository.findById(id).isPresent()) {
            return flightRepository.save(flight);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (flightRepository.findById(id).isPresent()) {
            flightRepository.deleteById(id);
        }
    }

}


