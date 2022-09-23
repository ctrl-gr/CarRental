package com.carrental.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "type")
    private String type;

    @Column(name = "seats")
    private int seats;

    public Car() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getLicensePlate() {

        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {

        this.licensePlate = licensePlate;
    }

    public String getManufacturer() {

        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {

        this.manufacturer = manufacturer;
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {

        this.model = model;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public int getSeats() {

        return seats;
    }

    public void setSeats(int seats) {

        this.seats = seats;
    }


    public Car(String licensePlate, String manufacturer, String model, int year, String type, int seats) {
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.type = type;
        this.seats = seats;
    }
    public Car(int id, String licensePlate, String manufacturer, String model, int year, String type, int seats) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.type = type;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", Targa =" + licensePlate + ", Casa costruttrice =" + manufacturer + ", Modello =" + model + ", Tipologia =" + type + ", Numero dei posti =" + seats + " ]";
    }

}


