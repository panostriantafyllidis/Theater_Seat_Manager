package com.Byron.seatmanager;

import java.util.Scanner;

public class TheaterDEMO {

    //Variables outside Main are GLOBAL
    private static Theater theater = new Theater("Acropolis", 10, 12);

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;
        int choice=0;

        do {
            showMenu();
            String response = in.nextLine();
            if (response.matches("\\d")) {
                choice = Integer.parseInt(response);
            } else {
                System.out.println("ERROR: Possibly wrong choice provided");
            }

            switch (choice) {

                case 1:
                    manageReservation();
                    break;
                case 2:
                    manageCancellation();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Please make a choice from 1 to 3");
                    break;
            }

        } while (!exit);

        System.out.println("Goodbye!");

    }

    public static void manageReservation() {
        try {
            System.out.println("Provide seat number");
            String response = in.nextLine();

            System.out.printf("%sSuccessful seat reservation\n", theater.reserveSeat(response) ? "" : "Un");
        } catch (IsReservedException e){
            System.out.println("The selected seat is already reserved");
        } finally {
            theater.printSeats();
        }
    }

    public static void manageCancellation() {
        try {
            System.out.println("Provide seat number");
            String response = in.nextLine();

            System.out.printf("%sSuccessful seat cancellation \n", theater.cancelReservation(response) ? "" : "Un");
        } catch (IsNotReservedException e){
            System.out.println("The selected seat is already Not reserved");
        } finally {
            theater.printSeats();
        }
    }

    public static void showMenu() {
        System.out.println("Choose from the following: ");
        System.out.println("1. Seat reservation");
        System.out.println("2. Seat cancellation");
        System.out.println("3. Exit");

    }
}
