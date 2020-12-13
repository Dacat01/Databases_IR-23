package com.hamal.controller.implementation;

import com.hamal.model.Flight;
import com.hamal.service.implementation.FlightService;
import com.hamal.service.BasicService;
import com.hamal.controller.BasicController;

public class FlightController implements BasicController<Flight, Integer> {

    @Override
    public BasicService getService() {
        return new FlightService();
    }

    @Override
    public void printHeaders() {

        //     System.out.println(Airline.getHeaders());
    }

}