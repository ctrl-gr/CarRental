package com.carrental.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId")
    private int id;

    @Column(name = "Plate")
    private String plate;

    @Column(name = "Manufacturer")
    private String manufacturer;

    @Column(name = "Model")
    private String model;

    @Column(name = "RegistrationYear")
    private String year;

    @Column(name = "Type")
    private String type;

    @Column(name = "Seats")
    private String seats;

    @OneToMany(cascade = { CascadeType.ALL })
    private List<User> users = new ArrayList<User>();

    public Car() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getPlate() {

        return plate;
    }

    public void setPlate(String plate) {

        this.plate = plate;
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

    public String getYear() {

        return year;
    }

    public void setYear(String year) {

        this.year = year;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getSeats() {

        return seats;
    }

    public void setSeats(String seats) {

        this.seats = seats;
    }

    public Car(String plate, String manufacturer, String model, String year, String type, String seats) {
        this.plate = plate;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.type = type;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", Targa =" + plate + ", Casa costruttrice =" + manufacturer + ", Modello =" + model + ", Tipologia =" + type + ", Numero dei posti =" + seats + " ]";
    }

}


