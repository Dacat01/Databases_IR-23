package com.hamal.lab6.service;

import com.hamal.lab6.domain.PlaneInfo;
import com.hamal.lab6.repository.PlaneInfoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneInfoService implements AbstractService<PlaneInfo, Integer> {

    private final PlaneInfoRepository planeInfoRepository;


    public PlaneInfoService(PlaneInfoRepository planeInfoRepository) {
        this.planeInfoRepository = planeInfoRepository;
    }


    @Override
    public List<PlaneInfo> getAll() {
        return planeInfoRepository.findAll();
    }


    @Override
    public PlaneInfo getById(Integer id) {
        return planeInfoRepository.getOne(id);
    }

    @Override
    public PlaneInfo create(PlaneInfo planeInfo) {
        return planeInfoRepository.save(planeInfo);
    }

    @Override
    public PlaneInfo update(Integer id, PlaneInfo planeInfo) {
        if (planeInfoRepository.findById(id).isPresent()) {
            return planeInfoRepository.save(planeInfo);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (planeInfoRepository.findById(id).isPresent()) {
            planeInfoRepository.deleteById(id);
        }
    }

}


