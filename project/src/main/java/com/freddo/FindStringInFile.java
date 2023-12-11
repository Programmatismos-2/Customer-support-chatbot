package com.freddo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindStringInFile {
    public static void main(String[] args) {
        String filePath = "output.txt"; // Path to the text file
        String searchString = "MAria"; // The string you want to find

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(searchString)) {
                    System.out.println(line);
                }
            }

            // Close the BufferedReader and FileReader
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
