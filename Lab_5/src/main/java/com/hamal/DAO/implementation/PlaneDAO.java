package com.hamal.DAO.implementation;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hamal.DAO.queries.QueryManger;
import com.hamal.persistance.SessionManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hamal.DAO.BasicDAO;
import com.hamal.model.Plane;


public class PlaneDAO implements BasicDAO<Plane, Integer> {

    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("Plane");
        }
        return queryManger;
    }


    @Override
    public final  List<Plane> findAll() throws SQLException {
        List<Plane> entityList = new ArrayList<>();
        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryManger().getFindAllQuery());
            for (Object entity : query.list()) {
                entityList.add((Plane) entity);
            }
            return entityList;
        }
    }

    @Override
    public final Plane findById(Integer id) throws SQLException {

        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryManger().getFindByIdQuery());
            query.setParameter("id", id);
            return (Plane) query.uniqueResult();
        }
    }

    @Override
    public final int create(final Plane entity) throws SQLException {
        try (Session session = SessionManager.getSession()) {
            session.beginTransaction();

            session.save(entity);
            session.getTransaction().commit();

            session.close();
            return 1;
        }
    }

    @Override
    public final void update(Plane entity) throws SQLException {

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