package com.hamal.controller;


import com.hamal.service.BasicService;

import java.sql.SQLException;

public interface BasicController<T> {

    void getById(int id) throws SQLException;
    void getAll() throws SQLException;
    void delete(int id) throws SQLException;
    void update(T entity) throws SQLException;
    void create(T entity) throws SQLException;

    BasicService<T> getService();
}
