package com.hamal.controller.implementation;


import com.hamal.model.implementation.PlaneInfo;
import com.hamal.service.implementation.PlaneInfoService;
import com.hamal.service.implementation.IBasicService;

public class PlaneInfoController extends IBasicController<PlaneInfo> {

    private static final PlaneInfoService PLANE_INFO_SERVICE = new PlaneInfoService();

    @Override
    public final IBasicService<PlaneInfo> getService() {
        return PLANE_INFO_SERVICE;
    }

}
