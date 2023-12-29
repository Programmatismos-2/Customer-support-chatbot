package com.freddo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveUsersHistory {

    public static void SaveEmailAndQuestion(String email,String conv) throws IOException, InterruptedException{
        String csvFilePath = "/Users/fanisorfan/code/projmv/Mediator-Class-1/Mediator-Class/users_QandA.csv";       
        String textWithoutCommas = removeCommas(conv);
        saveDataToCSV(email, textWithoutCommas, csvFilePath);
    }

    private static void saveDataToCSV(String email, String conversation, String csvFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true))) {
            // Append a new line with email, question, and answer
            writer.write(email + "," + conversation );
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
