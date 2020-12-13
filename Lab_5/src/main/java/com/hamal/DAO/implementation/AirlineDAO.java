package com.hamal.DAO.implementation;



import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hamal.DAO.queries.QueryManger;
import com.hamal.persistance.SessionManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hamal.DAO.BasicDAO;
import com.hamal.model.Airline;


public class AirlineDAO implements BasicDAO<Airline, Integer> {

    private QueryManger queryManger;

    @Override
    public QueryManger getQueryManger() {
        if (queryManger == null) {
            queryManger = new QueryManger("Airline");
        }
        return queryManger;
    }


    @Override
    public final  List<Airline> findAll() throws SQLException {
        List<Airline> entityList = new ArrayList<>();
        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryManger().getFindAllQuery());
            for (Object entity : query.list()) {
               entityList.add((Airline) entity);
            }
            return entityList;
        }
    }

    @Override
    public final Airline findById(Integer id) throws SQLException {

        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryManger().getFindByIdQuery());
            query.setParameter("id", id);
            return (Airline) query.uniqueResult();
        }
    }

   @Override
   public final int create(final Airline entity) throws SQLException {
        try (Session session = SessionManager.getSession()) {
            session.beginTransaction();

            session.save(entity);
            session.getTransaction().commit();

            session.close();
            return 1;
        }
    }

    @Override
    public final void update(Airline entity) throws SQLException {

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