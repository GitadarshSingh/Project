package tour.and.travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame {
    Choice chotel, cac;
    JComboBox<String> cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelid, labelnumber, labelname, labelprice, labelphone;
    JButton checkprice, bookpackage, back;

    BookHotel(String username) {
        this.username = username;

        setBounds(350, 200, 1000, 660);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100, 10, 300, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 150, 20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(220, 70, 150, 20);
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(220, 110, 150, 25);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpersons.setBounds(40, 150, 150, 25);
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(220, 150, 150, 25);
        add(tfpersons);

        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldays.setBounds(40, 190, 150, 25);
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(220, 190, 150, 25);
        add(tfdays);

        JLabel lblac = new JLabel("AC / Non-AC");
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblac.setBounds(40, 230, 150, 25);
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(220, 230, 150, 25);
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfood.setBounds(40, 270, 150, 25);
        add(lblfood);

        cfood = new JComboBox<>(new String[]{"Yes", "No"});
        cfood.setBounds(220, 270, 150, 25);
        add(cfood);

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 310, 150, 20);
        add(lblid);

        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelid.setBounds(220, 310, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 350, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelnumber.setBounds(220, 350, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 390, 150, 25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelphone.setBounds(220, 390, 150, 25);
        add(labelphone);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setBounds(40, 430, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelname.setBounds(220, 430, 150, 25);
        add(labelname);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotal.setBounds(40, 470, 150, 25);
        add(lbltotal);

        labelprice = new JLabel("Rs 0");
        labelprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelprice.setBounds(220, 470, 150, 25);
        add(labelprice);

        // Load customer data
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer where username = '" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelphone.setText(rs.getString("phone"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 520, 120, 25);
        checkprice.addActionListener(e -> {
            String hotel = chotel.getSelectedItem();
            int cost = 0;
            if (hotel.equals("Taj Hotel")) cost = 4600;
            else if (hotel.equals("Oberoi Grand")) cost = 2900;
            else cost = 3600;

            int persons = Integer.parseInt(tfpersons.getText());
            int days = Integer.parseInt(tfdays.getText());

            cost *= persons * days;

            if (cac.getSelectedItem().equals("AC")) cost += 1000;
            if (cfood.getSelectedItem().equals("Yes")) cost += 1500;

            labelprice.setText("Rs " + cost);
        });
        add(checkprice);

        bookpackage = new JButton("Book Hotel");
        bookpackage.setBounds(200, 520, 140, 25);
        bookpackage.addActionListener(e -> {
            try {
                Conn c = new Conn();
                String insert = "INSERT INTO bookhotel VALUES('" + username + "', '" + chotel.getSelectedItem() + "', '" +
                        tfpersons.getText() + "', '" + tfdays.getText() + "', '" + cac.getSelectedItem() + "', '" +
                        cfood.getSelectedItem() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" +
                        labelphone.getText() + "', '" + labelprice.getText() + "')";
                c.s.executeUpdate(insert);

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        add(bookpackage);

        back = new JButton("Back");
        back.setBounds(370, 520, 100, 25);
        back.addActionListener(e -> setVisible(false));
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_AREA_AVERAGING);

        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 80, 500, 300);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {

        new BookHotel("Adarsh");
    }
}
