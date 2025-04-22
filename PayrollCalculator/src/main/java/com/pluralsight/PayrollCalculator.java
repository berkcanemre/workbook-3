package com.pluralsight;

// PayrollCalculator.java

import java.io.*;
import java.util.*;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// Prompt user for input file name
        System.out.print("Enter the name of the employee file to process: ");
        String inputFile = scanner.nextLine();

// Prompt user for output file name
        System.out.print("Enter the name of the payroll file to create: ");
        String outputFile = scanner.nextLine();

        List<Employee> employees = new ArrayList<>();

//This file is in the project directory
        String fileName = "src/main/resources/employees.csv";


//Read from the employee CSV file
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(inputFile));
            String line;

            while ((line = bufReader.readLine()) != null) {
                if (line.toLowerCase().startsWith("id|")) continue; // Skip header line

//Parse the line
                String[] tokens = line.split("\\|");

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

//Create Employee object and add to list
                Employee emp = new Employee(id, name, hoursWorked, payRate);
                employees.add(emp);
            }

            bufReader.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

//Write payroll file based on extension (.json or .csv)
        try {
            if (outputFile.toLowerCase().endsWith(".json")) {
//Write as JSON
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                writer.write("[\n");
                for (int i = 0; i < employees.size(); i++) {
                    Employee emp = employees.get(i);
                    writer.write(String.format("  { \"id\": %d, \"name\" : \"%s\", \"grossPay\" : %.2f }",
                            emp.getEmployeeId(), emp.getName(), emp.getGrossPay()));
                    if (i < employees.size() - 1) {
                        writer.write(",\n");
                    } else {
                        writer.write("\n");
                    }
                }
                writer.write("]");
                writer.close();
            } else {
//Write as CSV
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                writer.write("id|name|gross pay\n");
                for (Employee emp : employees) {
                    writer.write(String.format("%d|%s|%.2f\n",
                            emp.getEmployeeId(), emp.getName(), emp.getGrossPay()));
                }
                writer.close();
            }

            System.out.println("Payroll file created successfully: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error writing the file: " + e.getMessage());
        }
    }
}