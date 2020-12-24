package com.hamal.controller.implementation;


import com.hamal.model.PlaneInfo;
import com.hamal.service.implementation.PlaneInfoService;
import com.hamal.service.BasicService;
import com.hamal.controller.BasicController;

public class PlaneInfoController implements BasicController<PlaneInfo, Integer> {

    @Override
    public BasicService getService() {
        return new PlaneInfoService();
    }

}

