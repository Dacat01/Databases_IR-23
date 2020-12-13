package com.hamal.DAO.implementation;



import com.hamal.DAO.queries.QueryManger;

import com.hamal.DAO.BasicDAO;
import com.hamal.model.Plane;


public class PlaneDAO implements BasicDAO<Plane, Integer> {

    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("Plane");
        }
        return queryManger;
    }


}