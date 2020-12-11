package com.hamal.DAO.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.model.implementation.Airline;
import com.hamal.persistance.ConnectionManager;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

public class AirlineDAO implements BasicDAO<Airline, Integer> {

    private static final String GET_ALL = "SELECT * FROM hamal_db.airline";

    private static final String GET_BY_ID = "SELECT * FROM hamal_db.airline WHERE id=?";

    private static final String DELETE = "DELETE FROM hamal_db.airline WHERE id=?";

    private static final String CREATE = "INSERT hamal_db.airline "
            + "(id, name) VALUES (?, ?)";

    private static final String UPDATE = "UPDATE hamal_db.airline"
            + " SET name=? WHERE id=?";


    //Імплементація методів

    //Відкриваєм новий Connection, або отримуєм існуючий
    //Створюємо Linked List
    //Для connection створюєм statement
    //Statement використовується для виконання SQL-запитів
    //Для statement виконуєм потрібний Select
    //Повертається ResultSet
    //Отрмані дані запаковуєм в LinkedList і передаєм на Service Layer
    //передаємо на сервіс Layer, сервіс віддасть контролеру, контролер віддасть вюшці


    @Override
    public final List<Airline> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Airline> airline = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    airline.add(new Airline(id, name));
                }
            }
        }
        return airline;
    }

    @Override
    public final Airline getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Airline airline = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer airlineId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    airline = new Airline(airlineId, name);
                }
            }
        }

        return airline;
    }

    @Override
    public final int delete(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Airline entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());          // В ЗАЛЕЖНОСТІ ВІД РОЗЗТАШУВАННЯ У (UPDATE) НА ВЕРХУ
             ps.setInt(2, entity.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int create(final Airline entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            return ps.executeUpdate();
        }
    }

}