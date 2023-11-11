public class CheckInPage {
    public void opencheckWindow() {
        JFrame checkFrame = new JFrame("Check-In");
        checkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   // Κλείστε αυτό το παράθυρο όταν κλείσετε την επιλογή κρατήσεων
        checkFrame.setSize(600, 400);
        checkFrame.setVisible(true);    //Κάνει ορατό το νέο παράθυρο
        checkFrame.setLayout(null);
        checkFrame.setIconImage(logo.getImage());

        JTextField nameF = new JTextField();
        JTextField surnameF = new JTextField();
        JTextField flightF = new JTextField();
        JTextField emailF = new JTextField();
        
        JLabel nameL1 = new JLabel("Name"); 
        JLabel surnameL1 = new JLabel("Surname");
        JLabel flightL1 = new JLabel("Flight Number");
        JLabel emailL1 = new JLabel("Email");



        nameL1.setBounds(50, 50, 100, 30);
        surnameL1.setBounds(50, 110, 100, 30);
        flightL1.setBounds(50, 170, 100, 30);
        emailL1.setBounds(50, 230, 100, 30);

        nameF.setBounds(200, 50, 200, 30);
        surnameF.setBounds(200, 110, 200, 30);
        flightF.setBounds(200, 170, 200, 30);
        emailF.setBounds(200, 230, 200, 30);
        
        
        checkFrame.add(nameL1);
        checkFrame.add(surnameL1);
        checkFrame.add(flightL1);
        checkFrame.add(emailL1);

        checkFrame.add(nameF);
        checkFrame.add(surnameF);
        checkFrame.add(flightF);
        checkFrame.add(emailF);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(450,300, 100, 30);
        submitButton.setBorder(BorderFactory.createEtchedBorder());
        checkFrame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Mediator med = new Mediator();    //Φτιάχνει αντικείμενο από την Mediator Class
                med.dataInput(nameF.getText(), surnameF.getText(), flightF.getText(), emailF.getText());    //Καλεί την μέθοδο του Mediator για εισαγωγή δεδομένων
                */
                checkFrame.setVisible(false);
            }
        });
    }
}
