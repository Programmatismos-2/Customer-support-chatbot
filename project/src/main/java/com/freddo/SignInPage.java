package project.src.main.java.com.freddo;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SignInPage {
    //Mediator med1 = new Mediator();    //Φτιάχνει αντικείμενο από την Mediator Class
    public String openSignInWindow() {
        JFrame signinFrame = new JFrame("Sign In - Σύνδεση");
        signinFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     // Κλείστε αυτό το παράθυρο όταν κλείσετε το chatbot
        signinFrame.setSize(600, 400);
        signinFrame.setVisible(true);  //Κάνει ορατό το νέο παράθυρο
        signinFrame.setIconImage(logo.getImage());
        signinFrame.setLayout(null);
        
        JTextField surnameF2 = new JTextField();
        JTextField flightF2 = new JTextField();
        JLabel surnameL2 = new JLabel("Surname");
        JLabel flightL2 = new JLabel("Flight Number");

        surnameF2.setBounds(200, 140, 200, 30);
        flightF2.setBounds(200, 200, 200, 30);
        surnameL2.setBounds(50, 140, 200, 30);
        flightL2.setBounds(50, 200, 200, 30);

        signinFrame.add(surnameF2);
        signinFrame.add(flightF2);
        signinFrame.add(surnameL2);
        signinFrame.add(flightL2);

        JButton submi1tButton = new JButton("Submit");
        submit1Button.setBounds(450,300, 100, 30);
        submit1Button.setBorder(BorderFactory.createEtchedBorder());
        signinFrame.add(submit1Button);

        submit1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean cont = med1.FindStringInFile(surnameF2.getText(), flightF2.getText());    //Καλεί την μέθοδο του Mediator για αναζήτηση δεδομένων
                if (cont) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new Chatbot(surnameF2.getText()).setVisible(true);
                        }
                    });
                } else {
                    CheckInPage chpage = new CheckInPage();
                    chpage.opencheckWindow(0);
                }
                signinFrame.dispose();
            }
        });
    }
}
