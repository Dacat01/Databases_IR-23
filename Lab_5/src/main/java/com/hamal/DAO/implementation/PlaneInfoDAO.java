package com.hamal.DAO.implementation;


import com.hamal.DAO.BasicDAO;
import com.hamal.model.implementation.PlaneInfo;
import com.hamal.persistance.ConnectionManager;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;


public class PlaneInfoDAO implements BasicDAO<PlaneInfo, Integer> {

    private static final String GET_ALL = "SELECT * FROM hamal_db.plane_info";

    private static final String GET_BY_ID = "SELECT * FROM hamal_db.plane_info WHERE Plane_id=?";

    private static final String DELETE = "DELETE FROM hamal_db.plane_info WHERE Plane_id=?";

    private static final String CREATE = "INSERT hamal_db.plane_info "
            + "(Plane_id, plane_identifier, type, total_hrs,max_speed) VALUES (?, ?, ?, ?, ?)";

    private static final String UPDATE = "UPDATE hamal_db.plane_info"
            + " SET plane_identifier=?,type=?,total_hrs=?,max_speed=? WHERE Plane_id=?";


    @Override
    public final List<PlaneInfo> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<PlaneInfo> planeInfo = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer planeId = resultSet.getInt(1);
                    String planeIdentifier = resultSet.getString(2);
                    String type = resultSet.getString(3);
                    Integer totalHours = resultSet.getInt(4);
                    Integer maximumSpeed = resultSet.getInt(5);
                    planeInfo.add(new PlaneInfo(planeId, planeIdentifier,type,totalHours,maximumSpeed));
                }
            }
        }
        return planeInfo;
    }


    @Override
    public final PlaneInfo getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        PlaneInfo planeInfo = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer planeId = resultSet.getInt(1);
                    String planeIdentifier = resultSet.getString(2);
                    String type = resultSet.getString(3);
                    Integer totalHours = resultSet.getInt(4);
                    Integer maximumSpeed = resultSet.getInt(5);
                    planeInfo = new PlaneInfo(planeId, planeIdentifier,type,totalHours,maximumSpeed);
                }
            }
        }
        return planeInfo;
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
    public final int update(final PlaneInfo entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {

            ps.setString(1, entity.getPlaneIdentifier());
            ps.setString(2, entity.getType());
            ps.setInt(3, entity.getTotalHours());
            ps.setInt(4, entity.getMaximumSpeed());
            ps.setInt(5, entity.getplaneId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int create(final PlaneInfo entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {

            ps.setInt(1, entity.getplaneId());
            ps.setString(2, entity.getPlaneIdentifier());
            ps.setString(3, entity.getType());
            ps.setInt(4, entity.getTotalHours());
            ps.setInt(5, entity.getMaximumSpeed());

            return ps.executeUpdate();
        }
    }



}
