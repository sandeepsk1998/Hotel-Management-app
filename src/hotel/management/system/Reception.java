package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Reception extends JFrame implements ActionListener {

    JButton newcustomer, room, department, employee, customerinfo,
            managerinfo, update, checkout, roomStatus, receive, searchroom, logout;

    Reception() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        newcustomer = new JButton("New Customer");
        newcustomer.setBounds(10, 30, 200, 30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);

        room = new JButton("Rooms");
        room.setBounds(10, 70, 200, 30);
        room.setBackground(Color.BLACK);
        room.setForeground(Color.WHITE);
        room.addActionListener(this);
        add(room);

        department = new JButton("Deparment");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);

        employee = new JButton("All Employeses");
        employee.setBounds(10, 150, 200, 30);
        employee.setBackground(Color.BLACK);
        employee.setForeground(Color.WHITE);
        employee.addActionListener(this);
        add(employee);

        customerinfo = new JButton("Customer Info..");
        customerinfo.setBounds(10, 190, 200, 30);
        customerinfo.setBackground(Color.BLACK);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.addActionListener(this);
        add(customerinfo);

        managerinfo = new JButton("Manager Info");
        managerinfo.setBounds(10, 230, 200, 30);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.addActionListener(this);
        add(managerinfo);

        checkout = new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        update = new JButton("Update Status");
        update.setBounds(10, 310, 200, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        roomStatus = new JButton("Room Status");
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);

        receive = new JButton("Pickup Service");
        receive.setBounds(10, 390, 200, 30);
        receive.setBackground(Color.BLACK);
        receive.setForeground(Color.WHITE);
        receive.addActionListener(this);
        add(receive);

        searchroom = new JButton("Search Room");
        searchroom.setBounds(10, 430, 200, 30);
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.addActionListener(this);
        add(searchroom);

        logout = new JButton("Log Out");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        // Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        //  ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);

        setBounds(330, 200, 800, 570);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newcustomer) {
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == room) {
            setVisible(false);
            new Room();
        } else if (ae.getSource() == department) {
            setVisible(false);
            new Department();
        } else if (ae.getSource() == employee) {
            setVisible(false);
            new EmployeeInfo();
        } else if (ae.getSource() == managerinfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getSource() == customerinfo) {
            setVisible(false);
            new CustomerInfo();
        } else if (ae.getSource() == searchroom) {
            setVisible(false);
            new SearchRoom();

        } else if (ae.getSource() == receive) {
            setVisible(false);
            new PickupService();

        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateCheck();

        } else if (ae.getSource() == roomStatus) {
            setVisible(false);
            new UpdateRoom();
        } else if (ae.getSource() == checkout) {
            setVisible(false);
            new CheckOut();
        } else if (ae.getSource() == logout) {
            setVisible(false);
            System.exit(0);
        }

    }

    public static void main(String[] asrgs) {
        new Reception();
    }
}
