package com.carrental.dao;

import com.carrental.entities.Booking;
import com.carrental.entities.Car;
import com.carrental.entities.User;
import com.carrental.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BookingDao {
    public void saveBooking(Booking booking) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.save(booking);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void updateBooking(Booking booking) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.update(booking);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void deleteBooking(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            Booking booking = session.get(Booking.class, id);
            if (booking != null) {
                session.delete(booking);
                System.out.println("The reservation has been deleted!");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List <Booking> getBookings() {
        Transaction transaction = null;
        List<Booking> listOfBookings = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfBookings = session.createQuery("FROM Booking").getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfBookings;
    }

    public List<Booking> getBookingsByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Booking.class);
            Criterion getByUser = Restrictions.eq("user", user);
            criteria.add(getByUser);

            List<Booking> bookingsByUser = criteria.list();

            return bookingsByUser;
        }

    }
}