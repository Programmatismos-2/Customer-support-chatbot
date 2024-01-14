/*
 * Copyright (c) 2024, FreddoEspresso
 * All rights reserved.
 *
 * This source code is licensed under the Academic Free License v. 3.0.
 * See LICENSE.txt or http://opensource.org/licenses/AFL-3.0 for more details.
 */

package com.freddo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * This class represents a CustomerChecker, which is used to check the existence of a customer
 * based on the last name and flight number.
 */
public class CustomerChecker {
    public static String checkCustomerExistence(String lastName, String flightNumber) {
        //TODO change the path to the apropriate one
        String csvFilePath = "/path/to/output.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the CSV line into fields
                String[] fields = line.split(",");

                // Check if the current row matches the provided last name and flight number
                if (fields.length >= 4
                        && fields[2].equals(lastName)
                        && fields[3].equals(flightNumber)) {
                    return fields[0]; // Email address
                }
            }
            return "false"; // Flight not found
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            return "false";
        }
    }
}
