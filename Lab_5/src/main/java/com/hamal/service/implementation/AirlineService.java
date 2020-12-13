package com.hamal.service.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.implementation.AirlineDAO;
import com.hamal.model.Airline;
import com.hamal.service.BasicService;

public class AirlineService implements BasicService<Airline, Integer> {

     BasicDAO airlineDAO = new AirlineDAO();

    @Override
    public BasicDAO<Airline, Integer> getDAO() {
        return airlineDAO;
    }
}