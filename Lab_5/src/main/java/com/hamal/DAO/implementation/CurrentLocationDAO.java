package com.hamal.DAO.implementation;

import com.hamal.model.CurrentLocation;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hamal.DAO.queries.QueryManger;
import com.hamal.persistance.SessionManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hamal.DAO.BasicDAO;

public class CurrentLocationDAO implements BasicDAO<CurrentLocation, Integer> {

    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("CurrentLocation");
        }
        return queryManger;
    }

    @Override
    public final  List<CurrentLocation> findAll() throws SQLException {

        List<CurrentLocation> entityList = new ArrayList<>();

        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryManger().getFindAllQuery());

            for (Object entity : query.list()) {

                entityList.add((CurrentLocation) entity);
            }

            return entityList;
        }
    }

    @Override
    public final CurrentLocation findById(Integer id) throws SQLException {

        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryManger().getFindByIdQuery());
            query.setParameter("id", id);
            return (CurrentLocation) query.uniqueResult();
        }
    }

    @Override
    public final int create(final CurrentLocation entity) throws SQLException {
        try (Session session = SessionManager.getSession()) {
            session.beginTransaction();

            session.save(entity);
            session.getTransaction().commit();

            session.close();
            return 1;
        }
    }

    @Override
    public final void update(CurrentLocation entity) throws SQLException {

        try (Session session = SessionManager.getSession()) {
            session.beginTransaction();
            session.update(entity);

            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public final int delete(Integer id) throws SQLException {

        try (Session session = SessionManager.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery(getQueryManger().getDeleteByIdQuery());
            query.setParameter("id", id);
            Integer res = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            return res;
        }
    }


}