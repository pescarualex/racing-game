package org.fasttrackit.controller;

import org.fasttrackit.controller.utils.ScannerUtils;

public class StandardInputController {

    public int getPlayerCountFromUsers() {
        System.out.println("Please enter number of players: ");

        return ScannerUtils.readNextSingleInt();

    }

    public int getTrackNumberFromUser() {
        System.out.println("Please select a track: ");

        return ScannerUtils.readNextSingleInt();

    }

    public String getVehicleMakeFromUser() {
        System.out.println("Please enter vehicle make: ");

        return ScannerUtils.SCANNER.nextLine();

    }

    public double getAccelerationSpeedFromUser() {
        System.out.println("Please enter acceleration speed: ");

        return ScannerUtils.readNextSingleDouble();
    }


}
