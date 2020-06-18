package org.fasttrackit.cheater;

import org.fasttrackit.Vehicle;

public class CheatingVehicle extends Vehicle {

    // constant variable
   public static final String TYPE = "Cheater";

    @Override
    public double accelerate(double speed, double durationInHour) {
        System.out.println(getMake() + " is accelerating with " + speed + " km/h for " + durationInHour + " h.");
        System.out.println("Cheating...");

        double distance = speed * durationInHour * 2;
        totalTraveledDistance += distance;
        return distance;

    }

    public void cheat(){
        totalTraveledDistance *= 2;
    }
}
