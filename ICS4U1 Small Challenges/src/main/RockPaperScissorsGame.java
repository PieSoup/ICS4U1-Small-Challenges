package main;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {

	
	public static void rps() {
		// Initialize variables
		Scanner scanner = Main.scanner;
	    Random random = new Random();
	    
	    while (true) {
	
        	System.out.println("Rock, Paper, Scissors Game! ");
	        int choice;
	        do {
	        	// Main menu
	        	System.out.println("Choose an option (enter # 1-4):");
		        System.out.println("1. Rock");
		        System.out.println("2. Paper");
		        System.out.println("3. Scissors");
		        System.out.println("4. Exit");
		        System.out.print("Enter your choice: ");
				while(!Main.scanner.hasNextInt()) {
					System.out.println("Invalid input. Please choose a number 1-4: ");
					Main.scanner.next(); // Consume the invalid input
				}
				// Get the menu item they chose
				choice = Main.scanner.nextInt();
				Main.scanner.nextLine();
			}while(choice < 1 || choice > 4);
	
	        if (choice == 4) { // Exit the game
	            System.out.println("Thanks for playing! Goodbye!");
	            break;
	        }
	        
	        // Array to store the possible choices
	        String[] choices = {"Rock", "Paper", "Scissors"};
	        int computerChoice = random.nextInt(3); // 0 for Rock, 1 for Paper, 2 for Scissors
	        
	        // Show what each player choe
	        System.out.println("Player chose: " + choices[choice - 1]);
	        System.out.println("Computer chose: " + choices[computerChoice]);
	
	        int result = (choice - 1 - computerChoice + 3) % 3; // Calculate the result
	
	        // Display result
	        if (result == 0) {
	            System.out.println("It's a draw!");
	        } else if (result == 1) {
	            System.out.println("You win!");
	        } else {
	            System.out.println("Computer wins!");
	        }
	        
	        // Prompt to play again
	        System.out.print("Play again? (yes/no): ");
	        String playAgain = scanner.next().toLowerCase();
	        if (!playAgain.equals("yes")) {
	            System.out.println("Thanks for playing! Goodbye!");
	            break;
	        }
	    }
	}
}
