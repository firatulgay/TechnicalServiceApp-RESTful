package com.firatulgay.dao;

import com.firatulgay.Domain.Login;
import com.firatulgay.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class LoginDao {

    public Login findLoginByAdiSifre(String adi, String sifre) {
        Login login = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select login From Login where login.adi = :adi and login.sifre = :sifre ";
            Query query = session.createQuery(hql);
            query.setParameter("adi", adi);
            query.setParameter("sifre", sifre);

            login = (Login) query.uniqueResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return login;
    }
}
