package com.freddo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckInPage {
    public void openCheckWindow() {
        JFrame checkFrame = new JFrame("Check-In");
        checkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checkFrame.setSize(600, 400);
        checkFrame.setMinimumSize(new Dimension(400, 400)); // Set minimum size
        checkFrame.setVisible(true);
        checkFrame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField nameF1 = createTextField(20);
        JTextField surnameF1 = createTextField(20);
        JTextField flightF1 = createTextField(20);
        JTextField emailF1 = createTextField(20);

        JLabel nameL1 = createLabel("Name");
        JLabel surnameL1 = createLabel("Surname");
        JLabel flightL1 = createLabel("Flight Number");
        JLabel emailL1 = createLabel("Email");

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

        JButton submitButton = createButton("Submit", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String output = FlightChecker.checkFlightExistence(surnameF1.getText(), flightF1.getText());
                if (output == "false") {
                    SaveUsersCredentials.SaveStringToCSV(nameF1.getText(), surnameF1.getText(), flightF1.getText(), emailF1.getText());
                } else {
                    JLabel alr = new JLabel("Είστε ήδη εγγεγραμμένος");
                    alr.setBounds(200, 250, 200, 30);
                    checkFrame.add(alr);
                }
                checkFrame.dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new Chatbot(surnameF1.getText(), flightF1.getText(), output).setVisible(true);
                    }
                });
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        checkFrame.add(submitButton, gbc);
    }

    private JTextField createTextField(int columns) {
        JTextField textField = new JTextField();
        textField.setColumns(columns);
        return textField;
    }

    private JLabel createLabel(String text) {
        return new JLabel(text);
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }
}
