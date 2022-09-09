package com.carrental.entities;

import javax.persistence.*;

@Entity
@Table(name = "rent")

public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentId")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name="userId", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name="carId", insertable = false, updatable = false)
    private Car car;

    @Column(name = "StartDate")
    private String startDate;

    @Column(name = "EndDate")
    private String endDate;

    @Column(name = "isApproved")
    private boolean isApproved;

    public Rent() {

    }

    public Rent(User user, Car car, String startDate, String endDate, boolean isApproved){
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isApproved = isApproved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getAuto() {
        return car;
    }

    public void setAuto(Car car) {
        this.car = car;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    @Override
    public String toString() {
        return "Rent [id=" + id + ", Data di inizio =" + startDate + ", Data di fine =" + endDate + ", Approvato =" + isApproved + "]";
    }

}
