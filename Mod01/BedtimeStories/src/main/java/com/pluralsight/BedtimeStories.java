package com.pluralsight;

import java.io.File;         // For file handling
import java.io.FileNotFoundException; // To handle missing file error
import java.util.Scanner;    // To read user input and file content

public class BedtimeStories {
    public static void main(String[] args) {
// Scanner for user input
        Scanner inputScanner = new Scanner(System.in);

// Prompt user for file name
        System.out.print("Enter the name of a story (e.g., goldilocks.txt): ");
// Read file name from user
        String fileName = inputScanner.nextLine();
// Create File object for the story
        File storyFile = new File(fileName);

// Use a new Scanner to read the file
        try {
            Scanner fileScanner = new Scanner(storyFile);

            int lineNumber = 1;  // Start line number at 1

// Read and print each line with a line number
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();  // Read next line
                System.out.println(lineNumber + ". " + line);  // Print with line number
                lineNumber++;  // Increment line number
            }

            fileScanner.close();  // Close file scanner

        } catch (FileNotFoundException e) {
            // Handle error if the file isn't found
            System.out.println("❗ The file \"" + fileName + "\" was not found.");
        }
// Close input scanner
        inputScanner.close();
    }
}