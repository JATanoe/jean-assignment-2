package com.coderscampus;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	Random random;
	Scanner scanner;
	
	int number_to_guess; // Store the generated random number
	int max_number_tries = 5; // Stores the player's maximum number of tries left
	boolean isGameOver = false;
	String input; // Store the player's typed number
	Integer guess;	// Store the player's guess converted to "int"
	
	// Initialize the class
	public GuessingGame() {
		this.scanner = new Scanner(System.in);
		this.random = new Random();
	}
	
	/**
	 * Method that generates a random number
	 */
	private void generateRandomNumber() {
		this.number_to_guess = this.random.nextInt(100) + 1;	
	}

	/**
	 * Method that prompts the player to enter a number
	 */
	private void getInput() {
		System.out.print("Pick a number between 1 and 100 ");
		this.input = this.scanner.next();
		this.guess = Integer.parseInt(this.input);	
	}

	/**
	 * Method that starts and runs the game
	 */
	public void run()  {		
		
		// Generate a random number
		this.generateRandomNumber();
		
		// As long as the game is not over
		while (!this.isGameOver) {
			
			// Break out of the loop if the max_number_tries is lower than 1
			if (this.max_number_tries == 0) {
				break;
			}
		
			// Prompt the user to type a number
			this.getInput();
			
			// If in the range, check if the user won and terminate the game
			if (this.guess == this.number_to_guess) {
				this.isGameOver = true;
				break;
			}
			
			// Check if the user's typed number is inside the range
			// Then check if it is lower or greater than the number to guess
			// and update the number of tries left
			if (this.guess < 1 || this.guess > 100) {
				System.out.println("Your guess is not between 1 and 100, please try again.");		
			} else if (this.guess < this.number_to_guess) {
				this.max_number_tries--;	
				System.out.println("Please pick a higher number");
			} else if (this.guess > this.number_to_guess) {
				this.max_number_tries--;	
				System.out.println("Please pick a lower number");				
			} 
			
		}
		
		// If the player guesses the right number then display the message
		if (this.isGameOver == true) {
			System.out.println("You win!");	
		}
		
		// Once the number of tries reaches zero then the game is over 
		if (this.max_number_tries == 0) {
			System.out.println("You lose!");		
			System.out.println("The number to guess was: " + this.number_to_guess);		
		}
		
		scanner.close();

	}

 }
