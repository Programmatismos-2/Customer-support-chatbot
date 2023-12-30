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

public class SignInPage {
    public void openSignInWindow() {
        JFrame signinFrame = new JFrame("Sign In - Σύνδεση");
        signinFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signinFrame.setSize(600, 400);
        signinFrame.setMinimumSize(new Dimension(400, 400)); // Set minimum size
        signinFrame.setVisible(true);
        signinFrame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField surnameF2 = new JTextField();
        JTextField flightF2 = new JTextField();
        JLabel surnameL2 = new JLabel("Surname");
        JLabel flightL2 = new JLabel("Flight Number");

        surnameF2.setColumns(20);
        flightF2.setColumns(20);

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

        JButton submit1Button = new JButton("Submit");
gbc.gridx = 1;
gbc.gridy = 2;
gbc.anchor = GridBagConstraints.EAST;
signinFrame.add(submit1Button, gbc);

submit1Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String surname = surnameF2.getText();
        String flightNumber = flightF2.getText();

        // Check if any of the fields is empty
        if (surname.isEmpty() || flightNumber.isEmpty()) {
            JOptionPane.showMessageDialog(signinFrame, "Please fill in all the fields.", "Missing Information", JOptionPane.WARNING_MESSAGE);
        } else {
            String cont = FlightChecker.checkFlightExistence(surname, flightNumber);
            if (cont.equals("false")) {
                int ans = JOptionPane.showConfirmDialog(null, "Δεν είστε εγγεγραμμένος. Παρακαλώ εγγραφείτε", "Πρόβλημα Σύνδεσης", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                if (ans == 0 || ans == -1) {
                    CheckInPage chpage = new CheckInPage();
                    chpage.openCheckWindow();
                }
            } else {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new Chatbot(surname, flightNumber, cont).setVisible(true);
                    }
                });
            }
            signinFrame.dispose();
        }
    }
});
    }
}
