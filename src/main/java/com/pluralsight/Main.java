package com.pluralsight;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);
    public static Reservation r = new Reservation("King", 5, false);
    public static Room room = new Room(2, false, false, r.getPrice());

    public static void main(String[] args) {
        while (true) {
            run();
        }
    }

    public static void run() {
        System.out.println("\nSelect one of the following");
        System.out.println("\t[1] Run a Check in and out simulation");
        System.out.println("\t[2] Employee Punch in and out simulation");
        System.out.print("Please Enter one of the following numbers: ");
        String selected = keyboard.nextLine();

        switch (selected) {
            case "1":
                checkedSimulation();
                break;
            case "2":

                break;
            default:
                System.out.println("\nERROR: Typed Character either is not a number or the wrong number");
        }
    }

    public static void checkedSimulation() {
        System.out.println("=== Checking Rooms ===");
        checked(r.getRoomType(), room.getNumberOfBeds(), room.isOccupied(), room.isDirty(), r.getPrice());

        System.out.println("\n=== Checked In ===");
        room.checkIn();
        checked(r.getRoomType(), room.getNumberOfBeds(), room.isOccupied(), room.isDirty(), r.getPrice());

        System.out.println("\n=== Checked Out ===");
        room.checkOut();
        checked(r.getRoomType(), room.getNumberOfBeds(), room.isOccupied(), room.isDirty(), r.getPrice());

        System.out.println("\n=== Clean Room ===");
        room.cleanRoom();
        checked(r.getRoomType(), room.getNumberOfBeds(), room.isOccupied(), room.isDirty(), r.getPrice());
    }

    public static void checked(String roomType, int beds, boolean occupied, boolean dirty, double price) {
        System.out.println("\tRoom Type: " + roomType);
        System.out.println("\tBeds: " + beds);
        System.out.println("\tOccupied: " + occupied);
        System.out.println("\tDirty: " + dirty);
        System.out.println("\tPrice: $" + price);
    }
}