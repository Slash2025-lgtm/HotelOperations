package com.pluralsight;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);
    public static Reservation r = new Reservation("King", 5, false);
    public static Room room = new Room(2, false, false, r.getPrice());
    public static Employee employee = new Employee(1111, "Jack", "Front Desk", 12.50, 25);
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
                punchedSimulation();
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

    public static void punchedSimulation() {
        System.out.println("\n=== Your Data ===");
        System.out.println("Please enter you punch in time (Ex. 12.30 -> 12:30)");
        double time = keyboard.nextDouble();
        keyboard.nextLine();

        String timeOfDay = "";
        boolean timeFound = false;
        while (timeFound == false) {
                System.out.println("Please Enter am or pm below");
                timeOfDay = keyboard.nextLine().trim();
                if (timeOfDay.equalsIgnoreCase("AM") || timeOfDay.equalsIgnoreCase("PM")) {
                    timeFound = true;
                }
        }

        String newPunchInTime = String.valueOf(employee.punchIn(time));
        System.out.println(newPunchInTime + timeOfDay.toUpperCase());
    }

}