package org.fasttrackit.controller;

import java.util.Scanner;

public class StandardInputController {

    public int getPlayerCountFromUsers(){
        System.out.println("Please enter number of players: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }



}
