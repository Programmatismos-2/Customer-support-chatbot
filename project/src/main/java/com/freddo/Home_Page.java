/*
 * Copyright (c) 2024, FreddoEspresso
 * All rights reserved.
 *
 * This source code is licensed under the Academic Free License v. 3.0.
 * See LICENSE.txt or http://opensource.org/licenses/AFL-3.0 for more details.
 */
package com.freddo;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
* Creates the starting page of the application, where the user decides whether he wants to sign in or check in.
*/
public class Home_Page extends JFrame {
    // ImageIcon for the home picture
    //TODO change the path to the apropriate one
    final static ImageIcon homePic = new ImageIcon("/path/to/image.jpg"); 

    // Declare signinButton and checkButton as instance variables
    private JButton signinButton;
    private JButton checkButton;

    // Constructor for the Home_Page class
    public Home_Page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 530);
        setLayout(null);

        // Create JLabel to display the home picture
        JLabel lab1 = new JLabel(homePic);
        lab1.setSize(800, 530);

        // Initialize signinButton and checkButton
        signinButton = new JButton("Sign In");
        checkButton = new JButton("Check In");
        signinButton.setBounds(150, 265, 200, 50);
        checkButton.setBounds(450, 265, 200, 50);
        signinButton.setBorder(BorderFactory.createEtchedBorder());
        checkButton.setBorder(BorderFactory.createEtchedBorder());
        signinButton.setOpaque(true);
        checkButton.setOpaque(true);

        // Set background color for buttons
        Color customColor = new Color(51, 153, 210);
        signinButton.setBackground(customColor);
        checkButton.setBackground(customColor);

        // Add components to the frame
        add(lab1);
        add(signinButton);
        add(checkButton);

        // Set component order for proper layering
        setComponentZOrder(signinButton, 0);
        setComponentZOrder(checkButton, 1);
        setComponentZOrder(lab1, 2);

        // Add component listener for resizing
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeImageAndButtons(lab1, homePic);
            }
        });

        // ActionListener for signinButton
        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home_Page.this.dispose();
                SignInPage sign = new SignInPage();
                sign.openSignInWindow();
            }
        });

        // ActionListener for checkButton
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home_Page.this.dispose();
                CheckInPage chpage = new CheckInPage();
                chpage.openCheckWindow();
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    // Method to resize the image and buttons based on the frame size
    private void resizeImageAndButtons(JLabel label, ImageIcon icon) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(newImg));

        // Calculate new positions based on the frame size
        int buttonWidth = label.getWidth() / 4;
        int buttonHeight = label.getHeight() / 10;
        int buttonY = label.getHeight() * 5 / 9;
        signinButton.setBounds(label.getWidth() / 4 - buttonWidth / 2, buttonY, buttonWidth, buttonHeight);
        checkButton.setBounds(label.getWidth() * 3 / 4 - buttonWidth / 2, buttonY, buttonWidth, buttonHeight);
    }
}
