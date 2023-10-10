package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
	
	private static final List<String> WORDS = Arrays.asList("java", "programming", "hangman", "computer", "algorithm", "developer");
    private static final int MAX_INCORRECT_GUESSES = 6;
    
    private static final String[] hangman = { // String array to store the hangman drawing
    		"  O",
    		"  |",
    		"__|__",
    		"  |",
    		"  |",
    		"_| |_"
    };
	
	public static void Hangman() {
		// Initialize variables
		Random random = new Random();
        String wordToGuess = WORDS.get(random.nextInt(WORDS.size())); // Get a random word
        char[] guessedLetters = new char[wordToGuess.length()]; // Make an array that displays the letters the user has guessed
        Arrays.fill(guessedLetters, '_'); // Fill the array with blank spaces

        // Store incorrect guesses
        int incorrectGuesses = 0;
        List<Character> incorrectGuessList = new ArrayList<>();

        Scanner scanner = Main.scanner; // Init scanner

        System.out.println("Welcome to Hangman!");
        // Prompt the user with guesses until they lose
        while (incorrectGuesses < MAX_INCORRECT_GUESSES) {
            System.out.println("Word to guess: " + new String(guessedLetters));
            System.out.println("Incorrect guesses: " + incorrectGuessList);
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0); // Only get the first character they input
            
            // If the word contains the guess, update the display
            if (wordToGuess.contains(String.valueOf(guess))) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedLetters[i] = guess;
                    }
                }
            } else if(Character.isAlphabetic(guess)){ // Unless the character was invalid, add it to the incorrect guesses
                incorrectGuessList.add(guess);
                incorrectGuesses++;
            } 
            else {
            	System.out.println("Invalid input, please only input letters.");
            }
            // Output for if they win
            if (Arrays.equals(guessedLetters, wordToGuess.toCharArray())) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                break;
            }
            // Display the hang man based on how many guesses they have wrong
            for(int i = 0; i < incorrectGuesses; i ++) {
            	System.out.println(hangman[i]);
            }
        }
        // Output for if they lose
        if (incorrectGuesses >= MAX_INCORRECT_GUESSES) {
            System.out.println("Sorry, you lost! The word was: " + wordToGuess);
        }
	}
}
