package org.example;

import org.example.controller.GarageController;
import org.example.exception.*;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final GarageController controller = new GarageController();

    public static void main(String[] args) {
        int choice = 0;
        System.out.println("Welcome to the GarageApp!");
        try {
            System.out.printf("Available spots: %d %n%n", controller.getEmptySpotsNumber());
        } catch (GarageFullException e) {
            System.out.println(e.getMessage());
        }

        do {
            printMenu();
            choice = getChoice();
            manageChoice(choice);
        } while (choice > 0 && choice < 6);
    }

    private static void printMenu() {
        System.out.println("Please enter the number corresponding to your choice: \n");
        System.out.println("1. New vehicle enters the garage.");
        System.out.println("2. A vehicle exits the garage.");
        System.out.println("3. Show number of vacant parking spots.");
        System.out.println("4. Show the total earnings.");
        System.out.println("5. Show the details of the staff assigned to a specific vehicle.");
        System.out.println("--- Any other input EXITS the application ---");
    }

    private static int getChoice() {
        int choice;
        String input = sc.nextLine();

        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            choice = 0;
        }
        
        return choice;
    }

    private static void manageChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("--- New vehicle entrance ---");
                entranceHandler();
                break;
            case 2:
                System.out.println("--- Vehicle exit ---");
                exitHandler();
                break;
            case 3:
                System.out.println("--- Empty spots ---");
                showEmptySpotsNumberHandler();
                break;
            case 4:
                System.out.println("--- Total earnings ---");
                showTotalEarningsHandler();
                break;
            case 5:
                System.out.println("--- Staff Details ---");
                showStaffDetailsHandler();
                break;
            default:
                System.out.println("Application exits!");
                break;
        }
    }

    private static void showStaffDetailsHandler() {
        String plateNum;
        String staffDetails;

        System.out.println("Please enter a valid plate number: ");

        plateNum = sc.nextLine().trim();
        try {
           staffDetails = controller.getStaffDetails(plateNum);
            System.out.println(staffDetails);
        } catch (PlateNumNotFoundException | InvalidPlateNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showTotalEarningsHandler() {
        System.out.printf("Total earnings: %.2f€ %n", controller.getTotalMoneyEarned());
        System.out.println("------------------------------");
    }

    private static void showEmptySpotsNumberHandler() {
        int spots;

        try {
           spots = controller.getEmptySpotsNumber();
            System.out.printf("Empty spots: %d %n",spots);
            System.out.println("------------------------------");
        } catch (GarageFullException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void exitHandler() {
        String plateNum;
        Double price;

        System.out.println("Please enter the exiting vehicle's plate number");
        plateNum = sc.nextLine();


        try {
          price = controller.exitsGarage(plateNum);
            System.out.printf("Vehicle with plate number: %s, exits the garage %n", plateNum);
            System.out.println(price == 0 ? "No parking cost" : "Parking cost: " + price + "€");
        } catch (PlateNumNotFoundException | InvalidPlateNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void entranceHandler() {
        String type;
        String plateNum;
        String driverFname;
        String driverLname;
        String staffFname;
        String staffLname;


        do {
            System.out.println("Please choose vehicle's type");
            System.out.println("Enter 0 for Motorcycle or 1 for Car: ");
            type = sc.nextLine();
        } while (!Objects.equals(type, "1") && !Objects.equals(type, "0"));

        System.out.println("Please enter vehicle's plate number: ");
        plateNum = sc.nextLine();

        System.out.println("Please enter driver's firstname: ");
        driverFname = sc.nextLine();
        System.out.println("Please enter driver's lastname: ");
        driverLname = sc.nextLine();

        System.out.println("Please enter staff's firstname: ");
        staffFname = sc.nextLine();
        System.out.println("Please enter staff's lastname: ");
        staffLname = sc.nextLine();

        try {
            controller.entersGarage(type, driverFname, driverLname, staffFname, staffLname, plateNum);
            System.out.printf("%s with plate number: %s, was inserted successfully %n%n", type.equals("1") ? "Car" : "Motorcycle", plateNum);
        } catch (InvalidNameException | InvalidPlateNumberException | PlateNumAlreadyExistsException |
                 GarageFullException e) {
            System.out.println(e.getMessage());
        }

    }
}