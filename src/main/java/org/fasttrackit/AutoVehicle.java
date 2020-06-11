package org.fasttrackit;

public class AutoVehicle extends Vehicle {

    //"has-a" relationship (Aggregation)
    Engine engine;

    //constructor

    public AutoVehicle(Engine engine) {
        this.engine = engine;
    }
}
