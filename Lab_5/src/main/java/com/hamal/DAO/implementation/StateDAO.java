package com.hamal.DAO.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.model.implementation.State;
import com.hamal.persistance.ConnectionManager;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

public class StateDAO implements BasicDAO<State, Integer> {

    private static final String GET_ALL = "SELECT * FROM hamal_db.state";

    private static final String GET_BY_ID = "SELECT * FROM hamal_db.state WHERE id=?";

    private static final String DELETE = "DELETE FROM hamal_db.state WHERE id=?";

    private static final String CREATE = "INSERT hamal_db.state "
            + "(id, State) VALUES (?, ?)";

    private static final String UPDATE = "UPDATE hamal_db.state"
            + " SET State=? WHERE id=?";


    @Override
    public final List<State> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<State> iState = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String state = resultSet.getString(2);
                    iState.add(new State(id, state));
                }
            }
        }
        return iState;
    }

    @Override
    public final State getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        State iState = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer Id = resultSet.getInt(1);
                    String state = resultSet.getString(2);
                    iState = new State(Id, state);
                }
            }
        }

        return iState;
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
    public final int update(final State entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getState());
            ps.setInt(2, entity.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int create(final State entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getState());
            return ps.executeUpdate();
        }

    }
}