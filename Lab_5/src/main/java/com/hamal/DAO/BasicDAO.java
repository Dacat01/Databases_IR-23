package com.hamal.DAO;

import com.hamal.DAO.queries.QueryManger;
import com.hamal.persistance.SessionManager;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public interface BasicDAO<T, ID> {



//  JPQL -  https://ru.bmstu.wiki/JPQL_(Java_Persistence_Query_Language)
//  HQL  -  https://proselyte.net/tutorials/hibernate-tutorial/hibernate-query-language/
// Методи Hibernate  -   https://temofeev.ru/info/articles/kak-rabotayut-metody-persist-merge-iz-jpa-i-metody-save-update-saveorupdate-iz-hibernate/
// Стани сутностей - http://akorsa.ru/2016/08/kak-rabotaet-flush-v-hibernate/

  QueryManger getQueryManger();



  default List<T> findAll() throws SQLException {
    List<T> entityList = new ArrayList<>();
    try (Session session = SessionManager.getSession()) {

      Query query = session.createQuery(getQueryManger().getFindAllQuery());
      for (Object entity : query.list()) {
        entityList.add((T) entity);     //Отримання даних відбувається в циклі
      }
      return entityList;
    }
  }

  default T findById(ID id) throws SQLException {

    try (Session session = SessionManager.getSession()) {
      Query query = session.createQuery(getQueryManger().getFindByIdQuery());
      query.setParameter("id", id);
      return (T) query.getSingleResult();
    }
  }

  default int create(T entity) throws SQLException {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);

/*    SAVE - генерується запит

      INSERT INTO table_name (
              column_name1,
              column_name2,
              column_name3,
      )
*/
      session.getTransaction().commit();
      session.close();
      return 1;

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