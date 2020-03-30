package com.company;

/**
 * FleetDemo.java
 *
 * A class that illustrates concepts related to polymorphism.
 *
 * Starter code from Computer Science 111, Boston University
 *
 * Modified by Laura K. Gross, COMP 152, Bridgewater State University
 *
 * Completed by: [student name], [student email]
 * date: [date of completion]
 */
public class FleetDemo {

    public static final int CURRENT_YEAR = 2020;

    public static void main(String[] args) {

        /* Polymorphism is useful when we have a collection of objects of
         * different but related types.
         */

        // Consider an array of objects of different but related types.
        Vehicle[] fleet = new Vehicle[4];
        /* Remember all elements in an array in Java must have the same declared type.
         * Here all elements of the array are of declared type Vehicle.
         * Each element has a different "declared type" vs. "actual type."
         * Declared type is specified when declaring a variable.
         * Actualtype is specified when creating an object.
         */
        fleet[0] = new Automobile("Honda", "Civic", 2016);
        fleet[1] = new Motorcycle("Harley", "Roadster", 2017);
        fleet[2] = new TractorTrailer("Mack", "Pinnacle DayCab", 2018, 10);
        fleet[3] = new Taxi("Toyota", "Highlander Hybrid", 2016,
                8, true, "A12345");

        for (int i = 0; i < fleet.length; i++) {
            // Implicitly call the toString method on the ith element of the fleet.
            System.out.println(fleet[i]);
            /*
             * We can do this because the declared type of each element is Vehicle, and
             * Vehicle has a toString method.
             *
             * At runtime, the Java *interpreter* selects the version of toString
             * that is appropriate to the *actual type* of the object---
             * either from the class of the declared type Vehicle
             * or from the class of the actual type in which toString is overridden.
             * This is known as dynamic binding.
             * This can be done by the JVM not by the compiler.
             */

            /*
             * System.out.println(fleet[0]); will invoke the Automobile version toString().
             * System.out.println(fleet[1]); will invoke the Vehicle version of the toString() method,
             * which is inherited by Motorcycle.  (Motorcycle does not define its own toString() method.)
             * System.out.println(fleet[2]); will invoke the TractorTrailer version of the toString() method.
             * System.out.println(fleet[3]); will invoke the Taxi version of the toString() method.
             */
        }

        System.out.println();
        averageAge(fleet);
        System.out.println();

        /*
         * Why doesn't this work?
         */
        // System.out.println(fleet[2].getNumAxles());

        /* The declared type of fleet[2] is Vehicle.
         * there's no getNumAxles() method defined in or inherited by Vehicle.
         */

        /*
         * We can use casting to create a reference with the necessary declared type:
         */
        Truck truck1 = (Truck) fleet[2];
        /*
         * The declared type of truck1 is Truck.
         * There is a getNumAxles() method defined in Truck.
         * So now we don't get an error.
         *
         * Which version of getNumAxles() will be invoked?
         */
        System.out.println("Number of axles on " + truck1.toString() + ":");
        System.out.println(truck1.getNumAxles());
        System.out.println();

        // Will this work?
        // TractorTrailer big = (TractorTrailer) fleet[2];
        // System.out.println(big.getNumAxles());

        /*
         * The Object class is a superclass of every other class.
         * Thus, we can use an Object variable to store a reference to any object.
         */
        Object obj1 = new Taxi("Ford", "Tempo", 2000, 4, false, "T47783");
        // Which toString method will be called?
        // System.out.println(obj1);

        // Which methods are executed when the following code is executed?

        Truck t1 = new Truck("Mack", "Pinnacle Day Cab", 2016, 10);
        Truck t2 = new TractorTrailer("Mack", "Pinnacle Day Cab", 2016, 10);
        // System.out.println(t1.getNumAxles());
        // System.out.println(t2.getNumAxles());
    }

    /*
     * A method to determine the average age of the vehicles in the fleet
     */
    public static void averageAge(Vehicle[] vehicleArray) {
        int totalAge = 0;
        for (int i = 0; i < vehicleArray.length; i++) {
            // Every subclass inherits the getYear method from the Vehicle class.
            int age = CURRENT_YEAR - vehicleArray[i].getYear();
            totalAge += age;
            /*
             * Note: At runtime, the Java *interpreter* selects the version of a method
             * that is appropriate to the *actual type* of the object.
             * This is known as dynamic binding.
             * This can be done by the JVM not by the compiler.
             */
        }
        System.out.println("Average fleet age: " + (double) totalAge / vehicleArray.length);
    }

}

