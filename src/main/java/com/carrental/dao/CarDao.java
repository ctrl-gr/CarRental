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
import org.hibernate.metadata.ClassMetadata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.carrental.util.HibernateUtil.getSessionFactory;

public class CarDao {
    public void saveCar(Car car) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {

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


    public List<Car> getAvailableCars(LocalDate startDate, LocalDate endDate) {
        try (Session session = getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Booking.class);
            Criterion start = Restrictions.le("startDate", endDate);
            Criterion end = Restrictions.ge("endDate", startDate);

            criteria.add(Restrictions.and(start, end));


            List<Booking> bookings = criteria.list();
            List<Integer> bookedCars = new ArrayList<>();
            for (Booking booking : bookings) {
                if (booking.getCar() != null && !bookedCars.contains(booking.getCar().getId())) {
                    bookedCars.add(booking.getCar().getId());
                }
            }

            Criteria criteriaCars = session.createCriteria(Car.class);
            if (bookedCars.size() > 0) {
                Criterion notInAnyCars = Restrictions.not(Restrictions.in("id", bookedCars));
                criteriaCars.add(notInAnyCars);
            }

            List<Car> availableCars = criteriaCars.list();

            return availableCars;
        }
    }

    public void updateCar(Car car) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.update(car);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteCar(int id) {

        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            Car car = session.get(Car.class, id);
            if (car != null) {
                session.delete(car);
                System.out.println("The car has been deleted!");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Car getCar(int id) {

        Transaction transaction = null;
        Car car = null;
        try (Session session = getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            car = session.get(Car.class, id);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return car;
    }

    public List<Car> getCars() {
        Transaction transaction = null;
        List<Car> listOfCar = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfCar = session.createQuery("FROM Car").getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfCar;
    }

}