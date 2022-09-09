package com.carrental;

import com.carrental.dao.CarDao;
import com.carrental.dao.RentDao;
import com.carrental.entities.Car;
import com.carrental.entities.Rent;
import com.carrental.entities.User;
import com.carrental.dao.UserDao;

import java.util.List;

public class App {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        CarDao carDao = new CarDao();
        // RentDao rentDao = new RentDao();

        User user = new User("Ramesh", "Fadatare", "1997-05-11");
        userDao.saveUser(user);

        Car car = new Car("EW060YE", "Mercedes", "Classe A", "2015", "Berline", "5");
        carDao.saveCar(car);



        List < User > users = userDao.getUsers();
        List <Car> cars = carDao.getCars();
        // perchè?
        // List <Rent> rents = rentDao.getRents();
        users.forEach(u -> System.out.println(user));
        cars.forEach(s -> System.out.println(car));
    }
}
