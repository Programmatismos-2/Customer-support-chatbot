import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Chatbot extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private List<String> conversation;

    public Chatbot() {
        setTitle("Chatbot App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        chatArea = new JTextArea(15, 20);
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField(20);
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processUserInput();
            }
        });

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processUserInput();
            }
        });

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(okButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        inputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    processUserInput();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        conversation = new ArrayList<>();
    }

    private void processUserInput() {
        String userMessage = inputField.getText();
        conversation.add("You: " + userMessage);
        updateChatArea();

        // Εδώ μπορείτε να καλέσετε τον chatbot και να λάβετε την απάντησή του.
        // Στο παράδειγμα αυτό, απλά προσθέτουμε μια σκληροκωδιμένη απάντηση.
        String botResponse = "Chatbot: Συνεχίστε...";
        conversation.add(botResponse);
        updateChatArea();

        inputField.setText("");
    }

    private void updateChatArea() {
        chatArea.setText("");
        for (String message : conversation) {
            chatArea.append(message + "\n");
        }
    }
}
