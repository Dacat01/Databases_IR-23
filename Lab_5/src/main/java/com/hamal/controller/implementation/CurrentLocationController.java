package com.hamal.controller.implementation;


import com.hamal.model.implementation.CurrentLocation;
import com.hamal.service.implementation.CurrentLocationService;
import com.hamal.service.implementation.IBasicService;


public  class CurrentLocationController extends IBasicController <CurrentLocation>  {

    private static final CurrentLocationService CURRENT_LOCATION_SERVICE = new CurrentLocationService();

    @Override
    public  final IBasicService<CurrentLocation> getService() {
        return CURRENT_LOCATION_SERVICE;
    }
}
