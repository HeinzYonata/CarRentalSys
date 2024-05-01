/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsys.domain;

/**
 *
 * @author heinz
 */
public class Car {
    private int id;
    private String model;
    private int year;
    private boolean availability;
    private double rentalFee;

    public Car(int id, String model, int year, boolean status, double rentalFee) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.availability = status;
        this.rentalFee = rentalFee;
    }
    
    public int getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isAvailable() {
        return this.availability;
    }

    public double getRentalFee() {
        return this.rentalFee;
    }
}

