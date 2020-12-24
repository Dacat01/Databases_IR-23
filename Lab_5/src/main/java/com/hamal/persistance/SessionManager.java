package com.hamal.persistance;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/*
 Интерфейс org.hibernate.Session является мостом между приложением и Hibernate.
 С помощью сессий выполняются все CRUD-операции с объектами-сущностями.
 Объект типа Session получают из экземпляра типа org.hibernate.SessionFactory
 https://habr.com/ru/post/271115/
 */

public class SessionManager {
    private static SessionFactory sessionFactory;

    public static void openSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
//| Session close     -  Need to close the session object once all the database operations are done
// No need to close the session. Once the session factory is closed, this session object is closed.

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}