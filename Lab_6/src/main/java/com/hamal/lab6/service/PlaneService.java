package com.hamal.lab6.service;

import com.hamal.lab6.domain.Plane;
import com.hamal.lab6.repository.PlaneRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService implements AbstractService<Plane, Integer> {

    private final PlaneRepository planeRepository;


    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }


    @Override
    public List<Plane> getAll() {
        return planeRepository.findAll();
    }


    @Override
    public Plane getById(Integer id) {
        return planeRepository.getOne(id);
    }

    @Override
    public Plane create(Plane plane) {
        return planeRepository.save(plane);
    }

    @Override
    public Plane update(Integer id, Plane plane) {
        if (planeRepository.findById(id).isPresent()) {
            return planeRepository.save(plane);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (planeRepository.findById(id).isPresent()) {
            planeRepository.deleteById(id);
        }
    }

}


