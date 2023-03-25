package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    JComboBox bedtype;
    JCheckBox checkBox;

    SearchRoom() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Seacrh for Room");
        text.setBounds(400, 30, 300, 20);
        text.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(text);

        JLabel lblbed = new JLabel("Bed Type:");
        lblbed.setBounds(80, 100, 100, 20);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblbed);

        bedtype = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedtype.setBounds(150, 100, 150, 25);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);

        checkBox = new JCheckBox("Only display available");
        checkBox.setBounds(650, 100, 150, 25);
        checkBox.setBackground(Color.WHITE);
        add(checkBox);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availibility");
        l2.setBounds(250, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(440, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(690, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(850, 160, 100, 20);
        add(l5);

        table = new JTable();
        table.setBounds(0, 200, 1000, 200);
        add(table);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
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

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            try {
                String query1 = "select *from room where bed_type='" + bedtype.getSelectedItem() + "'";
                String query2 = "select *from room where availability='Available' AND bed_type='" + bedtype.getSelectedItem() + "' ";
                
                Conn conn=new Conn();
                ResultSet rs;
                if(checkBox.isSelected()){
                    rs=conn.s.executeQuery(query2);
                }
                else{
                    rs=conn.s.executeQuery(query1);
                }
                
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
        new SearchRoom();
    }
}
