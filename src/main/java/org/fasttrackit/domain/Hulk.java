package org.fasttrackit.domain;

import java.util.concurrent.ThreadLocalRandom;

public class Hulk implements Mobile {

    private double totalTraveledDistance;

    private final int rondomizer = ThreadLocalRandom.current().nextInt(1,101);


    @Override
    public double accelerate(double speed, double durationInHour) {
        if (!canMove()) {
            System.out.println("I won't help you..");
            return 0;
        }

        double distance = speed * durationInHour;

        totalTraveledDistance += distance;

        return distance;
    }

    @Override
    public String getName() {
        return "Hulk";
    }

    @Override
    public boolean canMove() {
        return rondomizer <= 20;
    }

    @Override
    public double getTotalTraveledDistance() {
        return totalTraveledDistance;
    }
}
