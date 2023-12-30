package com.freddo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Chatbot extends JFrame {
    JTextArea chatArea;
    JTextField input;
    List<String> conversation;
    String email;
    String fli;
    String names;
    public Chatbot(String names, String fli, String email) {
        this.fli = fli;
        this.names = names;
        this.email = email;
        setTitle("Chatbot App");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Set to DO_NOTHING_ON_CLOSE to handle window close event
        setSize(600, 400);
        setVisible(true);

        chatArea = new JTextArea(15, 20);
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        conversation = new ArrayList<>();

        input = new JTextField(20);
        JButton sendButton = new JButton("Send");
        JButton backButton = new JButton("Back to Homepage");

        input.addActionListener(e -> {
            try {
                processUserInput();
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        sendButton.addActionListener(e -> {
            try {
                processUserInput();
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            new Home_Page();
            try {
                saveConversation();
            } catch (IOException | InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Increased insets for padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(input, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        add(sendButton, gbc);

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
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                // You can add additional logic here if needed
                dispose(); // Close the window
            }
        });
    }

    private void processUserInput() throws IOException, InterruptedException {
        String userMessage = input.getText();
        conversation.add("You: " + userMessage);
        updateChatArea();

        // Replace this with your logic to get a response
        // String answer = SaveUsersHistory.SaveEmailAndQuestion(fli, userMessage);
        String answer = Ai.hey(userMessage); // Replace with actual response logic

        String botResponse = "Chatbot: " + answer;
        conversation.add(botResponse);
        updateChatArea();

        input.setText("");
    }

    private void updateChatArea() {
        chatArea.setText("");
        for (String message : conversation) {
            chatArea.append(message + "\n");
        }
    }

    private void saveConversation() throws IOException, InterruptedException {
        String conv = getConversationAsString();
        if (conv.isEmpty()==false) {
        SaveUsersHistory.SaveEmailAndQuestion(email, conv);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Chatbot("", "","").setVisible(true);
        });
    }
}
