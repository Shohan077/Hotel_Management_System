package javaclasses;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.io.File;  
import java.io.IOException; 
import java.io.FileWriter;
import java.io.*;
import java.nio.file.*;
import static javax.swing.JOptionPane.showMessageDialog;



public class NewCustomer implements ActionListener
{
	private JLabel name,nid,address,phone;
	private JTextField nameField,nidField,addressField,phoneField;
	private JButton submit,back;
	JFrame frame;
	public NewCustomer()
   {
      frame= new JFrame();
	  
	  name = new JLabel("Customer Name");
	  name.setBounds(30,30,200,30);
	  name.setFont(new Font("Tahoma", Font.PLAIN, 20));
	  name.setForeground(Color.white);
	  frame.add(name);
	  
	  nameField = new JTextField();
	  nameField.setBounds(250,30,150,30);
	  
	  frame.add(nameField);
	  
	  
	  nid = new JLabel("NID Number");
	  nid.setBounds(30,80,200,30);
	  nid.setFont(new Font("Tahoma", Font.PLAIN, 20));
	  nid.setForeground(Color.white);
	  frame.add(nid);
	  
	  nidField = new JTextField();
	  nidField.setBounds(250,80,150,30);
	  frame.add(nidField);
	  
	  address = new JLabel("Customer Address");
	  address.setBounds(30,130,200,30);
	  address.setFont(new Font("Tahoma", Font.PLAIN, 20));
	  address.setForeground(Color.white);
	  frame.add(address);
	  
	  addressField = new JTextField();
	  addressField.setBounds(250,130,150,30);
	  frame.add(addressField);
	  
	  phone = new JLabel("Phone Number");
	  phone.setBounds(30,180,200,30);
	  phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
	  phone.setForeground(Color.white);
	  frame.add(phone);
	  
	  phoneField = new JTextField();
	  phoneField.setBounds(250,180,150,30);
	  frame.add(phoneField);
	  
	  submit = new JButton("Submit");
	  submit.setBounds(30,250,150,30);
	  submit.setForeground(Color.white);
      submit.setBackground(Color.black);
	  frame.add(submit);
	  
	  back = new JButton("Back");
	  back.setBounds(250,250,150,30);
	  back.setForeground(Color.white);
      back.setBackground(Color.black);
	  frame.add(back);

      submit.addActionListener(this);	  
      back.addActionListener(this);

       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("image\\customer.jpg"));
	    JLabel label = new JLabel(i1);
		label.setBounds(0,0,450,350);
		frame.add(label);	  
	  
        frame.setSize(450,350);
	    frame.getContentPane().setBackground(Color.WHITE); 
        frame.setLocationRelativeTo(null);   
	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);	
        frame.setLayout(null);  
        frame.setVisible(true);
   }
   public void actionPerformed(ActionEvent e) 
   {
	   String s1 = nameField.getText();
	   String s2 = nidField.getText();
	   String s3 = addressField.getText();
	   String s4 = phoneField.getText();
	  
	   if (e.getSource()== submit)
	   {
		   if(s1.isEmpty()|| s2.isEmpty() || s3.isEmpty() || s4.isEmpty())
		   {
			   JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!"
			                                ,JOptionPane.WARNING_MESSAGE);
		   }
		   try
		   {
			  long i1=Long.parseLong(s4);
			  long i2=Long.parseLong(s2);
			  File myObj = new File("F:/Desktop 24-09-2022/java project/hotel/data/new_customer.txt");
			if (myObj.createNewFile())
			{
			System.out.println("File created: " + myObj.getName());
			} 
			else {
			System.out.println("File already exists.");
			}			
            
			
			
			 String all = "";
			 all+= " Name : "+s1 +"\n";
			 all+= " NID Number : "+i2+"\n";
			 all+= " Address : "+s3+"\n";
			 all+= " Phone : "+i1+"\n";
			 all+= "\n";
			 
			Files.write(Paths.get("F:/Desktop 24-09-2022/java project/hotel/data/new_customer.txt"), all.getBytes(), StandardOpenOption.APPEND);
            showMessageDialog(null, "Customer added successfully!");
			
			  
		   }catch(Exception ae)
		   {
			   JOptionPane.showMessageDialog(null, "Please enter mobile number or nid correctly.", "Warning!"
			                                ,JOptionPane.WARNING_MESSAGE);
		   }
	   }
         else if(e.getSource()==back)
		 {
			 new Reception();
			 frame.setVisible(false);
		 }			 
   }
  
    }
}
