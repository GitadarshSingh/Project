package tour.and.travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;

    public void run(){
        try{
            while(bar == null){
                Thread.sleep(10);
            }
            for(int i =1 ; i<=101; i++){
                int max = bar.getMaximum(); //100
                int value = bar.getValue();

                if(value<max){ // 101 < 100
                    bar.setValue(value+ 1);
                }else {
                    setVisible(false);
                    new Dashboard(username);

                    //new class object
                }
                Thread.sleep(30);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    Loading(String username){
        this.username =  username;


        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Tour And Travel Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);

         bar =  new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait ...");
        loading.setBounds(200,140,150,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway",Font.BOLD,35));
        add(loading);


        JLabel lblusername = new JLabel("Welcome "+ username);
        lblusername.setBounds(20,310,400,40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblusername);

        t  = new Thread(this);
        t.start();

        setVisible(true);

    }
    public static void main(String[] args) {
        new Loading("");
    }
}
