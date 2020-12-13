package com.hamal.service.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.implementation.PlaneInfoDAO;
import com.hamal.model.PlaneInfo;
import com.hamal.service.BasicService;

public class PlaneInfoService implements BasicService<PlaneInfo, Integer> {

    BasicDAO planeInfoDAO = new PlaneInfoDAO();

    @Override
    public BasicDAO<PlaneInfo, Integer> getDAO() {
        return planeInfoDAO;
    }

    }