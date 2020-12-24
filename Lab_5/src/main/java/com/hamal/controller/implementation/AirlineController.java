package com.hamal.controller.implementation;


import com.hamal.model.Airline;
import com.hamal.service.implementation.AirlineService;
import com.hamal.service.BasicService;
import com.hamal.controller.BasicController;

public class AirlineController implements BasicController<Airline, Integer> {

    @Override
    public BasicService getService() {
        return new AirlineService();
    }
}

