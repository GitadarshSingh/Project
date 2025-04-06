package tour.and.travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Destinations extends JFrame implements Runnable {

    Thread t1;
    JLabel l1 , l2,l3,l4,l5,l6,l7,l8,l9;
    JLabel[] label = new JLabel[]{l1 , l2,l3,l4,l5,l6,l7,l8,l9 };
    JLabel caption;

    public void run() {
        String[] text = {
                "JW Marriott Hotel", "Madarin Oriental Hotel", "Four Seasons Hotels",
                "Raddisson Blue Hotel", "Classsio Hotel", "The Bay Club Hotel",
                "Breeze blow Hotel", "The Taj Hotel", "Happy Morning Motel", "River View Hotel"
        };

        try {
            for (int i = 0; i < label.length; i++) {
                if (label[i] != null) {
                    label[i].setVisible(true);
//                    caption.setText(text[i]);
                    Thread.sleep(2500);
                    label[i].setVisible(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Destinations() {
        setBounds(500, 200, 800, 600);
        setLayout(null);

        caption = new JLabel();
        caption.setBounds(50, 500, 1000, 70);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        caption.setForeground(Color.WHITE);
        add(caption);

        // Supported extensions
        String[] extensions = {".jpg", ".jpeg", ".png"};

        for (int i = 0; i < label.length; i++) {
            boolean loaded = false;

            for (String ext : extensions) {
                String path = "icons/dest" + (i + 1) + ext;
                URL imgURL = ClassLoader.getSystemResource(path);

                if (imgURL != null) {
                    ImageIcon image = new ImageIcon(imgURL);
                    Image scaledImage = image.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
                    ImageIcon finalIcon = new ImageIcon(scaledImage);

                    label[i] = new JLabel(finalIcon);
                    label[i].setBounds(0, 0, 800, 600);
                    label[i].setVisible(false);
                    add(label[i]);
                    loaded = true;
                    break;
                }
            }

            if (!loaded) {
                System.err.println("Image not found for index: " + (i + 1));
                label[i] = null;
            }
        }

        t1 = new Thread(this);
        t1.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Destinations();
    }
}
