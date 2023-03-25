package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener {

    JLabel heading, lblname, lblAge, lblgender, lblbrand, lbltype,lblavailable,lbllocation;

    JTextField tfname, tfage,tfbrand,tfmodel,tflocation;
    JComboBox availableCombo, genderCombo;
    JButton add, cancel;

    AddDriver() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        heading = new JLabel("Add Driver");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        lblname = new JLabel("Name :");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setBounds(60, 80, 120, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 30);
        add(tfname);

        lblAge = new JLabel("Age :");
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAge.setBounds(60, 130, 120, 30);
        add(lblAge);

        tfage = new JTextField();
        tfage.setBounds(200, 130, 150, 30);
        add(tfage);

        lblgender = new JLabel("Gender :");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setBounds(60, 180, 120, 30);
        add(lblgender);

        String driverOption[] = {"Male", "Female"};
        genderCombo = new JComboBox(driverOption);
        genderCombo.setBounds(200, 180, 150, 30);
        genderCombo.setBackground(Color.white);
        add(genderCombo);

        lblbrand = new JLabel("Car Brand:");
        lblbrand.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblbrand.setBounds(60, 230, 120, 30);
        add(lblbrand);

       tfbrand = new JTextField();
       tfbrand.setBounds(200, 230, 150, 30);
        add(tfbrand);

        lbltype = new JLabel("Car Model :");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltype.setBounds(60, 280, 120, 30);
        add(lbltype);

        tfmodel=new JTextField();
        tfmodel.setBounds(200, 280, 150, 30);
       // tfmodel.setBackground(Color.white);
        add(tfmodel);
        
         lblavailable = new JLabel("Available :");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 330, 120, 30);
        add(lblavailable);
        
        String driveravailability[] = {"Available", "Not Available"};
        availableCombo = new JComboBox(driveravailability);
        availableCombo.setBounds(200, 330, 150, 30);
        availableCombo.setBackground(Color.white);
        add(availableCombo);
        
        lbllocation=new JLabel();
         lbllocation = new JLabel("Location:");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbllocation.setBounds(60, 380, 120, 30);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(200, 380, 150, 30);
        add(tflocation);
        
     
        add = new JButton("Add Driver");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(60, 430, 130, 30);
        add.addActionListener(this);
        add(add);
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220, 430, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setBounds(330, 200, 980, 520);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {
            String name = tfname.getText();
            String age = tfage.getText();
            String gender=(String) genderCombo.getSelectedItem();
            String brand = tfbrand.getText();
            String model = tfmodel.getText();
            String available = (String) availableCombo.getSelectedItem();
            String location = tflocation.getText();

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO driver values( '" + name + "', '" + age + "', '" + gender + "','" + brand + "', '" + model + "','"+available+"','"+location +"')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Your driver has been added successfully");

            } catch (Exception e) {
                System.out.println("Wrong connection");
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }

}
