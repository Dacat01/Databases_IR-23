package com.hamal.service.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.implementation.AirlineDAO;
import com.hamal.model.implementation.Airline;

public class AirlineService extends IBasicService<Airline> {

    private final BasicDAO<Airline, Integer> airlineDAOImplementation = new AirlineDAO();

    @Override
    public final BasicDAO<Airline, Integer> getDAO() {
        return airlineDAOImplementation;
    }
}
