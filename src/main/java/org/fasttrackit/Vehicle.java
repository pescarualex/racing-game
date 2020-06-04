package org.fasttrackit;

public class Vehicle {

    String make;
    String model;
    String color;
    double mileage;
    double fuelLevel;
    double maxSpeed;
    double totalTraveledDistance;
    boolean damaged;

    public double accelerate ( double speed, double durationInHour) {
        // EX: Dacia is accelerating with 60km/h for one hour
        System.out.println(make + " is accelerating with " + speed + " km/h for " + durationInHour + " h.");
        double distance = speed * durationInHour;
        totalTraveledDistance += distance;
        System.out.println("Total travel distance: " + totalTraveledDistance);

        // calculate used fuel
        double usedFuel = distance * mileage / 100;
        fuelLevel -= usedFuel;
        System.out.println("Remaining fuel: " + fuelLevel);
        return  distance;
    }
    // metoda care nu returneaza nimic
    public void makeSound() {
        System.out.println("make way");
    }

}
