package com.hamal.lab6.service;

import com.hamal.lab6.domain.CurrentLocation;
import com.hamal.lab6.repository.CurrentLocationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentLocationService implements AbstractService<CurrentLocation, Integer> {

    private final CurrentLocationRepository currentLocationRepository;


    public CurrentLocationService(CurrentLocationRepository currentLocationRepository) {
        this.currentLocationRepository = currentLocationRepository;
    }


    @Override
    public List<CurrentLocation> getAll() {
        return currentLocationRepository.findAll();
    }


    @Override
    public CurrentLocation getById(Integer id) {
        return currentLocationRepository.getOne(id);
    }

    @Override
    public CurrentLocation create(CurrentLocation currentLocation) {
        return currentLocationRepository.save(currentLocation);
    }

    @Override
    public CurrentLocation update(Integer id, CurrentLocation currentLocation) {
        if (currentLocationRepository.findById(id).isPresent()) {
            return currentLocationRepository.save(currentLocation);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (currentLocationRepository.findById(id).isPresent()) {
            currentLocationRepository.deleteById(id);
        }
    }

}


