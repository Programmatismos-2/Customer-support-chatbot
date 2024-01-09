package com.freddo;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
/**
* Creates page for the user to check in using surname, name, flight number and email.
*/
public class CheckInPage {
    // Method to open the check-in window
    public void openCheckWindow() {
        JFrame checkFrame = new JFrame("Check-In");
        checkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checkFrame.setSize(600, 400);
        checkFrame.setMinimumSize(new Dimension(400, 400)); // Set minimum size
        checkFrame.setVisible(true);
        checkFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create text fields for name, surname, flight number, and email
        JTextField nameF1 = createTextField(20);
        JTextField surnameF1 = createTextField(20);
        JTextField flightF1 = createTextField(20);
        JTextField emailF1 = createTextField(20);

        // Create labels for name, surname, flight number, and email
        JLabel nameL1 = createLabel("Name");
        JLabel surnameL1 = createLabel("Surname");
        JLabel flightL1 = createLabel("Flight Number");
        JLabel emailL1 = createLabel("Email");

        // Set grid positions for components
        gbc.gridx = 0;
        gbc.gridy = 0;
        checkFrame.add(nameL1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        checkFrame.add(nameF1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        checkFrame.add(surnameL1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        checkFrame.add(surnameF1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        checkFrame.add(flightL1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        checkFrame.add(flightF1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        checkFrame.add(emailL1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        checkFrame.add(emailF1, gbc);

        // Create and configure the submit button
        JButton submitButton = createButton("Submit", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values from text fields
                String name = nameF1.getText();
                String surname = surnameF1.getText();
                String flightNumber = flightF1.getText();
                String email = emailF1.getText();

                // Check if any of the fields is empty
                if (name.isEmpty() || surname.isEmpty() || flightNumber.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(checkFrame, "Please fill in all the fields.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                } else if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(checkFrame, "Please enter a valid email address.", "Invalid Email", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Check customer existence and take appropriate actions
                    String output = CustomerChecker.checkCustomerExistence(surname, flightNumber);
                    if (output.equals("false")) {
                        // Save user credentials to CSV
                        SaveUsersCredentials.SaveStringToCSV(name, surname, flightNumber, email);
                    } else {
                        // Show message if the user is already checked in
                        JOptionPane.showMessageDialog(checkFrame, "You have already checked in.", "Already checked in.", JOptionPane.INFORMATION_MESSAGE);
                        JLabel alr = new JLabel("Είστε ήδη εγγεγραμμένος");
                        alr.setBounds(200, 250, 200, 30);
                        checkFrame.add(alr);
                    }
                    
                    // Close the check-in window and open the Chatbot window
                    checkFrame.dispose();
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new Chatbot(surname, flightNumber, output).setVisible(true);
                        }
                    });
                }
            }
        });

        // Set grid position for the submit button
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        checkFrame.add(submitButton, gbc);
    }

    // Method to create a JTextField with the specified number of columns
    private JTextField createTextField(int columns) {
        JTextField textField = new JTextField();
        textField.setColumns(columns);
        return textField;
    }

    // Method to create a JLabel with the specified text
    private JLabel createLabel(String text) {
        return new JLabel(text);
    }

    // Method to create a JButton with the specified text and ActionListener
    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }

    // Method to check if an email is in a valid format
    private boolean isValidEmail(String email) {
        // Use a simple regular expression for email validation
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        return email.matches(emailRegex);
    }
}
