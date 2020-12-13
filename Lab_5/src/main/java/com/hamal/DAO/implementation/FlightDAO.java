package com.hamal.DAO.implementation;

import com.hamal.DAO.queries.QueryManger;

import com.hamal.DAO.BasicDAO;
import com.hamal.model.Flight;

public class FlightDAO implements BasicDAO<Flight, Integer> {

    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("Flight");
        }
        return queryManger;
    }

}