package com.hamal.DAO;

import com.hamal.DAO.queries.QueryManger;
import com.hamal.persistance.SessionManager;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public interface BasicDAO<T, ID> {

    //Методи, які притаманні для всіх табличок

  QueryManger getQueryManger();



  default List<T> findAll() throws SQLException {
    List<T> entityList = new ArrayList<>();
    try (Session session = SessionManager.getSession()) {
      Query query = session.createQuery(getQueryManger().getFindAllQuery());
      for (Object entity : query.list()) {
        entityList.add((T) entity);
      }
      return entityList;
    }
  }

  default T findById(ID id) throws SQLException {

    try (Session session = SessionManager.getSession()) {
      Query query = session.createQuery(getQueryManger().getFindByIdQuery());
      query.setParameter("id", id);
      return (T) query.uniqueResult();
    }
  }

  default int create(T entity) throws SQLException {
    try (Session session = SessionManager.getSession()) {
      int id = (int) session.save(entity);
      session.close();
      return id;
    }
  }

  default void update(T entity) throws SQLException {

    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);

      session.getTransaction().commit();
      session.close();
    }
  }

  default int delete(ID id) throws SQLException {

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