package com.hamal.DAO.implementation;

import com.hamal.DAO.queries.QueryManger;
import com.hamal.DAO.BasicDAO;
import com.hamal.model.Airline;


public class AirlineDAO implements BasicDAO<Airline, Integer> {

    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("Airline");
        }
        return queryManger;
    }
}