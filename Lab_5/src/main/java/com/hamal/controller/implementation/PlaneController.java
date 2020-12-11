package com.hamal.controller.implementation;

import com.hamal.model.implementation.Plane;
import com.hamal.service.implementation.PlaneService;
import com.hamal.service.implementation.IBasicService;

public class PlaneController extends IBasicController<Plane> {

    private static final PlaneService PLANE_SERVICE = new PlaneService();

    @Override
    public final IBasicService<Plane> getService() {
        return PLANE_SERVICE;
    }

}