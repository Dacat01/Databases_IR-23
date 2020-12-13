package com.hamal.service.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.implementation.PlaneDAO;
import com.hamal.model.Plane;
import com.hamal.service.BasicService;

public class PlaneService implements BasicService<Plane, Integer> {

    BasicDAO planeDAO = new PlaneDAO();

    @Override
    public BasicDAO<Plane, Integer> getDAO() {
        return planeDAO;
    }

}