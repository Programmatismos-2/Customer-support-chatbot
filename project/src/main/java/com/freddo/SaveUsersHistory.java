/*
 * Copyright (c) 2024, FreddoEspresso
 * All rights reserved.
 *
 * This source code is licensed under the Academic Free License v. 3.0.
 * See LICENSE.txt or http://opensource.org/licenses/AFL-3.0 for more details.
 */

package com.freddo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * SaveUsersHistory class for saving user email and conversation to a CSV file.
 */
public class SaveUsersHistory {
    public static void saveEmailAndQuestion(String email, String conv) throws IOException, InterruptedException {
        //TODO change the path
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
