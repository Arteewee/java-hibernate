/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toko.buku.config;

import com.toko.buku.dao.TokoBukuImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.toko.buku.dao.TokoBukuDao;

/**
 *
 * @author artee
 */
public class HibernateUtil {
   private static final SessionFactory SESSION_FACTORY;
   private static final TokoBukuDao TokoBuku_DAO;

   static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
            TokoBuku_DAO = new TokoBukuImpl(SESSION_FACTORY);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory Creation Failed:" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static TokoBukuDao getTokoBukuDao() {
        return TokoBuku_DAO;
    } 
}
