/*
 * Copyright (c) 2024, FreddoEspresso
 * All rights reserved.
 *
 * This source code is licensed under the Academic Free License v. 3.0.
 * See LICENSE.txt or http://opensource.org/licenses/AFL-3.0 for more details.
 */
package com.freddo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 
 * RunBashCommand class for executing bash commands
 */
public class RunBashCommand {
    // Method to obtain an OAuth2 access token using the gcloud command
    public static String aoth2() throws InterruptedException {
        try {
            // Specify the gcloud command you want to run
            String command = "gcloud auth print-access-token";
            
            // Create a ProcessBuilder for running the command
            //TODO if you are using windows switch the "bash" to "cmd.exe" and the "-c" to "/c"
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
           
            // Redirect error stream to output stream
            processBuilder.redirectErrorStream(true);
            
            // Start the process
            Process process = processBuilder.start();

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            String key = "";
            
            // Collect the lines of output
            while ((line = reader.readLine()) != null) {
                key += line;
            }
            
            // Wait for the process to complete
            process.waitFor();
            
            // Return the obtained OAuth2 access token
            return key;
        } catch (IOException e) {
            // Handle IOException if any
            return "error";
        }
    }
}
