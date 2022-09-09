package com.carrental.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
    @Table(name = "user")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "userId")
        private int id;

        @Column(name = "Name")
        private String firstName;

        @Column(name = "LastName")
        private String lastName;

        @Column(name = "BirthDate")
        private String birthDate;

        @OneToMany(cascade = {
                CascadeType.ALL
        })
       private List<Car> cars = new ArrayList<Car>();

    public User() {

        }

        public User(String firstName, String lastName, String birthDate) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getBirthDate() {

            return birthDate;
        }

        public void setBirthDate(String birthDate) {

            this.birthDate = birthDate;
        }

        @Override
        public String toString() {
            return "User [id=" + id + ", Nome=" + firstName + ", Cognome=" + lastName + ", DataDiNascita=" + birthDate + "]";
        }
    }

