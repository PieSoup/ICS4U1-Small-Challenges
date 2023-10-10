package main;

import java.util.Scanner;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		do {
            menu(); // Display main menu
            // Prompt the user to run another program
            System.out.println("Do you want to run another program? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));
        
        System.out.println("Goodbye!");
        scanner.close();
	}
	
	public static void menu() { // Method that displays the main menu and gets the user's input
        int choice = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Choose a program to run");
            System.out.println("1. Date Converter");
            System.out.println("2. Prime Number Calculator");
            System.out.println("3. Spongebob Text Converter");
            System.out.println("4. Pyramid Creator");
            System.out.println("5. Hangman");
            System.out.println("6. Rock Paper Scissors");

            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();

                // Check if the input is within the valid range (1 to 6)
                if (choice >= 1 && choice <= 6) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                }
            } else {
                // Consume the invalid input
                scanner.next();
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
            }
        }

        // Process the user's choice and run the corresponding method
        switch (choice) {
            case 1:
                DateConverter.convertDate();
                break;
            case 2:
                PrimeNumberCalculator.calculatePrimes();
                break;
            case 3:
                SpongebobImitator.convertToSpongebob();
                break;
            case 4:
                PyramidCreator.createPyramid();
                break;
            case 5:
               HangmanGame.Hangman();
                break;
            case 6:
                RockPaperScissorsGame.rps();
                break;
        }
    }
}
