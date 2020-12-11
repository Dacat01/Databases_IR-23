package com.hamal.controller.implementation;

import com.hamal.controller.BasicController;
import com.hamal.service.implementation.IBasicService;
import com.hamal.model.BasicModel;

import java.sql.SQLException;
import java.util.List;

public abstract class IBasicController<T extends BasicModel> implements BasicController<T> {

    @Override
    public abstract IBasicService<T> getService();


    @Override
    public final void getAll() throws SQLException {
        List<T> lst =  getService().getAll();
        for (T t: lst) {
            System.out.println(t);
        }
    }

    @Override
    public final void getById(final int id) throws SQLException {
        T entity = getService().getById(id);
        if (entity != null) {
            System.out.println("Entity with id '" + id + "' was found:");
            System.out.println(entity);
        } else {
            System.out.println("Entity with id '" + id + "' was not found");
        }
    }
    @Override
    public final void delete(final int id) throws SQLException {
        getService().delete(id);
        System.out.println("Entity with id '" + id + "' was deleted");
    }

    @Override
    public final void update(final T entity) throws SQLException {
        getService().update(entity);
        System.out.println("Entity with id '"+ entity.getId() + "' was updated");
    }

    @Override
    public final void create(final T entity) throws SQLException {
        getService().create(entity);
        System.out.println("Entity was created:");
        System.out.println(entity);
    }











}

