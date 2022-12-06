/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Detail;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class DetailService implements IDao<Detail>{

    @Override
    public boolean create(Detail o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Detail o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Detail o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detail findById(int id) {
         Detail detail = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            detail = (Detail) session.get(Detail.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return detail;}

    @Override
    public List<Detail> findAll() {
        List<Detail> details = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            details = session.createQuery("from Detail").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return details;}
    
}
