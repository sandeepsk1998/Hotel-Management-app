package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener {

    JLabel heading, lblroomNo, lblavailable,lblclean,lblPrice,lbltype;

    JTextField tfRoom,tfPrice;
    JComboBox availableCombo,cleanCombo,typeCombo;
    JButton add,cancel;

    AddRooms() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        lblroomNo = new JLabel("Room Number");
        lblroomNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblroomNo.setBounds(60, 80, 120, 30);
        add(lblroomNo);

        tfRoom = new JTextField();
        tfRoom.setBounds(200, 80, 150, 30);
        add(tfRoom);

        lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);
        
        String availableOption[]={"Available","Occupied"};
        availableCombo = new JComboBox(availableOption);
        availableCombo.setBounds(200,130,150,30);
        availableCombo.setBackground(Color.white);
        add(availableCombo);
        

        lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);
        
        String cleanOption[]={"Cleaned","Not Cleaned"};
        cleanCombo = new JComboBox(cleanOption);
        cleanCombo.setBounds(200,180,150,30);
        cleanCombo.setBackground(Color.white);
        add(cleanCombo);
        
         lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPrice.setBounds(60, 230, 120, 30);
        add(lblPrice);
        
        tfPrice = new JTextField();
        tfPrice.setBounds(200, 230, 150, 30);
        add(tfPrice);
        
        lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltype.setBounds(60, 280, 120, 30);
        add(lbltype);
        
        String typeOption[]={"Single Bed","Double Bed"};
        typeCombo = new JComboBox(typeOption);
        typeCombo.setBounds(200,280,150,30);
        typeCombo.setBackground(Color.white);
        add(typeCombo);
        
        add= new JButton("Add Room");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        

        setBounds(330, 200, 940, 470);
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource()==add){
            String roomnumber = tfRoom.getText();
            String availability = (String) availableCombo.getSelectedItem();
            String status = (String) cleanCombo.getSelectedItem();
            String price= tfPrice.getText();
            String type = (String) typeCombo.getSelectedItem();
            
            try{
                Conn conn=new Conn();
                 String query = "INSERT INTO room values( '" + roomnumber + "', '" + availability + "', '" + status + "','" + price + "', '" + type + "')";
                 conn.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null, "Your has been added successfully");
            
            }
            catch(Exception e){
                 System.out.println("Wrong connection");
                 e.printStackTrace();
            }
            
            
        }
        else if (ae.getSource()==cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }

    
}
