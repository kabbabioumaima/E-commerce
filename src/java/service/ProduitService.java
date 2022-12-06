/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Categorie;
import entities.Marque;
import entities.Produit;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class ProduitService implements IDao<Produit>{

    @Override
    public boolean create(Produit o) {
         Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Produit findById(int id) {
         Produit produit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit = (Produit) session.get(Produit.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return produit;

    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from Produit").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return produits;
    }
       
        public List<Produit> findBetweenPrix(int d1, int d2) {
        Session s = null;
        Transaction tx = null;
        List<Produit> produits = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            tx = s.beginTransaction();
            produits = ((List<Produit>) s.createQuery("select p from Produit p where p.prix between :d1 and :d2 ").setParameter("d1", d1).setParameter("d2", d2).list());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        return produits;

    }
      
 public List<Produit> getByMarque(Marque marque) {
        Session s = null;
        Transaction tx = null;
        List<Produit> produits = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            tx = s.beginTransaction();
            produits = ((List<Produit>) s.createQuery("select p from Produit p where p.marque = :marque ").setParameter("marque", marque).list());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        return produits;

    }
 public List<Produit> getByCategorie(Categorie categorie) {
        Session s = null;
        Transaction tx = null;
        List<Produit> produits = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            tx = s.beginTransaction();
           produits = ((List<Produit>) s.createQuery("select p from Produit p where p.categorie = :categorie ").setParameter("categorie", categorie).list());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        return produits;

    }
}
