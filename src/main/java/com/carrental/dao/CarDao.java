package com.carrental.dao;

import com.carrental.entities.Car;
import com.carrental.entities.User;
import com.carrental.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CarDao {
    public void saveCar(Car car) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List < Car > getCars() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Car", Car.class).list();
        }
    }
}