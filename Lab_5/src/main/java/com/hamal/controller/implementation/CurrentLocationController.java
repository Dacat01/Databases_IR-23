package com.hamal.controller.implementation;


import com.hamal.model.CurrentLocation;
import com.hamal.service.implementation.CurrentLocationService;
import com.hamal.service.BasicService;
import com.hamal.controller.BasicController;

public class CurrentLocationController implements BasicController<CurrentLocation, Integer> {

    @Override
    public BasicService getService() {
        return new CurrentLocationService();
    }

}
