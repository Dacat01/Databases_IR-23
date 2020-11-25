package com.hamal.DAO.implementation;

import com.hamal.DAO.BasicDAO;
import com.hamal.model.implementation.Plane;
import com.hamal.persistance.ConnectionManager;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

public class PlaneDAO implements BasicDAO<Plane, Integer> {

    private static final String GET_ALL = "SELECT * FROM hamal_db.plane";

    private static final String GET_BY_ID = "SELECT * FROM hamal_db.plane WHERE id=?";

    private static final String DELETE = "DELETE FROM hamal_db.plane WHERE id=?";

    private static final String CREATE = "INSERT hamal_db.plane "
            + "(id, airline_id, Current_location_id) VALUES (?, ?, ?)";

    private static final String UPDATE = "UPDATE hamal_db.plane"
            + " SET airline_id=?,Current_location_id=?  WHERE id=?";



    @Override
    public final List<Plane> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Plane> plane = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer airlineId = resultSet.getInt(2);
                    Integer currentLocationId = resultSet.getInt(3);

                    plane.add(new Plane(id, airlineId, currentLocationId));
                }
            }
        }
        return plane;
    }

    @Override
    public final Plane getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Plane plane = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer planeId = resultSet.getInt(1);
                    Integer airlineId = resultSet.getInt(2);
                    Integer currentLocationId = resultSet.getInt(3);
                    plane = new Plane(planeId,airlineId,currentLocationId);
                }
            }
        }

        return plane;
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
    public final int update(final Plane entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getAirlineId());          // В ЗАЛЕЖНОСТІ ВІД РОЗЗТАШУВАННЯ У (UPDATE) НА ВЕРХУ
            ps.setInt(2, entity.getCurrentLocationId());
            ps.setInt(3, entity.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int create(final Plane entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getAirlineId());
            ps.setInt(3, entity.getCurrentLocationId());
            return ps.executeUpdate();
        }
    }





}