package project.src.main.java.com.freddo;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest.BodyPublishers;
 
public class Ai {
static HttpClient client = HttpClient.newHttpClient();
 
public static String hey() throws IOException, InterruptedException {
    String file = GiveFileToAI.fileToVariable(" ποιοι ειναι οι κανονισμοι για εγκειμονουσεσ ");
String requestBody = "{\n" +
" \"instances\": [\n" +
" {\n" +
"\"content\": \"" + file + " \",\n" +
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
 
HttpRequest request = HttpRequest.newBuilder()
.uri(URI.create("https://europe-west9-aiplatform.googleapis.com/v1/projects/clever-bounty-404116/locations/europe-west9/publishers/google/models/text-bison:predict"))
.POST(BodyPublishers.ofString(requestBody))
.header("Content-Type", "application/json")
.header("Authorization", "Bearer ya29.a0AfB_byAYgdQhMCRwNYs6aTii9pDpoLVr3FbThZ8QXZIe_gWt51J9xavsZwSt2u2_zR_SrxYoTSXkz4atWQ2LdbrQEBkd6D3aDq-sU5nVRI_Qx3D__gxcrXwt0kWAW2E68xsa4wcLJNH2Atvbmm0axkJ3jGa6Y7eNsQ4S6WgZe8WCaCgYKAVgSAQ4SFQHGX2Mihme9wfVmQm-6T0ulhixwcg0179")
.build();
 
HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());;
//System.out.println(response);
return ("Response Body: " + response.body());

}    
}
