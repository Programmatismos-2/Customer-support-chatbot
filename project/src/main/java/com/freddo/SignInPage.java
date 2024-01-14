/*
 * Copyright (c) 2024, FreddoEspresso
 * All rights reserved.
 *
 * This source code is licensed under the Academic Free License v. 3.0.
 * See LICENSE.txt or http://opensource.org/licenses/AFL-3.0 for more details.
 */

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
* Creates the page where the user signs in using surname and flight number, proceeding only if the user is found in the database.
*/
public class SignInPage {
    // Method to open the sign-in window
    public void openSignInWindow() {
        // Create the sign-in frame
        JFrame signinFrame = new JFrame("Sign In - Σύνδεση");
        signinFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signinFrame.setSize(600, 400);
        // Set minimum size
        signinFrame.setMinimumSize(new Dimension(400, 400));
        signinFrame.setVisible(true);
        signinFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Create text fields and labels for surname and flight number
        JTextField surnameF2 = new JTextField();
        JTextField flightF2 = new JTextField();
        JLabel surnameL2 = new JLabel("Surname");
        JLabel flightL2 = new JLabel("Flight Number");
        surnameF2.setColumns(20);
        flightF2.setColumns(20);
        
        // Set grid positions for components
        gbc.gridx = 0;
        gbc.gridy = 0;
        signinFrame.add(surnameL2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        signinFrame.add(surnameF2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        signinFrame.add(flightL2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        signinFrame.add(flightF2, gbc);

        // Create and configure the submit button
        JButton submit1Button = new JButton("Submit");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        signinFrame.add(submit1Button, gbc);

        // ActionListener for the submit button
        submit1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values from text fields
                String surname = surnameF2.getText();
                String flightNumber = flightF2.getText();

                // Check if any of the fields is empty
                if (surname.isEmpty() || flightNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(signinFrame, "Please fill in all the fields.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Check customer existence and take appropriate actions
                    String cont = CustomerChecker.checkCustomerExistence(surname, flightNumber);
                    if (cont.equals("false")) {
                        int ans = JOptionPane.showConfirmDialog(null, "You are not checked in. Please do so.", "Sign In Problem", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                        if (ans == 0 || ans == -1) {
                            CheckInPage chpage = new CheckInPage();
                            chpage.openCheckWindow();
                        }
                    } else {
                        // Open the Chatbot window with user details
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                new Chatbot(surname, flightNumber, cont).setVisible(true);
                            }
                        });
                    }
                    // Close the sign-in window
                    signinFrame.dispose();
                }
            }
        });
    }
}
