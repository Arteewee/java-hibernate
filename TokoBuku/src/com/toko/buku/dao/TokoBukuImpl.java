
package com.toko.buku.dao;

import com.toko.buku.model.TokoBuku;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class TokoBukuImpl implements TokoBukuDao  {
    private final SessionFactory sessionFactory;
    public TokoBukuImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void save(TokoBuku tokobuku) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(tokobuku);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.print("Tidak dapat menyimpan buku");
            session.getTransaction().rollback();
        } finally {
            session.close();
    }
    }

    @Override
    public void delete(TokoBuku tokobuku) {
         Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(tokobuku);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.print("Tidak dapat menghapus buku");
            session.getTransaction().rollback();
        } finally {
            session.close();
    }
    }

    @Override
    public void update(TokoBuku tokobuku) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(tokobuku);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.print("Tidak dapat mengubah buku");
            session.getTransaction().rollback();
        } finally {
            session.close();
    }
    }

    @Override
    public TokoBuku get(String kd_buku) {
         Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            TokoBuku tokobuku = (TokoBuku) session.get(TokoBuku.class, kd_buku);
            session.getTransaction().commit();
            return tokobuku;
        } catch (Exception e) {
            System.err.print("Tidak dapat menampilkan buku");
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
    }
    }

    @Override
    public List<TokoBuku> getList() {
         Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            List<TokoBuku> listbuku = session.createCriteria(TokoBuku.class).list();
            session.getTransaction().commit();
            return listbuku;
        } catch (Exception e) {
            System.err.print("List Buku Tidak ada");
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
    }
    }
    
}
