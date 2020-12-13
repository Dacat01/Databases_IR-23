package com.hamal.DAO.implementation;

import com.hamal.DAO.queries.QueryManger;
import com.hamal.DAO.BasicDAO;
import com.hamal.model.PlaneInfo;


public class PlaneInfoDAO implements BasicDAO<PlaneInfo, Integer> {

    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("PlaneInfo");
        }
        return queryManger;
    }
}