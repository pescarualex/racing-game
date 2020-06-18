package org.fasttrackit;


import org.fasttrackit.cheater.CheatingVehicle;

public class App {
    public static void main( String[] args ){
        Game game = new Game();
        game.start();

//        //polymorphism
//        Vehicle vehicle = new CheatingVehicle();
//        vehicle.setMake("Cheating vehicle");
//
//        // object type determines method implementation
//        vehicle.accelerate(60, 1);
//
//        System.out.println("Accelarate with one param");
//        vehicle.accelerate(60);
//
//
//        // variable type detremines what methods can be invoked
//
//        // type casting
//        if (vehicle instanceof CheatingVehicle) {
//            ((CheatingVehicle) vehicle).cheat();
//        }




//        Vehicle vehicle1 = new Vehicle();
//        vehicle1.totalVehicleCount = 1;
//
//        Vehicle vehicle2 = new Vehicle();
//        vehicle2.totalVehicleCount = 4;
//
//        System.out.println("Total count from vehicle1: " + vehicle1.totalVehicleCount);
//        System.out.println("Total count from vehicle1: " + vehicle2.totalVehicleCount);
//        System.out.println("Total count from vehicle class: " + Vehicle.totalVehicleCount);


//        // creare constructor
//        Engine engine = new Engine();
//        engine.manufacturer = "Renault";
//           // AutoVehicle autoVehicle = new AutoVehicle(engine);
//
//        Car car = new Car(engine);
//        car.make = "Dacia";
//        System.out.println(car.make);


//        System.out.println("Welcome to the racing game!");
//
//        Car carReference = new Car();
//        carReference.make = "Skoda";
//        carReference.model = "Fabia";
//        carReference.mileage = 7.5;
//        carReference.fuelLevel = 60;
//        carReference.color = "red";
//        carReference.maxSpeed = 300;
//
//        carReference.engine = new Engine();
//        carReference.engine.manufacturer = "VW";
//        carReference.engine.capacity = 1900;
//
//        Car car2 = new Car();
//        car2.make = "Mercedes";
//        car2.model = "CLS";
//        car2.color = "black";
//
//
//        // Invocarea metodei sau apelarea
//
//        carReference.accelerate(60,1);
//        // stocarea unei metode intr-o variabila:
//        // double currentDistance = carReference.accelerate(60,1);
//
//        System.out.println(carReference.totalTraveledDistance);
//
//        Mechanic mechanic = new Mechanic();
//        mechanic.repair(carReference);
//
//        System.out.println(carReference.totalTraveledDistance);


    }
}
