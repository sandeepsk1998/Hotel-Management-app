package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Department() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

       

        JLabel l1 = new JLabel("Department");
        l1.setBounds(180, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBounds(450, 10, 100, 20);
        add(l2);

        table = new JTable();
        table.setBounds(0, 40, 700, 300);
        add(table);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            //System.out.println("Wrong connection");
            e.printStackTrace();

        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(280, 400, 120, 30);
        back.addActionListener(this);
        add(back);

        setBounds(400, 200, 700, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Department();
    }
}
