package tour.and.travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    JButton back;

    About() {
        setBounds(400, 100, 600, 600);
        setTitle("About - Tour and Travel Management System");
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255)); // Alice Blue

        JLabel heading = new JLabel("About the Project");
        heading.setBounds(170, 10, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        heading.setForeground(new Color(25, 25, 112)); // Midnight Blue
        add(heading);

        String info = "Project Title: Tour and Travel Management System\n\n" +
                "🔍 Overview:\n" +
                "A desktop-based Java application designed to manage travel bookings including hotels\n" +
                "and packages with features like payment simulation, booking history, and real-time data storage.\n\n" +
                "🛠️ Technologies Used:\n" +
                "- Java (Swing, AWT): GUI development\n" +
                "- MySQL: Backend database\n" +
                "- JDBC: Java Database Connectivity\n" +
                "- JEditorPane: Web content embedding (Paytm Simulation)\n\n" +
                "📚 Key Functionalities:\n" +
                "- User Signup/Login & Profile Management\n" +
                "- Hotel & Package Booking with cost calculator\n" +
                "- Booking History Viewing\n" +
                "- Simulated Payment Page (via Paytm)\n" +
                "- Dynamic image-loaded dashboard UI\n\n" +
                "🧠 Technical Concepts Implemented:\n" +
                "- Object-Oriented Programming (OOP)\n" +
                "- Exception Handling for stability\n" +
                "- Event-Driven Programming with ActionListeners\n" +
                "- Image Scaling & Custom UI Design\n" +
                "- Modular and Scalable Architecture\n\n" +
                "🚀 Future Scope:\n" +
                "- Admin Dashboard for analytics\n" +
                "- Email Notifications using JavaMail\n" +
                "- Real Payment Gateway (Stripe/Razorpay)\n" +
                "- Mobile App version in Flutter/Android\n" +
                "- AI-based Travel Recommendations\n\n" +
                "📌 Note: This project is built for educational/demo purposes and demonstrates\n" +
                "a mini real-world travel management experience.";

        TextArea area = new TextArea(info, 10, 40, Scrollbar.VERTICAL);
        area.setFont(new Font("Arial", Font.PLAIN, 14));
        area.setEditable(false);
        area.setBackground(Color.WHITE);
        area.setBounds(30, 60, 520, 400);
        add(area);

        back = new JButton("Back");
        back.setBounds(230, 480, 120, 35);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBackground(new Color(70, 130, 180)); // Steel Blue
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        // You can navigate to your previous screen here
        // Example: new Dashboard(); // if you have a dashboard class
    }

    public static void main(String[] args) {
        new About();
    }
}
