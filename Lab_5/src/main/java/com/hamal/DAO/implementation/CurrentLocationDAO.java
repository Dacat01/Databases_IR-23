package com.hamal.DAO.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.model.implementation.CurrentLocation;
import com.hamal.persistance.ConnectionManager;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

public class CurrentLocationDAO implements BasicDAO<CurrentLocation, Integer> {

    private static final String GET_ALL = "SELECT * FROM hamal_db.current_location";


    private static final String GET_BY_ID = "SELECT * FROM hamal_db.current_location WHERE id=?";

    private static final String DELETE = "DELETE FROM hamal_db.current_location WHERE id=?";

    private static final String CREATE = "INSERT hamal_db.current_location "
            + "(id, country, city, airport) VALUES (?, ?, ?, ?)";

    private static final String UPDATE = "UPDATE hamal_db.current_location"
            + " SET country=?,city=?,airport=? WHERE id=?";



    @Override
    public final List<CurrentLocation> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<CurrentLocation> currentLocation = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String country = resultSet.getString(2);
                    String city = resultSet.getString(3);
                    String airline = resultSet.getString(4);
                    currentLocation.add(new CurrentLocation(id, country,city,airline));
                }
            }
        }
        return currentLocation;
    }

    @Override
    public final CurrentLocation getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        CurrentLocation currentLocation = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer currentLocationId = resultSet.getInt(1);
                    String country = resultSet.getString(2);
                    String city = resultSet.getString(3);
                    String airline = resultSet.getString(4);

                    currentLocation = new CurrentLocation(currentLocationId, country,city,airline);
                }
            }
        }
        return currentLocation;
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
    public final int update(final CurrentLocation entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getCountry());
            ps.setString(2, entity.getCity());
            ps.setString(3, entity.getAirport());
            ps.setInt(4, entity.getId());
            return ps.executeUpdate();
        }
    }


    @Override
    public final int create(final CurrentLocation entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getCountry());
            ps.setString(3, entity.getCity());
            ps.setString(4, entity.getAirport());
            return ps.executeUpdate();
        }
    }



}
