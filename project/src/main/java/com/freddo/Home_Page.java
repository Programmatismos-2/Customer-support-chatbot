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
import javax.swing.SwingUtilities;

public class Home_Page extends JFrame {
    final static ImageIcon homePic = new ImageIcon("/Users/fanisorfan/code/projmv/Mediator-Class-1/Mediator-Class/GUI-Class/project/src/resources/HomePlane1.jpg");
    private JButton signinButton; // Declare signinButton as an instance variable
    private JButton checkButton;  // Declare checkButton as an instance variable

    public Home_Page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 530);
        setLayout(null);
        
        JLabel lab1 = new JLabel(homePic);
        lab1.setSize(800, 530);

        signinButton = new JButton("Sign In");
        checkButton = new JButton("Check In");
        signinButton.setBounds(150, 265, 200, 50);
        checkButton.setBounds(450, 265, 200, 50);
        signinButton.setBorder(BorderFactory.createEtchedBorder());
        checkButton.setBorder(BorderFactory.createEtchedBorder());

        signinButton.setOpaque(true);
        checkButton.setOpaque(true);

        Color customColor = new Color(51, 153, 210); // Red
        signinButton.setBackground(customColor);
        checkButton.setBackground(customColor);

        add(lab1);
        add(signinButton);
        add(checkButton);

        setComponentZOrder(signinButton, 0);
        setComponentZOrder(checkButton, 1);
        setComponentZOrder(lab1, 2);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeImageAndButtons(lab1, homePic);
            }
        });

        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home_Page.this.dispose();
                SignInPage sign = new SignInPage();
                sign.openSignInWindow();
            }
        });

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home_Page.this.dispose();
                CheckInPage chpage = new CheckInPage();
                chpage.openCheckWindow();
            }
        });

        setVisible(true);
    }

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home_Page());
    }
}
