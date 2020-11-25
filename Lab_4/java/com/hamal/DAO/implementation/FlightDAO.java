package com.hamal.DAO.implementation;


import com.hamal.DAO.BasicDAO;
import com.hamal.model.implementation.Flight;
import com.hamal.persistance.ConnectionManager;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

public class FlightDAO implements BasicDAO<Flight, Integer> {

    private static final String GET_ALL = "SELECT * FROM hamal_db.flight";

    private static final String GET_BY_ID = "SELECT * FROM hamal_db.flight WHERE id=?";

    private static final String DELETE = "DELETE FROM hamal_db.flight WHERE id=?";

    private static final String CREATE = "INSERT hamal_db.flight "
            + "(id, Plane_id, flight_number, direction, departure_time, arrival_time,State_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE = "UPDATE hamal_db.flight"
            + " SET Plane_id=?, flight_number=?, direction=?, departure_time=?, arrival_time=?, State_id=?  WHERE id=?";

    @Override
    public final List<Flight> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Flight> flight = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer planeId = resultSet.getInt(2);
                    String flightNumber = resultSet.getString(3);
                    String direction = resultSet.getString(4);
                    String departureTime = resultSet.getString(5);
                    String arrivalTime = resultSet.getString(6);
                    Integer state = resultSet.getInt(7);

                    flight.add(new Flight(id, planeId,flightNumber,direction,departureTime,arrivalTime,state));
                }
            }
        }
        return flight;
    }

    @Override
    public final Flight getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Flight flight = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer flightId = resultSet.getInt(1);
                    Integer planeId = resultSet.getInt(2);
                    String flightNumber = resultSet.getString(3);
                    String direction = resultSet.getString(4);
                    String departureTime = resultSet.getString(5);
                    String arrivalTime = resultSet.getString(6);
                    Integer state = resultSet.getInt(7);

                    flight = new Flight(flightId, planeId,flightNumber,direction,departureTime,arrivalTime,state);
                }
            }
        }
        return flight;
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
    public final int update(final Flight entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getPlaneId());
            ps.setString(2, entity.getFlightNumber());
            ps.setString(3, entity.getDirection());
            ps.setString(4, entity.getDepartureTime());
            ps.setString(5, entity.getArrivalTime());
            ps.setInt(6, entity.getState());
            ps.setInt(7, entity.getId());
            return ps.executeUpdate();
        }
    }


    @Override
    public final int create(final Flight entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getPlaneId());
            ps.setString(3, entity.getFlightNumber());
            ps.setString(4, entity.getDirection());
            ps.setString(5, entity.getDepartureTime());
            ps.setString(6, entity.getArrivalTime());
            ps.setInt(7, entity.getState());
            return ps.executeUpdate();
        }
    }


}
