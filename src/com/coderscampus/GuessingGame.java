package com.coderscampus;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	private Random random;
	private Scanner scanner;
	
	private int numberToGuess; // Store the generated random number
	private int maxNumberTries = 5; // Stores the player's maximum number of tries left
	private boolean isGameOver = false;
	private Integer guess;	// Store the player's guess converted to "int"
	
	// Initialize the class
	public GuessingGame() {
		this.scanner = new Scanner(System.in);
		this.random = new Random();
	}
	
	/**
	 * Method that generates a random number
	 */
	private void generateRandomNumber() {
		this.numberToGuess = this.random.nextInt(100) + 1;	
	}

	/**
	 * Method that prompts the player to enter a number
	 */
	private void getInput() {
		System.out.print("Pick a number between 1 and 100 ");
		this.guess = Integer.parseInt(this.scanner.next());	
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
			if (this.maxNumberTries == 0) {
				break;
			}
		
			// Prompt the user to type a number
			this.getInput();
			
			// If in the range, check if the user won and terminate the game
			if (this.guess == this.numberToGuess) {
				this.isGameOver = true;
				break;
			}
			
			// Check if the user's typed number is inside the range
			// Then check if it is lower or greater than the number to guess
			// and update the number of tries left
			if (this.guess < 1 || this.guess > 100) {
				System.out.println("Your guess is not between 1 and 100, please try again.");		
			} else if (this.guess < this.numberToGuess) {
				this.maxNumberTries--;	
				System.out.println("Please pick a higher number");
			} else if (this.guess > this.numberToGuess) {
				this.maxNumberTries--;	
				System.out.println("Please pick a lower number");				
			} 
			
		}
		
		// If the player guesses the right number then display the message
		if (this.isGameOver == true) {
			System.out.println("You win!");	
		}
		
		// Once the number of tries reaches zero then the game is over 
		if (this.maxNumberTries == 0) {
			System.out.println("You lose!");		
			System.out.println("The number to guess was: " + this.numberToGuess);		
		}
		
		scanner.close();

	}

 }
