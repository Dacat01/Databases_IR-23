package com.hamal.service.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.implementation.PlaneDAO;
import com.hamal.model.implementation.Plane;

public class PlaneService extends IBasicService<Plane> {

    private final BasicDAO<Plane, Integer> planeDAOImplementation = new PlaneDAO();

    @Override
    public final BasicDAO<Plane, Integer> getDAO() {
        return planeDAOImplementation;
    }
}