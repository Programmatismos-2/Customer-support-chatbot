/*
 * Copyright (c) 2024, FreddoEspresso
 * All rights reserved.
 *
 * This source code is licensed under the Academic Free License v. 3.0.
 * See LICENSE.txt or http://opensource.org/licenses/AFL-3.0 for more details.
 */

package com.freddo;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
* Creates page for the user to check in using surname, name, flight number and email.
*/
public class Chatbot extends JFrame {
    JTextArea chatArea;
    JTextField input;
    List<String> conversation;
    String email;
    String fli;
    String names;

    // Constructor for the Chatbot class that creates the chatbot frame with its components
    public Chatbot(String names, String fli, String email) {
        this.fli = fli; 
        this.names = names;
        this.email = email;
        setTitle("Chatbot App");
        // Set to DO_NOTHING_ON_CLOSE to handle window close event
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
        
        //Creation of components
        chatArea = new JTextArea(15, 20);
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        conversation = new ArrayList<>();
        input = new JTextField(20);
        JButton sendButton = new JButton("Send");
        JButton backButton = new JButton("Back to Homepage");

        // ActionListener for processing user input
        input.addActionListener(e -> {
            try {
                processUserInput();
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        // ActionListener for the send button
        sendButton.addActionListener(e -> {
            try {
                processUserInput();
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        // ActionListener for the back button
        backButton.addActionListener(e -> {
            dispose();
            new Home_Page();
            try {
                saveConversation();
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Increased insets for padding

        // Add scroll pane for the chat area
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);

        // Add text field for user input
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(input, gbc);

        // Add send button
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        add(sendButton, gbc);

        // Add back button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(backButton, gbc);

        // Add window listener to handle window close event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    saveConversation();
                } catch (IOException | InterruptedException e1) {
                    e1.printStackTrace();
                }
                dispose(); // Close the window
            }
        });
    }

    // Method to process user input and update the chat area
    private void processUserInput() throws IOException, InterruptedException {
        String userMessage = input.getText();
        conversation.add("You: " + userMessage);
        updateChatArea();

        // String answer = SaveUsersHistory.saveEmailAndQuestion(fli, userMessage);
        String answer = Ai.hey(userMessage); // Use AI class to get answer from bot
        String botResponse = "Chatbot: " + answer;
        conversation.add(botResponse);
        updateChatArea();
        input.setText("");  // Clears input text field 
    }

    // Method to update the chat area with the conversation
    private void updateChatArea() {
        chatArea.setText("");
        for (String message : conversation) {
            chatArea.append(message + "\n");
        }
    }

    // Method to save the conversation
    private void saveConversation() throws IOException, InterruptedException {
        String conv = getConversationAsString();
        if (conv.isEmpty() == false) {
            SaveUsersHistory.saveEmailAndQuestion(email, conv);
        }
        // You can also save the conversation to a file or perform other actions here
    }

    // Method to get the entire conversation as a String
    private String getConversationAsString() {
        StringBuilder qonv = new StringBuilder();
        for (String message : conversation) {
            qonv.append(message).append("   ");
        }
        return qonv.toString();
    }
}
