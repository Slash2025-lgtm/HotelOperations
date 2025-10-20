package com.pluralsight;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Room {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            run(keyboard);
        }
    }

    public static void run(Scanner keyboard) {
        displayOptions();
        options(keyboard);
    }

    public static void displayOptions() {
        System.out.println("\n=== Options ===");
        System.out.println("\t[1] Check In");
        System.out.println("\t[2] Check Out");
        System.out.println("\t[3] Clean Room");
    }

    public static void options(Scanner keyboard) {
        try {
            System.out.print("Please Enter a Number: ");
            int selected = keyboard.nextInt();

            switch (selected) {
                case 1:
                    checkIn();
                    break;
                case 2:
                    checkOut();
                    break;
                case 3:
                    cleanRoom();
                    break;
                default:
                    System.out.println("Invalid Number, Please use one of the numbers above");
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkIn() {

    }

    public static void checkOut() {

    }

    public static void cleanRoom() {

    }

    public static HashMap<Integer, Manager> roomCheck() {
        HashMap<Integer, Manager> roomInfo = new HashMap<>();

        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/roomUpdater");
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            FileReader fileReader = new FileReader("src/main/resources/roomUpdater");
            BufferedReader bufReader = new BufferedReader(fileReader);

            bufReader.readLine();
            String input;

            while ((input = bufReader.readLine()) != null) {
                String[] infoList = input.split("[|]");
                

            }

        } catch (IOException e) {
            System.out.println("Error when trying to load data");
        }
        return roomInfo;
    }
}
