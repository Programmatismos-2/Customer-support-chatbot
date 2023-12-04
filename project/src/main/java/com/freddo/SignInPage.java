package project.src.main.java.com.freddo;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChatBotPage {
    Mediator med1 = new Mediator();    //Φτιάχνει αντικείμενο από την Mediator Class
    public String openChatbotWindow() {
        JFrame chatbotFrame = new JFrame("Εξυπηρέτηση Πελατών - Chatbot");
        chatbotFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     // Κλείστε αυτό το παράθυρο όταν κλείσετε το chatbot
        chatbotFrame.setSize(600, 400);
        chatbotFrame.setVisible(true);  //Κάνει ορατό το νέο παράθυρο
        chatbotFrame.setIconImage(logo.getImage());
        chatbotFrame.setLayout(null);
        
        JTextField surnameF2 = new JTextField();
        JTextField flightF2 = new JTextField();
        JLabel surnameL2 = new JLabel("Surname");
        JLabel flightL2 = new JLabel("Flight Number");

        surnameF2.setBounds(200, 140, 200, 30);
        flightF2.setBounds(200, 200, 200, 30);
        surnameL2.setBounds(50, 140, 200, 30);
        flightL2.setBounds(50, 200, 200, 30);

        chatbotFrame.add(surnameF2);
        chatbotFrame.add(flightF2);
        chatbotFrame.add(surnameL2);
        chatbotFrame.add(flightL2);

        JButton submi1tButton = new JButton("Submit");
        submit1Button.setBounds(450,300, 100, 30);
        submit1Button.setBorder(BorderFactory.createEtchedBorder());
        chatbotFrame.add(submit1Button);

        submit1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                boolean continue = med1.dataInput(surnameF2.getText(), flightF2.getText());    //Καλεί την μέθοδο του Mediator για εισαγωγή δεδομένων
                if (continue) {
                    return surnameF2.getText();
                } else {
                    System.out.println("User not found. Please try again");
                    return "";
                }
                */
                chatbotFrame.dispose();
            }
        });
    }
}
