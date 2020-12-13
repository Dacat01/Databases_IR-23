package com.hamal.DAO;

import com.hamal.DAO.queries.QueryManger;
import java.sql.SQLException;
import java.util.List;

public interface BasicDAO<T, ID> {
    //Інтерфейси визначають функціонал без конкретної реалізації
    //Для реалізації інтерфейсу у класі використовується implement
    //Можна робити extend інтерфесу для додавання спеціальних методів

    //Методи, які притаманні для всіх табличок

  QueryManger getQueryManger();


    List<T> findAll() throws SQLException;
    T findById(ID id) throws SQLException;
    int create(T entity) throws SQLException;
    void update(T entity) throws SQLException;
    int delete(ID id) throws SQLException;
}