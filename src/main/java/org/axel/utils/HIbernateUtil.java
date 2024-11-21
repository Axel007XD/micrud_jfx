package org.axel.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HIbernateUtil {
    private static Logger logger= LogManager.getLogger(HIbernateUtil.class);
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
                logger.log(Level.INFO, "SessionFactory created");
            }catch (HibernateException e){
                e.fillInStackTrace();
                if (sessionFactory != null) {
                    sessionFactory.close();
                }

            }
        }
        return sessionFactory;
    }
    private static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
