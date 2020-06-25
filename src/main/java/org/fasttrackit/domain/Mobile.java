package org.fasttrackit.domain;

public interface Mobile {

    double accelerate(double speed, double durationInHour);

    String getName();

    boolean canMove();

    double getTotalTraveledDistance();

}
