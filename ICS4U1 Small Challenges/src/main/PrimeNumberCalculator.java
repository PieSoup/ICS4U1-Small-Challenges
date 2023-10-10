package main;

import java.util.Scanner;

public class PrimeNumberCalculator {
    // Method to calculate prime numbers within a given range
    public static void calculatePrimes() {
        Scanner scanner = Main.scanner; // Get the scanner object from the Main class

        // Ask user for lower range (between 2 and 250)
        int lower;
        do {
            System.out.print("Enter the lower range (between 2 and 250): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number for the lower range: ");
                scanner.next(); // Consume the invalid input
            }
            lower = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } while (lower < 2 || lower > 250);

        // Ask user for upper range (between 2 and 250, and greater than or equal to lower)
        int upper;
        do {
            System.out.print("Enter the upper range (between " + lower + " and 250): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number for the upper range: ");
                scanner.next(); // Consume the invalid input
            }
            upper = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } while (upper < lower || upper > 250);

        // StringBuilder to store prime numbers
        StringBuilder primeNumbers = new StringBuilder();

        // Loop through the numbers in the given range
        for (int num = lower; num <= upper; num++) {
            // Check if the current number is prime using the isPrime method
            if (isPrime(num)) {
                // If prime, append it to the primeNumbers StringBuilder with a space separator
                primeNumbers.append(num).append(" ");
            }
        }

        // Convert the StringBuilder to a string and trim any leading/trailing spaces before returning
        if(primeNumbers.length() >= 1) {
        	System.out.println("Prime numbers between " + lower + " and " + upper + ": " + primeNumbers.toString().trim());
        }
        else {
        	System.out.println("There are no prime numbers between " + lower + " and " + upper + ".");
        	
        }
        
    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        // Numbers less than or equal to 1 are not prime
        if (number <= 1) {
            return false;
        }

        // Loop to check if the number has factors other than 1 and itself
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                // If any factor is found, the number is not prime
                return false;
            }
        }

        // If no factors are found, the number is prime
        return true;
    }
}
