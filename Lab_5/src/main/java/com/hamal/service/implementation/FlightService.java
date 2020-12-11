package com.hamal.service.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.implementation.FlightDAO;
import com.hamal.model.implementation.Flight;

public class FlightService extends IBasicService<Flight> {

    private final BasicDAO<Flight, Integer> flightDAOImplementation = new FlightDAO();

    @Override
    public final BasicDAO<Flight, Integer> getDAO() {
        return flightDAOImplementation;
    }
}
