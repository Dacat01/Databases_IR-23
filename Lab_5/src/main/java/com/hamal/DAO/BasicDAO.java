package com.hamal.DAO;

import java.sql.SQLException;
import java.util.List;

public interface BasicDAO<T, ID> {
    //Інтерфейси визначають функціонал без конкретної реалізації
    //Для реалізації інтерфейсу у класі використовується implement
    //Можна робити extend інтерфесу для додавання спеціальних методів

    //Методи, які притаманні для всіх табличок


    List<T> getAll() throws SQLException;

    T getById(ID id) throws SQLException;

    int delete(ID id) throws SQLException;

    int update(T entity) throws SQLException;

    int create(T entity) throws SQLException;

}

