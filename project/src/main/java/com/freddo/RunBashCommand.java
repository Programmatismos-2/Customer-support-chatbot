import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunBashCommand {
    public static String aoth2() {
        try {
            // Specify the gcloud command you want to run
            String command = "gcloud auth print-access-token";

            // Create a ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
            
            // Redirect error stream to output stream
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            String key = null;
            while ((line = reader.readLine()) != null) {
                key += line;
            }
            // Wait for the process to complete
            int exitCode = process.waitFor();
            return key;
        } catch (IOException | InterruptedException e) {
            return "error";
        }
    }
}
