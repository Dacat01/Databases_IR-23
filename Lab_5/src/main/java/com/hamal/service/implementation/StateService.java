package com.hamal.service.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.implementation.StateDAO;
import com.hamal.model.implementation.State;

public class StateService extends IBasicService<State> {

    private final BasicDAO<State, Integer> stateDAOImplementation = new StateDAO();

    @Override
    public final BasicDAO<State, Integer> getDAO() {
        return stateDAOImplementation;
    }
}