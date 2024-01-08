package com.freddo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
/*
 * This class connects to vertex ai and gets the responce for our users question
 */
public class Ai {
    
    // HttpClient instance for making HTTP requests
    static HttpClient client = HttpClient.newHttpClient();

    // Method to interact with the AI model
    public static String hey(String question) throws IOException, InterruptedException {
        // Get the content of the file related to the question
        String a = GiveFileToAI.fileToVariable(question);

        // Build the request body in JSON format for the AI model
        String requestBody = "{\n" +
            " \"instances\": [\n" +
            " {\n" +
            "\"content\": \"" + a + " \",\n" +
            " \"output\": \"\"\n" +
            " }\n" +
            " ],\n" +
            " \"parameters\": {\n" +
            " \"candideateCount\": 1,\n" +
            " \"maxOutputTokens\": 1024,\n" +
            " \"temperature\": 0.8,\n" +
            " \"topP\": 0.8,\n" +
            " \"topK\": 40\n" +
            " }\n" +
            "}";

        // Build the HTTP request to the AI model endpoint
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://europe-west9-aiplatform.googleapis.com/v1/projects/clever-bounty-404116/locations/europe-west9/publishers/google/models/text-bison:predict"))
            .POST(BodyPublishers.ofString(requestBody))
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + RunBashCommand.aoth2())
            .build();

        // Send the HTTP request and get the response from the AI model
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Cut and extract the answer from the response
        String h = CutAnswer.cut(response.body());

        // Return the extracted answer
        return h;
    }    
}
