public class ChatBotPage {
    public void openChatbotWindow() {
        JFrame chatbotFrame = new JFrame("Εξυπηρέτηση Πελατών - Chatbot");
        chatbotFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     // Κλείστε αυτό το παράθυρο όταν κλείσετε το chatbot
        chatbotFrame.setSize(600, 400);
        chatbotFrame.setVisible(true);  //Κάνει ορατό το νέο παράθυρο
        chatbotFrame.setIconImage(logo.getImage());
    }
}
