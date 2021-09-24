/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toko.sepeda.config;

import com.toko.sepeda.dao.TokoSepedaImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.toko.sepeda.dao.TokoSepedaDao;

/**
 *
 * @author artee
 */
public class HibernateUtil {
   private static final SessionFactory SESSION_FACTORY;
   private static final TokoSepedaDao TokoSepeda_DAO;

   static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
            TokoSepeda_DAO = new TokoSepedaImpl(SESSION_FACTORY);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory Creation Failed:" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static TokoSepedaDao getTokoSepedaDao() {
        return TokoSepeda_DAO;
    } 
}
