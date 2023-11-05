import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Home_Page {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Αρχικό Παράθυρο");   //Βαζει τιτλο στο frame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Κλεινει το παραθυρο οταν καποιος παταει το x
        mainFrame.setSize(800, 500);    //Καθορίζει το μέγεθος του παραθυρου 
        mainFrame.setLayout(new FlowLayout());      //Προσδιορίζει το είδος του layout που εχει το frame

        ImageIcon logo = new ImageIcon("C:/Users/first/Downloads/Sky Logo.png");    //Αυτο το path θα πρεπει να αλλάξει ώστε η εικόνα να βρίσκεται στον κοινό φάκελο με το project
        mainFrame.setIconImage(logo.getImage());    //Θέτει την εικονα με το παραπανω path σαν logo του παραθύρου
        mainFrame.getContentPane().setBackground(new Color(0,220,250));     //Προσδιορίζει το χρώμα του background


        JButton chatbotButton = new JButton("Εξυπηρέτηση Πελατών");     //Φτιάχνει κουμπί με όνομα "Εξυπηρέτηση Πελατών"
        JButton flightBookingButton = new JButton("Κράτηση Εισιτηρίων Πτήσης");     //Φτιάχνει κουμπί με όνομα "Κράτηση Εισιτηρίων Πτήσης"
        
        chatbotButton.setBounds(100, 100, 350, 200);    //Προσδιορίζει το μέγεθος του κουμπιου
        flightBookingButton.setBounds(100, 100, 350, 200);  //Προσδιορίζει το μέγεθος του κουμπιου
        chatbotButton.setBorder(BorderFactory.createEtchedBorder());
        flightBookingButton.setBorder(BorderFactory.createEtchedBorder());
        
        
        ImageIcon chatIcon = new ImageIcon("C:/Users/first/Pictures/chatbot.jpg");  //Αυτο το path θα πρεπει να αλλάξει ώστε η εικόνα να βρίσκεται στον κοινό φάκελο με το project
        chatbotButton.setIcon(chatIcon);    //Βάζει φωτογραφία δίπλα από το κάθε κουμπι
        ImageIcon bookIcon = new ImageIcon("C:/Users/first/Pictures/Plane.png");    //Αυτο το path θα πρεπει να αλλάξει ώστε η εικόνα να βρίσκεται στον κοινό φάκελο με το project
        flightBookingButton.setIcon(bookIcon);  //Βάζει φωτογραφία δίπλα από το κάθε κουμπι

        chatbotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openChatbotWindow();   //Ανοίγει το παραθυρο που ευθύνεται για το chatbot 
            }
        });
        flightBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFlightBookingWindow();   //Ανοίγει το παράθυρο που ευθύνεται για τις κρατήσεις
            }
        });
        
        mainFrame.add(chatbotButton);       //Προσθέτει το chatbotButton στο frame
        mainFrame.add(flightBookingButton);     //Προσθέτει το flightBookingButton στο frame
        mainFrame.setVisible(true);     //Εμφανίζει τα componets στο παραθυρο
    }



}