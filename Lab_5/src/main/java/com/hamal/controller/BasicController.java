package com.hamal.controller;


import com.hamal.service.BasicService;
import com.hamal.view.Printable;


//
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
//

public interface BasicController<T,id> {
    BasicService getService();

    void printHeaders();

    default void getAllEntities() throws SQLException {
        List<T> entities = getService().findAll();
        printHeaders();
        for (T entity : entities) {
            System.out.println(entity);
        }
    }

    default Printable getEntity(Integer id) throws SQLException {
        T entity = (T) getService().findById(id);
        printHeaders();
        System.out.println(entity);
        return null;
    }

    default int createEntity(T entity) throws SQLException {
        return getService().create(entity);
    }

    default void updateEntity(T entity) throws SQLException {
        getService().update(entity);
    }

    default int removeEntity(Integer id) throws SQLException {
        return getService().delete(id);
    }
}