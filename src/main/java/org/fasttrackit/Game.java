package org.fasttrackit;

import java.util.Scanner;

public class Game {

    public  void start(){
        System.out.println("Welcome to the racing game!");

       int playerCount = getPlayerCountFromUsers();
        System.out.println("Pleyer count : " + playerCount);
    }

    private int getPlayerCountFromUsers(){
        System.out.println("Please enter number of players: ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        return scanner.nextInt();

    }
}
