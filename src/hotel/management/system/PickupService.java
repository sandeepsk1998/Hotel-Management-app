package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class PickupService extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    Choice choiceofcar;

    PickupService() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Pick Up Service");
        text.setBounds(400, 30, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(text);

        JLabel lblbed = new JLabel("Type od Car:");
        lblbed.setBounds(50, 100, 100, 20);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblbed);

        choiceofcar = new Choice();
        choiceofcar.setBounds(150, 100, 200, 25);
        add(choiceofcar);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while (rs.next()) {
                choiceofcar.add(rs.getString("brand"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel l1 = new JLabel("Name");
        l1.setBounds(50, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(190, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(350, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Brand");
        l4.setBounds(480, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Model");
        l5.setBounds(610, 160, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Available");
        l6.setBounds(730, 160, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setBounds(860, 160, 100, 20);
        add(l7);

        table = new JTable();
        table.setBounds(0, 200, 1000, 200);
        add(table);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
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

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(400, 500, 120, 30);
        submit.addActionListener(this);
        add(submit);

        setBounds(300, 200, 1100, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            try {
                String query1 = "select *from driver where brand='" + choiceofcar.getSelectedItem() + "'";

                Conn conn = new Conn();
                ResultSet rs;

                    rs = conn.s.executeQuery(query1);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                

            } catch (Exception e) {
                //System.out.println("Wrong connection");
                e.printStackTrace();

            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new PickupService();
    }
}
