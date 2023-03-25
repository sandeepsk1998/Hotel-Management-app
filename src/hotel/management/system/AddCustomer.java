package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel text, lblid, lblnumber, lblname,
            lblgender, lblcountry, checkintime,
            lbldeposit;
    JComboBox comboid;
    JRadioButton rMale, rFemale;
    JTextField tfnumber, tfname, tfcountry, tfdeposit;
    Choice croom;
    JButton addcustomer,back;

    AddCustomer() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        text = new JLabel("New Customer Form");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(text);

        lblid = new JLabel("ID : ");
        lblid.setBounds(35, 80, 100, 20);
        lblid.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(lblid);

        String options[] = {"Adhar", "DL", "PAN Card", "Passport"};
        comboid = new JComboBox(options);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        lblnumber = new JLabel("Number : ");
        lblnumber.setBounds(35, 120, 100, 20);
        lblnumber.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200, 120, 150, 25);
        tfnumber.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(tfnumber);

        lblname = new JLabel("Name : ");
        lblname.setBounds(35, 160, 100, 20);
        lblname.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        tfname.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(tfname);

        lblgender = new JLabel("Gender : ");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(lblgender);

        rMale = new JRadioButton("Male");
        rMale.setBackground(Color.WHITE);
        rMale.setBounds(200, 200, 60, 25);
        add(rMale);

        rFemale = new JRadioButton("Female");
        rFemale.setBackground(Color.WHITE);
        rFemale.setBounds(270, 200, 100, 25);
        add(rFemale);

        lblcountry = new JLabel("Country : ");
        lblcountry.setBounds(35, 240, 100, 20);
        lblcountry.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        tfcountry.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(tfcountry);

        JLabel lblroom = new JLabel("Allocated Room");
        lblroom.setBounds(35, 280, 150, 20);
        lblroom.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(lblroom);

        croom = new Choice();
        try {
            Conn conn = new Conn();
            String query = "select * from room where availability='Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        croom.setBounds(200, 280, 150, 25);
        add(croom);

        //////////////////////
        JLabel lbltime = new JLabel("Chek-in time : ");
        lbltime.setBounds(35, 320, 150, 20);
        lbltime.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(lbltime);

        //////////////////////
        Date date = new Date();
        checkintime = new JLabel("" + date);
        checkintime.setBounds(200, 320, 300, 20);
        checkintime.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(checkintime);

        lbldeposit = new JLabel("Deposit : ");
        lbldeposit.setBounds(35, 360, 100, 20);
        lbldeposit.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 360, 150, 25);
        tfdeposit.setFont(new Font("Ralway", Font.PLAIN, 20));
        add(tfdeposit);

        addcustomer = new JButton("Add Customer");
        addcustomer.setBackground(Color.BLACK);
        addcustomer.setForeground(Color.WHITE);
        addcustomer.setBounds(50, 410, 120, 30);
        addcustomer.addActionListener(this);
        add(addcustomer);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(180, 410, 120, 30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);

        setBounds(350, 200, 800, 550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == addcustomer){
            
            String id= (String) comboid.getSelectedItem();
            String number=tfnumber.getText();
            String name=tfname.getText();
            String gender=null;
            if(rMale.isSelected()){
                gender="Male";
            }else{
                gender="Female";
            }
            
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String checkIntime=checkintime.getText();
            String customercol=tfdeposit.getText();
             try{
                Conn conn=new Conn();
                 String query = "INSERT INTO customer values( '" + id + "', '" + number + "', '" + name + "','" + gender + "', '" + country + "','" + room + "','" + checkIntime + "', '" + customercol + "')";
                String query2="update room set availability='Occupied' where roomnumber='" + room + "'";
                 
                 conn.s.executeUpdate(query);
                 conn.s.executeUpdate(query2);
                 
                 
                 JOptionPane.showMessageDialog(null, "New Cutomer added successfully");
                 setVisible(false);
                 new Reception();
            
            }
            catch(Exception e){
                 System.out.println("Wrong connection");
                 e.printStackTrace();
            }
            
        }else if(ae.getSource() == back){
             setVisible(false);
                 new Reception();
        }
        
    }

    public static void main(String[] args) {
        new AddCustomer();
    }

}
