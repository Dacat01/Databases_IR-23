package com.hamal.DAO.implementation;

import com.hamal.model.CurrentLocation;
import com.hamal.DAO.queries.QueryManger;

import com.hamal.DAO.BasicDAO;

public class CurrentLocationDAO implements BasicDAO<CurrentLocation, Integer> {

    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("CurrentLocation");
        }
        return queryManger;
    }

}