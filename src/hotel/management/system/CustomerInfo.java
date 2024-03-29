package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    CustomerInfo() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1 = new JLabel("Id");
        l1.setBounds(40, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Number");
        l2.setBounds(170, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(290, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(400, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(530, 10, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Room");
        l6.setBounds(650, 10, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Check-In");
        l7.setBounds(770, 10, 100, 20);
        add(l7);

        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(890, 10, 100, 20);
        add(l8);

        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer ");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            //System.out.println("Wrong connection");
            e.printStackTrace();

        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 500, 120, 30);
        back.addActionListener(this);
        add(back);

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}
