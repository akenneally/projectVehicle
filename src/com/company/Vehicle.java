package com.company;

/**
 * Vehicle.java
 *
 * A class that represents a vehicle.  It is a superclass of all of the
 * other classes that represent vehicles, such as Automobile.
 *
 * Automobile is a subclass of Vehicle.
 *
 * Subclasses of Vehicle are Automobile, Motorcycle, Truck,
 * and their subclasses.
 *
 * We speak of an "is-a relationship": A Motorcycle is-a Vehicle, etc.
 *
 * We also say Vehicle is a base or parent class of the Automobile class.
 *
 * We also say Automobile is a derived or child class of Vehicle.
 *
 * Fields and methods that all vehicles have in common are defined
 * here.  They are inherited by the subclasses of this class.
 *
 * Starter code from Computer Science 111, Boston University
 *
 * Modified by Laura K. Gross, COMP 152, Bridgewater State University
 *
 * Completed by: [student name], [student email]
 *          date: [date of completion]
 */
 public class Vehicle {
    private String make;
    private String model;
    private int year;
    private int mileage;
    private String plateNumber;
    private int numWheels;

    /*
    A constructor that takes four arguments
    */
    public Vehicle(String mk, String mod, int yr, int numWh) {
        make = mk;
        model = mod;
        if (yr < 1900) {
            throw new IllegalArgumentException();
        }
        year = yr;
        numWheels = numWh;
        mileage = 0;
        plateNumber = "unknown";
    }

    /*** mutators ***/

    public void setMileage(int newMileage) {
        if (newMileage < mileage) {
            throw new IllegalArgumentException();
        }
        mileage = newMileage;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /*** accessors ***/

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getNumWheels(){
        return numWheels;
    }

    /*
     * A method that creates a string that can be used when printing
     * Vehicles.  This method overrides the toString()
     * method inherited from the Object class.
     */
    public String toString() {
        return make + " " + model;
    }
}