package tour.and.travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {

    JButton back;

    Paytm() {
        setBounds(500, 200, 800, 600);
        setLayout(new BorderLayout());

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);

        try {
            pane.setPage("https://paytm.com/rent-payment");
        } catch (Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
        }

        JScrollPane sp = new JScrollPane(pane);
        add(sp, BorderLayout.CENTER);

        back = new JButton("Back");
        back.setBounds(10, 10, 80, 30);
        back.addActionListener(this);

        // Create a panel to hold the back button
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(800, 50));
        panel.add(back);

        add(panel, BorderLayout.NORTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Payment();
        }
    }

    public static void main(String[] args) {
        new Paytm();
    }
}
