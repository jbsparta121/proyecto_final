
package com.mycompany.proyecto_final.modelo;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Configuration configuration;

    private static void crearSesion() {
        try {
            configuration = new Configuration().configure();
            configuration.setProperty("hibernate.connection.username", "edwar");
            configuration.setProperty("hibernate.connection.password", "edwar");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException ex) {
            System.err.println("No se creo la sesion Factory" + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            crearSesion();
        }
        return sessionFactory;
    }

    public static void cerrarSesion() {
        sessionFactory.close();
    }
}
