package tour.and.travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackages extends JFrame implements ActionListener {

    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername, labelid, labelnumber, labelname, labelgender, labelprice,labelphone;
    JButton checkprice, bookpackage, back;

    BookPackages(String username) {
        this.username = username;

        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel text = new JLabel("BOOK PACKAGES");
        text.setBounds(100, 10, 300, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 150, 20);
        add(lblusername);

        labelusername = new JLabel(username);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(220, 70, 150, 20);
        add(labelusername);


        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(220, 110, 150, 25);
        add(cpackage);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpersons.setBounds(40, 150, 150, 25);
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(220, 150, 150, 25);
        add(tfpersons);

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 190, 150, 20);
        add(lblid);

        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelid.setBounds(220, 190, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 230, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelnumber.setBounds(220, 230, 150, 25);
        add(labelnumber);

        JLabel lblhone = new JLabel("Phone");
        lblhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblhone.setBounds(40, 270, 150, 25);
        add(lblhone);

        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelphone.setBounds(220, 270, 150, 25);
        add(labelphone);


        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setBounds(40, 310, 150, 25);
        add(lblname);

        labelname = new JLabel(); // <-- this is critical
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelname.setBounds(220, 310, 150, 25);
        add(labelname);


        ////////////////////////

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotal.setBounds(40, 350, 150, 25);
        add(lbltotal);

        labelprice = new JLabel("Rs 0");
        labelprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelprice.setBounds(220, 350, 150, 25);
        add(labelprice);
///////

        try{
            Conn  conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelphone.setText(rs.getString("phone"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }

        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 400, 120, 25);
        checkprice.addActionListener(e -> {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")) cost = 46000;
            else if (pack.equals("Silver Package")) cost = 29000;
            else cost = 36000;

            int persons = Integer.parseInt(tfpersons.getText());
            int total = cost * persons;
            labelprice.setText("Rs " + total);
        });
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(200, 400, 140, 25);
        bookpackage.addActionListener(e -> {
            try {
                Conn c = new Conn();
                String query = "CREATE TABLE IF NOT EXISTS bookpackage (" +
                        "username VARCHAR(20), " +
                        "package VARCHAR(30), " +
                        "persons INT, " +
                        "id VARCHAR(30), " +
                        "number VARCHAR(30), " +
                        "phone VARCHAR(20), " +
                        "price VARCHAR(20))";
                c.s.executeUpdate(query);

                String insert = "INSERT INTO bookpackage VALUES('" + username + "', '" + cpackage.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelname.getText() + "', '" + labelprice.getText() + "')";
                c.s.executeUpdate(insert);

                JOptionPane.showMessageDialog(null, "Package Booked Successfully!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        add(bookpackage);

        back = new JButton("Back");
        back.setBounds(370, 400, 100, 25);
        back.addActionListener(e -> setVisible(false));
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {

        new BookPackages("Adarsh");
    }

    public void actionPerformed(ActionEvent ae) {
        bookpackage.addActionListener(this);

    }
}
