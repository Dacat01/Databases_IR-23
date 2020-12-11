package com.hamal.service.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.implementation.CurrentLocationDAO;
import com.hamal.model.implementation.CurrentLocation;

public class CurrentLocationService extends IBasicService<CurrentLocation>{

    private final BasicDAO<CurrentLocation, Integer> currentLocationDAOImplementation = new CurrentLocationDAO();

    @Override
    public final BasicDAO<CurrentLocation, Integer> getDAO() {
        return currentLocationDAOImplementation;
    }

}
