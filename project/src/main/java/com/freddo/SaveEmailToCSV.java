package project.src.main.java.com.freddo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveEmailToCSV {

    private static final String CSV_FILE_PATH = "output1.csv";

    public static void main(String[] args) {
        List<Record> records = new ArrayList<>();
        records.add(new Record("user1@example.com", "What is your name?", "My name is John"));
        records.add(new Record("user2@example.com", "Where are you from?", "I am from London"));
        records.add(new Record("aphroditebenou@gmail.com","hi?","lalala"));
        //records.add(new Record("email.marissa","question.marissa","answer.marissa"));
        writeCsv(records);
    }

    private static void writeCsv(List<Record> records) {
        try (FileWriter writer = new FileWriter(CSV_FILE_PATH)) {
            // Write the CSV file header
            writer.append("Email,Question,Answer\n");

            // Write records to the CSV file
            for (Record record : records) {
                writer.append(record.getEmail()).append(',')
                        .append(record.getQuestion()).append(',')
                        .append(record.getAnswer()).append('\n');
            }

            System.out.println("CSV file created successfully at " + CSV_FILE_PATH);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Record {
        private final String email;
        private final String question;
        private final String answer;

        public Record(String email, String question, String answer) {
            this.email = email;
            this.question = question;
            this.answer = answer;
        }

        public String getEmail() {
            return email;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }
    }
}

