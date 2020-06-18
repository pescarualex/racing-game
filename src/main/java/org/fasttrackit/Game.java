package org.fasttrackit;

import java.util.Scanner;

public class Game {

    private Track[] tracks = new Track[3];



    public  void start(){
        System.out.println("Welcome to the racing game!");

       int playerCount = getPlayerCountFromUsers();
        System.out.println("Pleyer count : " + playerCount);

        initializeTraks();
    }




    private int getPlayerCountFromUsers(){
        System.out.println("Please enter number of players: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

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
