package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

    JLabel lblname, lblage, lblgender, lblsalary, lblphone, lblemail, lbladhar;
    JTextField tfname, tfage, tfsalary, tfphone, tfmail, tfadhar;
    JRadioButton rbmale, rbfemale;
    JComboBox cjob;
    JButton submit;

    AddEmployee() {
        setLayout(null);
        lblname = new JLabel("NAME :");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        lblage = new JLabel("AGE :");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        lblgender = new JLabel("GENDER :");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("serif", Font.PLAIN, 14));
        rbmale.setBackground(Color.white);
        add(rbmale);

        rbfemale = new JRadioButton("FeMale");
        rbfemale.setBounds(280, 130, 70, 30);
        rbfemale.setFont(new Font("serif", Font.PLAIN, 14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbfemale);
        bg.add(rbmale);

        JLabel lbljob = new JLabel("JOB :");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("serif", Font.PLAIN, 17));
        add(lbljob);

        String str[] = {"Front Desk Clerks", "porters", "House Keeping ", "Kitchen Staff", "Manager", "Accountant"};

        cjob = new JComboBox(str);
        cjob.setBounds(200, 180, 150, 30);
        cjob.setBackground(Color.white);
        add(cjob);

        lblsalary = new JLabel("Salary :");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);

        lblphone = new JLabel("Phone :");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);

        lblemail = new JLabel("Email :");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("serif", Font.PLAIN, 17));
        add(lblemail);

        tfmail = new JTextField();
        tfmail.setBounds(200, 330, 150, 30);
        add(tfmail);

        lbladhar = new JLabel("Adhaar :");
        lbladhar.setBounds(60, 380, 120, 30);
        lbladhar.setFont(new Font("serif", Font.PLAIN, 17));
        add(lbladhar);

        tfadhar = new JTextField();
        tfadhar.setBounds(200, 380, 150, 30);
        add(tfadhar);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);

        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 850, 540);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfsalary.getText();
        String email = tfmail.getText();
        String adhar = tfadhar.getText();

        String gender = null;

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter a valid name");
            return;
        }

        if (rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "Female";
        }

        String job = (String) cjob.getSelectedItem();

        try {
            Conn conn = new Conn();
            String query = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + job + "', '" + salary + "', '" + phone + "','" + email + "', '" + adhar + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee has been added successfully");
            setVisible(false);
        } catch (Exception e) {
            System.out.println("Wrong connection");
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
