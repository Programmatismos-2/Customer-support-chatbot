package com.freddo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveStringToCSV {
    public static void main(String[] args) {
        //String dataToSave = clasimarissa.methodmarissa();
        String filePath = "output.csv"; // Path to the CSV file
        String name = "Nikos";
        String lastname = "Papakati";

        try {
            FileWriter fileWriter = new FileWriter(filePath, true); // Use 'true' to append data to an existing file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the CSV data to the file
            //σχολιο μονο για το παραδειγμα
            String dataToSave = name + "," + lastname;
            bufferedWriter.write(dataToSave);
            bufferedWriter.newLine(); // Move to the next line (row)

            // Close the BufferedWriter and FileWriter
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Data saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
