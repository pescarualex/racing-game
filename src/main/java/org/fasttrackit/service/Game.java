package org.fasttrackit.service;

import org.fasttrackit.controller.StandardInputController;
import org.fasttrackit.domain.Mobile;
import org.fasttrackit.domain.Track;
import org.fasttrackit.domain.vehicle.Car;
import org.fasttrackit.domain.vehicle.Vehicle;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private Track[] tracks = new Track[3];
    private List<Mobile> competitors = new ArrayList<>();

    private StandardInputController controller = new StandardInputController();

    public  void start(){
        System.out.println("Welcome to the racing game!");

        initializeTraks();

        Track selectedTrack = getSelectedTrack();
        System.out.println("You have selected; " + selectedTrack.getName());

        initializeCompetitors();

        playOneRound();

    }

    private void initializeCompetitors() {
        int playerCount = controller.getPlayerCountFromUsers();

        for (int i = 1; i <= playerCount; i++) {
            System.out.println("Preparing player " + i + " for the race.");

            Vehicle vehicle = new Car();
            vehicle.setMake(controller.getVehicleMakeFromUser());
            vehicle.setFuelLevel(30);
            vehicle.setMaxSpeed(300);
            vehicle.setMileage(ThreadLocalRandom.current().nextDouble(9,15));

            competitors.add(vehicle);

        }
    }

    private void playOneRound() {
        System.out.println("New round");


        // enhanced for or for-each
        for (Mobile competitor : competitors) {
            double speed =  controller.getAccelerationSpeedFromUser();
            competitor.accelerate(speed,1);
        }
    }

    private Track getSelectedTrack() {
        int optionNumber = controller.getTrackNumberFromUser();
        return tracks[optionNumber - 1];
    }



    private void initializeTraks() {
        Track track1 = new Track();
        track1.setName("Street Circuit");
        track1.setLenght(300);

        tracks[0] = track1;

        Track track2 = new Track();
        track2.setName("Forest Circuit");
        track2.setLenght(100);

        tracks[1] = track2;

        displayTraks();
    }

    private void displayTraks() {
        System.out.println("Available traks: ");

        for (int i = 0; i < tracks.length; i++) {
            if (tracks[i] != null) {
                System.out.println(i + 1 + ". " + tracks[i].getName() + ": " + tracks[i].getLenght() + " km");
            }
        }
    }
}
