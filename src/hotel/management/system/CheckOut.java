package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.*;

public class CheckOut extends JFrame implements ActionListener {

    JLabel text, lblid, lblroom, lblcheckin, lblcheckintime,
            lblcheckout, lblcheckouttime, lblroomnumber;

    Choice cCustomer;
    JButton checkout, update, back;

    CheckOut() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        text = new JLabel("CheckOut");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setForeground(Color.BLUE);
        text.setBounds(100, 20, 200, 30);
        add(text);

        lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);

        cCustomer = new Choice();
        cCustomer.setBounds(150, 80, 100, 25);
        add(cCustomer);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JButton i4 = new JButton(i3);
        i4.setBounds(290, 82, 20, 20);
        add(i4);

        lblroom = new JLabel("Room");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);

        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150, 130, 150, 30);
        add(lblroomnumber);

        lblcheckin = new JLabel("CheckIn Time");
        lblcheckin.setBounds(30, 180, 100, 30);
        add(lblcheckin);

        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150, 180, 150, 30);
        add(lblcheckintime);

        lblcheckout = new JLabel("CheckOut Time");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);

        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150, 230, 200, 30);
        add(lblcheckouttime);

        checkout = new JButton("CheckOut");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30, 300, 100, 30);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(160, 300, 100, 30);
        checkout.addActionListener(this);
        add(back);

        ImageIcon i40 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i40.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350, 50, 400, 250);
        add(image);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                cCustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkIntime"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setBounds(300, 200, 800, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == checkout) {

            String q1 = "delete from customer where number='" + cCustomer + "'";
            String q2 = "update room set availability='Available' where roomnumber='" + lblroomnumber.getText() + "'";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "CheckOut Done");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] asrgs) {
        new CheckOut();
    }
}
