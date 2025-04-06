package tour.and.travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class CheckPackages extends JFrame {

    CheckPackages() {
        setTitle("Explore Travel Packages");
        setBounds(300, 100, 900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.add("Package 1", wrapWithPadding(createPackagePanel(
                "Gold Package - Rs. 46000 (Winter Special)",
                new String[]{
                        "6 Days and 7 Nights",
                        "Airport Assistance",
                        "City Tour",
                        "Cruise Ride",
                        "Welcome Drink on Arrival",
                        "Buffet Breakfast and Dinner",
                        "Heated Swimming Pool Access",
                        "Ski Adventure Included"
                },
                "icons/package1.jpg",
                new Color(255, 250, 205)
        )));

        tabbedPane.add("Package 2", wrapWithPadding(createPackagePanel(
                "Silver Package - Rs. 29000 (Summer Special)",
                new String[]{
                        "4 Days and 5 Nights",
                        "Desert Safari",
                        "Camel Ride",
                        "Local Sightseeing",
                        "Free Water Bottles",
                        "City Tour by AC Coach",
                        "Evening Cultural Program",
                        "Complimentary Sunglasses"
                },
                "icons/package2.jpg",
                new Color(224, 255, 255)
        )));

        tabbedPane.add("Package 3", wrapWithPadding(createPackagePanel(
                "Bronze Package - Rs. 36000 (Monsoon Special)",
                new String[]{
                        "3 Days and 4 Nights",
                        "Beach Walk & Bonfire",
                        "Temple Visit",
                        "Local Tour Guide",
                        "Rain Dance Party",
                        "Complimentary Breakfast",
                        "Umbrella & Raincoat Included",
                        "Scenic Waterfall Visit"
                },
                "icons/package3.jpg",
                new Color(204, 255, 229)
        )));

        add(tabbedPane);
        setVisible(true);
    }

    // Wrap each panel with margin using BorderLayout and EmptyBorder
    private JPanel wrapWithPadding(JPanel innerPanel) {
        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // top, left, bottom, right
        outerPanel.add(innerPanel, BorderLayout.CENTER);
        return outerPanel;
    }

    public JPanel createPackagePanel(String title, String[] features, String imagePath, Color bgColor) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(bgColor);

        // Title
        JLabel titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 26));
        titleLabel.setForeground(new Color(102, 0, 0));
        titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Center: Info + Image
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBackground(bgColor);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // spacing between components
        gbc.anchor = GridBagConstraints.WEST;

        // Feature list
        JPanel featuresPanel = new JPanel();
        featuresPanel.setLayout(new BoxLayout(featuresPanel, BoxLayout.Y_AXIS));
        featuresPanel.setBackground(bgColor);

        for (String feature : features) {
            JLabel featureLabel = new JLabel("• " + feature);
            featureLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            featureLabel.setForeground(new Color(0, 102, 102));
            featureLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            featuresPanel.add(featureLabel);
            featuresPanel.add(Box.createVerticalStrut(5)); // space between items
        }

        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(featuresPanel, gbc);

        // Image
        try {
            ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(imagePath));
            Image image = icon.getImage().getScaledInstance(350, 250, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(image));

            gbc.gridx = 1;
            gbc.gridy = 0;
            contentPanel.add(imageLabel, gbc);
        } catch (Exception e) {
            JLabel errorLabel = new JLabel("Image not found: " + imagePath);
            errorLabel.setForeground(Color.RED);
            gbc.gridx = 1;
            gbc.gridy = 0;
            contentPanel.add(errorLabel, gbc);
        }

        panel.add(contentPanel, BorderLayout.CENTER);

        // Book Now button at bottom
        JButton bookBtn = new JButton("BOOK NOW");
        bookBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        bookBtn.setBackground(new Color(0, 153, 76));
        bookBtn.setForeground(Color.WHITE);
        bookBtn.setFocusPainted(false);
        bookBtn.setPreferredSize(new Dimension(130, 40));

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(bgColor);
        btnPanel.add(bookBtn);

        panel.add(btnPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        new CheckPackages();
    }
}
