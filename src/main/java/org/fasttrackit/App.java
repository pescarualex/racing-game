package org.fasttrackit;


public class App {
    public static void main( String[] args ){
        System.out.println("Welcome to the racing game!");

        Car carReference = new Car();
        carReference.make = "Skoda";
        carReference.model = "Fabia";
        carReference.mileage = 7.5;
        carReference.fuelLevel = 60;
        carReference.color = "red";
        carReference.maxSpeed = 300;

        carReference.engine = new Engine();
        carReference.engine.manufacturer = "VW";
        carReference.engine.capacity = 1900;

        Car car2 = new Car();
        car2.make = "Mercedes";
        car2.model = "CLS";
        car2.color = "black";




    }
}
