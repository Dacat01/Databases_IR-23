package com.hamal.service.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.implementation.PlaneInfoDAO;
import com.hamal.model.implementation.PlaneInfo;


public class PlaneInfoService extends IBasicService<PlaneInfo> {

    private final BasicDAO<PlaneInfo, Integer> planeInfoDAOImplementation = new PlaneInfoDAO();

    @Override
    public final BasicDAO<PlaneInfo, Integer> getDAO() {
        return planeInfoDAOImplementation;
    }
}
