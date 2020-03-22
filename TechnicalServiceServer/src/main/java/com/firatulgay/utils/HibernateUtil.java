package com.firatulgay.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try{

            Configuration cfg = new Configuration();
            File file = new File("C:\\Users\\FiratUlgay\\Desktop\\UNIVERSAL EĞİTİM PROJELERİ\\RestServiceUygulamasi\\WebTechnicalService\\src\\resources\\hibernate.cfg.xml");
            SessionFactory sessionFactory = cfg.configure(file).buildSessionFactory();
            return sessionFactory;

        } catch (Exception e){
            System.out.println("Session factory oluşturulurken hata oluştu" + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}