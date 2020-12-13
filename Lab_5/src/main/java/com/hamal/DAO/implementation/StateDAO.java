package com.hamal.DAO.implementation;


import com.hamal.DAO.BasicDAO;
import com.hamal.DAO.queries.QueryManger;
import com.hamal.model.State;
import com.hamal.persistance.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StateDAO implements BasicDAO<State, Integer> {

    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("State");
        }
        return queryManger;
    }


    @Override
    public final List<State> findAll() throws SQLException {
        List<State> entityList = new ArrayList<>();
        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryManger().getFindAllQuery());
            for (Object entity : query.list()) {
                entityList.add((State) entity);
            }
            return entityList;
        }
    }

    @Override
    public final State findById(Integer id) throws SQLException {

        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryManger().getFindByIdQuery());
            query.setParameter("id", id);
            return (State) query.uniqueResult();
        }
    }

    @Override
    public final int create(final State entity) throws SQLException {
        try (Session session = SessionManager.getSession()) {
            session.beginTransaction();

            session.save(entity);
            session.getTransaction().commit();

            session.close();
            return 1;
        }
    }

    @Override
    public final void update(State entity) throws SQLException {

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
