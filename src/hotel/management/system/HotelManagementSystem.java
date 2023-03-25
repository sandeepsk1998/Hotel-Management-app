package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem() {
//      setSize(1366,565);    // frame ka size
//      setLocation(100,100); // frame ka location
//      
        setBounds(100, 100, 1355, 565);

        // Adding image top of the Frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565); // locationX , locationY, length, breadth
        add(image);
        JLabel text = new JLabel("Hotel Management System");
        text.setForeground(Color.WHITE);
        text.setBounds(20, 430, 1000, 90);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.white);
        next.setForeground(Color.blue);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 25));
        image.add(next);

        setVisible(true); //for human visible

        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        }
    
        public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
        
        
    

    public static void main(String[] args) {
        new HotelManagementSystem();
    }

}
