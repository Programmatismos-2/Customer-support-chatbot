package com.freddo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/*
 * SaveUsersCredentials class for saving user credentials to a CSV file
 */
public class SaveUsersCredentials {
    // Method to save user credentials to a CSV file
    public static void SaveStringToCSV(String email, String firstname, String lastname, String flightnumber) {
        String filePath = "path/to/output.csv"; // Path to the CSV file
        try {
            // Create a FileWriter to write to the CSV file (use 'true' to append data to an existing file)
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Format the data to be saved as a CSV row
            String dataToSave = email + "," + firstname + "," + lastname + "," + flightnumber;

            // Write the data to the CSV file
            bufferedWriter.write(dataToSave);
            bufferedWriter.newLine(); // Move to the next line (row)

            // Close the BufferedWriter and FileWriter
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            // Handle IOException if any
            e.printStackTrace();
        }
    }
}
