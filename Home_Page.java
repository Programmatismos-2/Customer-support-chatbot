import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home_Page {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Αρχικό Παράθυρο");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 500);
        mainFrame.setLayout(new FlowLayout());

        JButton chatbotButton = new JButton("Εξυπηρέτηση Πελατών");
        JButton flightBookingButton = new JButton("Κράτηση Εισιτηρίων Πτήσης");
        mainFrame.add(chatbotButton);
        mainFrame.add(flightBookingButton);
        mainFrame.setVisible(true);
    }



}