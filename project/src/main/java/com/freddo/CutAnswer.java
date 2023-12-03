import java.io.IOException;
 
public class CutAnswer {
    public static String cut(String a) throws IOException, InterruptedException {
        try {
            String cutAnswer = a.trim(); // Trim leading and trailing whitespace

            // Split the input string based on a more flexible pattern
            String[] firstsplit = cutAnswer.split("\"content\"\\s*:\\s*\"");

            // Check if the array has the expected index
            if (firstsplit.length > 1) {
                // Extract the second part after the split
                String content = firstsplit[1];

                // Remove the closing double quote and any extra characters
                content = content.split("\"")[0].trim();

                return content;
            } else {
                System.out.println("Substring '\"content\":\"' not found in the input string.");
                return "";
            }
        } catch (Exception e) {
            System.out.println("Error processing input string: " + e.getMessage());
            return "";
        }
    }


}

