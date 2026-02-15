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

public class AddDrivers implements ActionListener
{
	
	private JLabel heading;
	private JLabel name;
	private JTextField textfieldName;
	private JLabel gender;
	private String gn[];
	private JComboBox<String> genderBox;
	private JLabel nid;
	private JTextField textfieldnid;
	private JLabel carType;
	private String typeOption[];
	private JComboBox<String> carTypeBox;
	private JLabel available;
	private String status[];
	private JComboBox<String> availableBox;
	
	
	private JButton addDriver;
	private JButton back;
	

	JFrame frame ;
	
	
	public AddDrivers()
	{
		frame = new JFrame();
		heading = new JLabel("Add Drivers");
		name = new JLabel("Name");
		textfieldName = new JTextField();
		gender = new JLabel("Gender");
		gn   = new String [] {"Male","Female"};
		genderBox = new JComboBox<>(gn);
		nid = new JLabel("NID Number");
		textfieldnid = new JTextField();
		
		
		carType = new JLabel("Car Type");
		typeOption   = new String [] {"SUV","Hatchback","Crossover","Sedan","Coupe","Minivan"};
		carTypeBox = new JComboBox<>(typeOption);
		
		available = new JLabel("Available");
		status   = new String [] {"Available","Booked"};
		availableBox = new JComboBox<>(status);
		
		addDriver = new JButton("Add Driver");
		back = new JButton("Back");
		
		heading.setBounds(150,30,200,30);
		name.setBounds(60,80,120,30);
		textfieldName.setBounds(250,80,150,30);
		genderBox.setBounds(250,130,150,30);
		gender.setBounds(60,130,120,30);
		nid.setBounds(60,180,120,30);
		textfieldnid.setBounds(250,180,150,30);
		carType.setBounds(60,230,120,30);
		carTypeBox.setBounds(250,230,150,30);
		available.setBounds(60,280,120,30);
		availableBox.setBounds(250,280,150,30);
		addDriver.setBounds(60,350,150,30);
		back.setBounds(250,350,150,30);
		
		back.addActionListener(this);
		addDriver.addActionListener(this);
		
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setForeground(Color.white);
		name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		name.setForeground(Color.white);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		gender.setForeground(Color.white);
		genderBox.setBackground(Color.WHITE);
		nid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nid.setForeground(Color.white);
		//cleanStatus.setBackground(Color.WHITE);
		carType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		carType.setForeground(Color.white);
		carTypeBox.setBackground(Color.WHITE);
		availableBox.setBackground(Color.WHITE);
		available.setFont(new Font("Tahoma", Font.PLAIN, 18));
		available.setForeground(Color.white);
		addDriver.setForeground(Color.white);
        addDriver.setBackground(Color.black);
		back.setForeground(Color.white);
        back.setBackground(Color.red);
		
		
		
		frame.add(heading);
		frame.add(name);
		frame.add(textfieldName);
		frame.add(genderBox);
		frame.add(gender);
		frame.add(nid);
		frame.add(textfieldnid);
		frame.add(carType);
		frame.add(carTypeBox);
		frame.add(available);
		frame.add(availableBox);
		frame.add(addDriver);
		frame.add(back);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("image\\hotelcar1.jpg"));
	    JLabel label = new JLabel(i1);
		label.setBounds(0,0,950,450);
		frame.add(label);
		
		frame.setSize(950,450);
	    frame.getContentPane().setBackground(Color.WHITE); 
        frame.setLocationRelativeTo(null);   
	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);	
        frame.setLayout(null);  
        frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	 {  
	     String s1 = textfieldName.getText();
	     String s2 = textfieldnid.getText();
	     String s3 = genderBox.getSelectedItem().toString();
	     String s4 = carTypeBox.getSelectedItem().toString();
	     String s5 = availableBox.getSelectedItem().toString();
		 
		 
	     if(e.getSource()==addDriver)
		 {
			 if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty())
			 {
				 JOptionPane.showMessageDialog(null, "Please fill all of the fields.", 
				 "Warning!",JOptionPane.WARNING_MESSAGE);
			 }
			  try
		   {
			  
			  int i=Integer.parseInt(s2);
			  File myObj = new File("F:/Desktop 24-09-2022/java project/hotel/data/addDvivers.txt");
			  
			if (myObj.createNewFile())
			{
			System.out.println("File created: " + myObj.getName());
			} 
			else {
			System.out.println("File already exists.");
			}			
            
			
			
			 String all = "";
			 all+= "Name : "+s1 +"\n";
			 all+= "NID : "+i+"\n";
			 all+= "Gender : "+s3+"\n";
			 all+= "Car Type : "+s4+"\n";
			 all+= "Available Status : "+s5+"\n";
		     all+= "\n";

			Files.write(Paths.get("F:/Desktop 24-09-2022/java project/hotel/data/addDvivers.txt"), all.getBytes(), StandardOpenOption.APPEND);
           
		   showMessageDialog(null, "Driver added successfully!");
			
			  
		   }catch(Exception ae)
		   {
			   JOptionPane.showMessageDialog(null, "Please enter nid number  correctly.", "Warning!"
			                                ,JOptionPane.WARNING_MESSAGE);
		   }
		 }
	      
         else if(e.getSource()== back)
		 {
			 new AdminDashboard();
			 frame.setVisible(false);
		 }
     }
}
	
	
