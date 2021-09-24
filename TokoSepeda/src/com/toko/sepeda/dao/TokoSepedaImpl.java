
package com.toko.sepeda.dao;

import com.toko.sepeda.model.TokoSepeda;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class TokoSepedaImpl implements TokoSepedaDao  {
    private final SessionFactory sessionFactory;
    public TokoSepedaImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void save(TokoSepeda tokosepeda) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(tokosepeda);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.print("Tidak dapat menyimpan sepeda");
            session.getTransaction().rollback();
        } finally {
            session.close();
    }
    }

    @Override
    public void delete(TokoSepeda tokosepeda) {
         Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(tokosepeda);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.print("Tidak dapat menghapus sepeda");
            session.getTransaction().rollback();
        } finally {
            session.close();
    }
    }

    @Override
    public void update(TokoSepeda tokosepeda) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(tokosepeda);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.print("Tidak dapat mengubah sepeda");
            session.getTransaction().rollback();
        } finally {
            session.close();
    }
    }

    @Override
    public TokoSepeda get(String kd_sepeda) {
         Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            TokoSepeda tokosepeda = (TokoSepeda) session.get(TokoSepeda.class, kd_sepeda);
            session.getTransaction().commit();
            return tokosepeda;
        } catch (Exception e) {
            System.err.print("Tidak dapat menampilkan sepeda");
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
    }
    }

    @Override
    public List<TokoSepeda> getList() {
         Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            List<TokoSepeda> listsepeda = session.createCriteria(TokoSepeda.class).list();
            session.getTransaction().commit();
            return listsepeda;
        } catch (Exception e) {
            System.err.print("List Sepeda Tidak ada");
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
    }
    }
    
}
