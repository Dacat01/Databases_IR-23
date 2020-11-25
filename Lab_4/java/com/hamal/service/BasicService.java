package com.hamal.service;

import com.hamal.DAO.BasicDAO;

import java.sql.SQLException;
import java.util.List;

public interface BasicService<T> {
    BasicDAO<T, Integer> getDAO();

    List<T> getAll() throws SQLException;

    T getById(Integer id) throws SQLException;

    int delete(Integer id) throws SQLException;

    int update(T entity) throws SQLException;

    int create(T entity) throws SQLException;

}
