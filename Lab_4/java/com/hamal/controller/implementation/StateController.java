package com.hamal.controller.implementation;

import com.hamal.model.implementation.State;
import com.hamal.service.implementation.StateService;
import com.hamal.service.implementation.IBasicService;


public class StateController extends IBasicController<State> {

    private static final StateService STATE_SERVICE = new StateService();

    @Override
    public final IBasicService<State> getService() {
        return STATE_SERVICE;
    }

}
