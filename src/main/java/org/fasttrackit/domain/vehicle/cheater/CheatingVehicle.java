package org.fasttrackit.domain.vehicle.cheater;

import org.fasttrackit.domain.vehicle.Vehicle;

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

// co-variant return type
// overriding method can be more permissive
    @Override
    protected CheatingVehicle reset() {
        super.reset();
        return this;
    }
}
