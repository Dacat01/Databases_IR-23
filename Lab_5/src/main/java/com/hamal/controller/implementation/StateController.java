package com.hamal.controller.implementation;

import com.hamal.model.State;
import com.hamal.service.implementation.StateService;
import com.hamal.service.BasicService;
import com.hamal.controller.BasicController;

public class StateController implements BasicController<State, Integer> {

    @Override
    public BasicService getService() {
        return new StateService();
    }

    @Override
    public void printHeaders() {
        //      System.out.println(Airline.getHeaders());
    }

}
