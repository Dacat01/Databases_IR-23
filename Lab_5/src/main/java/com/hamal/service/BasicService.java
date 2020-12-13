package com.hamal.service;

import com.hamal.DAO.BasicDAO;

import java.sql.SQLException;
import java.util.List;

public interface BasicService<T, ID> {

    BasicDAO<T, ID> getDAO();

    default List<T> findAll() throws SQLException {
        return getDAO().findAll();
    }

    default T findById(ID id) throws SQLException {
        return getDAO().findById(id);
    }

    default int create(T entity) throws SQLException {
        return getDAO().create(entity);
    }

    default void update(T entity) throws SQLException {
        getDAO().update(entity);
    }

    default int delete(ID id) throws SQLException {
        return getDAO().delete(id);
    }
}