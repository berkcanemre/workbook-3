package com.pluralsight;

// Import Scanner for user input
import java.util.Scanner;
// Import Random to generate random quote index
import java.util.Random;

public class FamousQuotes {

    public static void main(String[] args) {
// Scanner to read user input
        Scanner scanner = new Scanner(System.in);
// Random for selecting random quote
        Random random = new Random();

// Array of 10 favorite quotes
        String[] quotes = {
                "The only limit to our realization of tomorrow is our doubts of today. – Franklin D. Roosevelt",
                "The journey of a thousand miles begins with one step. – Lao Tzu",
                "In the middle of difficulty lies opportunity. – Albert Einstein",
                "Success is not final, failure is not fatal: It is the courage to continue that counts. – Winston Churchill",
                "Do what you can, with what you have, where you are. – Theodore Roosevelt",
                "You miss 100% of the shots you don’t take. – Wayne Gretzky",
                "Peace at home, Peace in the World – Mustafa Kemal Ataturk",
                "Whether you think you can or you think you can’t, you’re right. – Henry Ford",
                "I have not failed. I've just found 10,000 ways that won't work. – Thomas Edison",
                "It always seems impossible until it's done. – Nelson Mandela"
        };

// Control variable for main loop
        boolean keepRunning = true;

// Main loop: repeats until user chooses to exit
        while (keepRunning) {
// Display menu
            System.out.println("\nChoose an option:");
            System.out.println("1. View a quote by number (1–10)");
            System.out.println("2. Show a random quote");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

// Get user input
            String choice = scanner.nextLine();

            // Handle menu choices using switch
            switch (choice) {
                case "1":
                    // Prompt user to enter a number for specific quote
                    System.out.print("Enter a number between 1 and 10: ");
                    String input = scanner.nextLine();  // Get user input

                    // Check if input is a valid number between 1 and 10
                    if (input.matches("[1-9]|10")) {  // Only accept numbers 1 to 10
                        int number = Integer.parseInt(input);
                        System.out.println("\nQuote: " + quotes[number - 1]);  // Display quote
                    } else {
                        System.out.println("❗ Invalid input. Please enter a number between 1 and 10.");
                    }
                    break;

                case "2":
                    // Show a random quote from the array
                    int randomIndex = random.nextInt(quotes.length);
                    System.out.println("\nRandom Quote: " + quotes[randomIndex]);
                    break;

                case "3":
                    // Exit the loop and close program
                    keepRunning = false;
                    System.out.println("👋 Goodbye!");
                    break;

                default:
                    // Handle any invalid menu input
                    System.out.println("❗ Invalid menu choice. Please choose 1, 2, or 3.");
            }
        }

        scanner.close();  // Close Scanner resource
    }
}