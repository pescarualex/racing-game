package org.fasttrackit.service;

import org.fasttrackit.controller.StandardInputController;
import org.fasttrackit.domain.Hulk;
import org.fasttrackit.domain.Mobile;
import org.fasttrackit.domain.MobileComparater;
import org.fasttrackit.domain.Track;
import org.fasttrackit.domain.vehicle.Car;
import org.fasttrackit.domain.vehicle.Vehicle;
import org.fasttrackit.domain.vehicle.cheater.CheatingVehicle;
import org.fasttrackit.exception.InvalidOptionSelectedException;
import org.fasttrackit.persistence.FileRankingRepository;
import org.fasttrackit.persistence.RankingRepository;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private Track[] tracks = new Track[3];
    private Track selectedTrack;
    private List<Mobile> competitors = new ArrayList<>();
    private Set<Mobile> outOfRaceCompetitors = new HashSet<>();

    private boolean winnerNotKnown = true;

    private StandardInputController controller = new StandardInputController();
    private RankingRepository rankingRepository = new FileRankingRepository();

    public  void start() throws InvalidOptionSelectedException {
        System.out.println("Welcome to the racing game!");

        initializeTraks();

        selectedTrack = getSelectedTrack();

        initializeCompetitors();

        while (winnerNotKnown && outOfRaceCompetitors.size() < competitors.size()) {
            playOneRound();
        }

        if (winnerNotKnown) {
            System.out.println("Game over. There's no winner");
        }

        processRankingTable();

    }


    private void processRankingTable() {
        competitors.sort(Collections.reverseOrder(new MobileComparater()));

        System.out.println("Rankings: ");

        try {
            for (int i = 0; i < competitors.size(); i++) {
                System.out.println(
                        i + 1 + ". " + competitors.get(i).getName() + ": " + competitors.get(i).getTotalTraveledDistance());

                rankingRepository.addRankingItem(
                        i + 1, competitors.get(i).getName(), competitors.get(i).getTotalTraveledDistance());
            }
        } finally {
            rankingRepository.close();
        }

    }

    private void initializeCompetitors() {
        int playerCount = controller.getPlayerCountFromUsers();

        for (int i = 1; i <= playerCount; i++) {
            System.out.println("Preparing player " + i + " for the race.");

            createCompatitor();

        }
    }

    private void displayCompetitorTipes() {
        System.out.println("Please choose how you want to enter the race: ");
        System.out.println("1.Using the car");
        System.out.println("2.I feel luky, I'll try Hulk");
    }
    private void createCompatitor() {
        displayCompetitorTipes();

        int competitorType = controller.getCompetitorTypeFromUser();

        switch (competitorType) {
            case 0:
                CheatingVehicle mobile = new CheatingVehicle();
                mobile.setMake(controller.getVehicleMakeFromUser());
                mobile.setFuelLevel(30);
                mobile.setMaxSpeed(300);
                mobile.setMileage(ThreadLocalRandom.current().nextDouble(9,15));

                competitors.add(mobile);
                break;

            case 1:
                Car car = new Car();
                car.setMake(controller.getVehicleMakeFromUser());
                car.setFuelLevel(30);
                car.setMaxSpeed(300);
                car.setMileage(ThreadLocalRandom.current().nextDouble(9,15));

                competitors.add(car);
                break;
            case 2:
                Hulk hulk = new Hulk();
                competitors.add(hulk);
                break;
            default:
                System.out.println("Invalid value entered");
                createCompatitor();
                break;
        }
    }

    private void playOneRound() {
        System.out.println();
        System.out.println("New round");
        System.out.println();


        // enhanced for or for-each
        for (Mobile competitor : competitors) {
            if (!competitor.canMove()) {
                outOfRaceCompetitors.add(competitor);
                continue;
            }
            System.out.println();
            double speed =  controller.getAccelerationSpeedFromUser();
            competitor.accelerate(speed,1);

            if (competitor.getTotalTraveledDistance() >= selectedTrack.getLenght()) {
                System.out.println("Congratz! The winner is: " + competitor.getName());
                winnerNotKnown = false;
                break;
            }
        }
    }

    private Track getSelectedTrack() throws InvalidOptionSelectedException {
        try {
            int optionNumber = controller.getTrackNumberFromUser();
            return tracks[optionNumber - 1];
        } catch (InputMismatchException e) {
            throw new RuntimeException("Invalid track number entered.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidOptionSelectedException();
        }
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
