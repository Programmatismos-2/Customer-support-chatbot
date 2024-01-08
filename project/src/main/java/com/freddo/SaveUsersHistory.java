package com.freddo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * SaveUsersHistory class for saving user email and conversation to a CSV file.
 */
public class SaveUsersHistory {

    public static void saveEmailAndQuestion(String email, String conv) throws IOException, InterruptedException {
        String csvFilePath = "/path/to/users_QandA.csv";
        String textWithoutCommas = removeCommas(conv);
        saveDataToCSV(email, textWithoutCommas, csvFilePath);
    }

    private static void saveDataToCSV(String email, String conversation, String csvFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true))) {
            // Append a new line with email and conversation
            writer.write(email + "," + conversation);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    private static String removeCommas(String inputText) {
        // Use the replace method to remove all commas
        return inputText.replaceAll(",", "");
    }
}
