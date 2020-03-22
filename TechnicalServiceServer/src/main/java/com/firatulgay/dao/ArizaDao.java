package com.firatulgay.dao;

import com.firatulgay.Domain.Ariza;
import com.firatulgay.Domain.Login;
import com.firatulgay.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ArizaDao {

    public Ariza saveAriza(Ariza ariza) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();

            ariza = (Ariza) session.merge(ariza);

            session.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return ariza;
    }


    public List<Ariza> findAllAriza() {
        List<Ariza> arizaList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select ariza From Ariza ariza";
            Query query = session.createQuery(hql);
            arizaList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return arizaList;
    }

    public Ariza findAllArizaById(Long id) {
        Ariza ariza = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select ariza From Ariza where ariza.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            ariza = (Ariza) query.uniqueResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ariza;
    }
}