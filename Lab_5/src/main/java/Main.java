/*

import ua.lviv.iot.kasaraba.persistence.SessionManager;
import ua.lviv.iot.kasaraba.view.MyView;

public class Runner {
    public static void main(final String[] args) throws Exception {
        SessionManager.openSessionFactory();
        new MyView().show();
        SessionManager.closeSessionFactory();
    }
}

*/

import com.hamal.view.MyView;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/*
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
*/

import javax.persistence.metamodel.EntityType;


import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {

 //           System.out.println("querying all the managed entities...");
            new MyView().show();

        } finally {
            session.close();
        }
    }
}