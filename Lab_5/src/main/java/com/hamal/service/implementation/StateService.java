package com.hamal.service.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.implementation.StateDAO;
import com.hamal.model.State;
import com.hamal.service.BasicService;

public class StateService implements BasicService<State,Integer>{

    BasicDAO stateDAO = new StateDAO();

    @Override
    public BasicDAO<State, Integer> getDAO() {
        return stateDAO;
    }

}