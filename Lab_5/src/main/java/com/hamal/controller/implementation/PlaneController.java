package com.hamal.controller.implementation;

import com.hamal.model.Plane;
import com.hamal.service.implementation.PlaneService;
import com.hamal.service.BasicService;
import com.hamal.controller.BasicController;

public class PlaneController implements BasicController<Plane, Integer> {

    @Override
    public BasicService getService() {
        return new PlaneService();
    }

}