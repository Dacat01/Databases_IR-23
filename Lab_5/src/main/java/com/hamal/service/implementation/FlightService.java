package com.hamal.service.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.implementation.FlightDAO;
import com.hamal.model.CurrentLocation;
import com.hamal.service.BasicService;

public class FlightService implements BasicService<CurrentLocation,Integer>{

    BasicDAO flightDAO = new FlightDAO();

    @Override
    public BasicDAO<CurrentLocation, Integer> getDAO() {
        return flightDAO;
    }

}
