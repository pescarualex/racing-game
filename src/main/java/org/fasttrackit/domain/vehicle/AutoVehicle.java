package org.fasttrackit.domain.vehicle;

public class AutoVehicle extends Vehicle {

    //"has-a" relationship (Aggregation)
    private Engine engine;

    //constructor

    public AutoVehicle(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
