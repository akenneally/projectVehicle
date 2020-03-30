package com.company;

/**
 * VehicleDemo.java
 *
 * A class that illustrates concepts related to inheritance and polymorphism.
 *
 * Starter code from Computer Science 111, Boston University
 *
 * Modified by Laura K. Gross, COMP 152, Bridgewater State University
 *
 * Completed by: [student name], [student email]
 *          date: [date of completion]
 */
public class VehicleDemo {

    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("Panasonic", "B123", 1982, 2);
        System.out.print(v1.toString());
        System.out.println();

        // Call the Automobile constructor with three parameters.
        Automobile car1 = new Automobile("Toyota", "Prius", 2017);

        // Call the toString method from the Automobile class implicitly.
        System.out.println("Car 1: " + car1.toString());
        System.out.println();

        // Call the Taxi constructor from the Taxi class.
        Taxi taxi1 = new Taxi("Toyota", "Highlander Hybrid", 2016,
                8, true, "A12345");

        System.out.println("Taxi 1 fareTotal: " + taxi1.getFareTotal());
        System.out.println("Taxi 1 number of fares: " + taxi1.getNumFares());
        System.out.println();

        // First fare of the day is $23.
        taxi1.addFare(23.0);
        System.out.println("Taxi 1 fareTotal: " + taxi1.getFareTotal());
        System.out.println("Taxi 1 number of fares: " + taxi1.getNumFares());
        System.out.print("Taxi 1 average fare: " + "$");
        // Continue printing on same line;
        // Format amount with two decimal digits:
        System.out.printf("%.2f", taxi1.getAverageFare());
        // Go to next line:
        System.out.println();
        // Skip a line:
        System.out.println();

        // Next fare of the day is $11.
        taxi1.addFare(11.0);

        System.out.print("Taxi 1 average fare: " + "$");
        // Continue printing on same line;
        // Format amount with two decimal digits:
        System.out.printf("%.2f", taxi1.getAverageFare());
        // Go to next line:
        System.out.println();
        // Skip a line:
        System.out.println();

        // Next fare of the day has a typo.
        // taxi1.addFare(-24.00);

        // Reset fare info after Day 1.
        System.out.println("Resetting fare information to 0");
        taxi1.resetFareInfo();
        System.out.println("Taxi 1 fareTotal: " + taxi1.getFareTotal());
        System.out.println("Taxi 1 new average fare: " + taxi1.getAverageFare());
        System.out.println();

        // Taxi objects can call the methods inherited from the Automobile class.
        taxi1.setMileage(12302);
        System.out.println("Mileage for taxi 1 is " + taxi1.getMileage());
        System.out.println();

        System.out.println("Taxi 1: " + taxi1.toString());
        System.out.println();
    }
}

