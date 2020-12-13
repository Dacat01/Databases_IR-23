package com.hamal.DAO.implementation;


import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.queries.QueryManger;
import com.hamal.model.State;


public class StateDAO implements BasicDAO<State, Integer> {

    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("State");
        }
        return queryManger;
    }
}
