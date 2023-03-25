package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {

    JLabel text, lblid, lblroom, lblname, lblclean, lblamtpaid, lblpending;
    Choice cCustomer;
    JTextField tfroom, tfavailable, tfclean, tfpaid, tfpending;

    JButton check, update, back;

    UpdateRoom() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setForeground(Color.BLUE);
        text.setBounds(30, 20, 250, 30);
        add(text);

        lblid = new JLabel("Customer ID");
        lblid.setBounds(30, 80, 150, 20);
        add(lblid);

        cCustomer = new Choice();
        cCustomer.setBounds(200, 80, 100, 25);
        add(cCustomer);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                cCustomer.add(rs.getString("number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 120, 100, 20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        add(tfroom);

        lblname = new JLabel("Availability");
        lblname.setBounds(30, 160, 100, 20);
        add(lblname);

        tfavailable = new JTextField();
        tfavailable.setBounds(200, 160, 150, 25);
        add(tfavailable);

        lblclean = new JLabel("Cleaning Status");
        lblclean.setBounds(30, 200, 100, 20);
        add(lblclean);

        tfclean = new JTextField();
        tfclean.setBounds(200, 200, 150, 25);
        add(tfclean);

        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 300, 100, 30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.setBounds(160, 300, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(290, 300, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 500, 400);
        add(image);

        setBounds(300, 200, 980, 500);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == check) {
            String id = cCustomer.getSelectedItem();
            String query = "select * from customer where number='" + id + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));

                }

                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    tfavailable.setText(rs2.getString("availability"));
                    tfclean.setText(rs2.getString("cleaning_status"));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {

            String number = cCustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String clean = tfclean.getText();

            try {

                Conn c = new Conn();
                c.s.executeUpdate("update room set availability='" + available + "',cleaning_status='" + clean + "'  where roomnumber='" + room + "'");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new UpdateRoom();
    }

}
