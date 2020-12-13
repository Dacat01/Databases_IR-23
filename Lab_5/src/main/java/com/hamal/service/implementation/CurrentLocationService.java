package com.hamal.service.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.implementation.CurrentLocationDAO;
import com.hamal.model.CurrentLocation;
import com.hamal.service.BasicService;

public class CurrentLocationService implements BasicService<CurrentLocation,Integer>{

    BasicDAO currentLocationDAO = new CurrentLocationDAO();

    @Override
    public BasicDAO<CurrentLocation, Integer> getDAO() {
        return currentLocationDAO;
    }

}
