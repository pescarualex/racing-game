package org.fasttrackit;

public class Vehicle {

    // class variable / static variable
    static int totalVehicleCount;



   // instance variable
    String make;
    String model;
    String color;
    double mileage;
    double fuelLevel;
    double maxSpeed;
    double totalTraveledDistance;
    boolean damaged;

    public Vehicle() {
        totalVehicleCount++;
    }

    public double accelerate (double speed, double durationInHour) {



        if (speed > maxSpeed) {
            System.out.println("Max speed exeeded");
            return 0;
        }
//        } else if (speed == maxSpeed){
//            System.out.println("carefull Max speed reached!");
//        }
            else {
            System.out.println("Valid speed entered.");
        }

        if (damaged){
                System.out.println("The vehicle is damaged, you cannot accelerate.");
                return  0;
            }

        // EX: Dacia is accelerating with 60km/h for one hour
        System.out.println(make + " is accelerating with " + speed + " km/h for " + durationInHour + " h.");

        // distance is a local variable
        double distance = speed * durationInHour;
        totalTraveledDistance += distance;
        System.out.println("Total travel distance: " + totalTraveledDistance);

        //use more fuel if speed > 120 km/
        double mileageMultiplier = 1;
        if (speed > 120) {
            mileageMultiplier = speed / 100;
        }

        // calculate used fuel
        double usedFuel = distance * mileage / 100;

        usedFuel*= mileageMultiplier;

        fuelLevel -= usedFuel;
        System.out.println("Remaining fuel: " + fuelLevel);
        return  distance;
    }

    // metoda care nu returneaza nimic
    public void makeSound() {
        System.out.println("make way");
    }





}
