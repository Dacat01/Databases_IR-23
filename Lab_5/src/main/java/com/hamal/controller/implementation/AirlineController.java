package com.hamal.controller.implementation;


import com.hamal.model.implementation.Airline;
import com.hamal.service.implementation.AirlineService;
import com.hamal.service.implementation.IBasicService;


public class AirlineController extends IBasicController<Airline> {

    private static final AirlineService AIRLINE_SERVICE = new AirlineService();

    @Override
    public final IBasicService<Airline> getService() {
        return AIRLINE_SERVICE;
    }

}

