package com.hamal.controller.implementation;


import com.hamal.model.implementation.Flight;
import com.hamal.service.implementation.FlightService;
import com.hamal.service.implementation.IBasicService;

public class FlightController extends IBasicController<Flight> {

    private static final FlightService FLIGHT_SERVICE = new FlightService();

    @Override
    public final IBasicService<Flight> getService() {
        return FLIGHT_SERVICE;
    }
}