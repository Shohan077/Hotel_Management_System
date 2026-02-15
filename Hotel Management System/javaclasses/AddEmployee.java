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
public class AddEmployee implements ActionListener
{
	private JLabel name;
	private JLabel addEmployee;
	private JLabel age;
	private JLabel gender;
	private JTextField textfieldname;
	private JTextField textfieldage;
	private JRadioButton male;
	private JRadioButton female;
	private JLabel job;
	private JComboBox<String> jobBox;
	private JLabel salary;
	private JTextField textfieldsalary;
	private JLabel phone;
	private JTextField textfieldphone;
	private JLabel email;
	private JTextField textfieldemail;
	private JButton submit;
	private JButton back;
	private String[] employee ;
	private ButtonGroup bg;
	
	JFrame frame;
	public AddEmployee()
	{
		frame = new JFrame();
		
		addEmployee = new JLabel("ADD EMPLOYEE");
		addEmployee.setBounds(100,30,150,30);
		addEmployee.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.add(addEmployee);
		
		name = new JLabel("NAME");
		name.setBounds(60,80,120,30);
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.add(name);
		
		textfieldname = new JTextField();
		textfieldname.setBounds(180,80,150,30);
		frame.add(textfieldname);
		
		age = new JLabel("AGE");
		age.setBounds(60,130,120,30);
		age.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.add(age);
		
		textfieldage = new JTextField();
		textfieldage.setBounds(180,130,150,30);
		frame.add(textfieldage);
		
	    gender = new JLabel("GENDER");
		gender.setBounds(60,180,120,30);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(180,180,70,30);
		male.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(250,180,70,30);
		female.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.add(female);
		
		bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);
		
		job = new JLabel("JOB");
		job.setBounds(60,230,120,30);
		job.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.add(job);
		
		
		 employee   =new String[] {"Hotel manager","Assistant hotel manager","Hotel receptionist","Front of house manager","Hotel general manager","Night duty manager","Director of purchasing","Human resources manager","Revenue manager","Sales manager","IT manager","Accounting manager","Security manager","Parking attendant","Hotel housekeeper","Cleaning manager","Maintenance technician","Director of sales and marketing","Kitchen staff","Kitchen manager","Chef/Executive chef","Food and beverage/Restaurant manager","Room service"};
		 jobBox = new JComboBox<>(employee);
		 jobBox.setBounds(180,230,150,30);
		 jobBox.setBackground(Color.WHITE);
		 frame.add(jobBox);
		
		salary = new JLabel("SALARY");
		salary.setBounds(60,280,120,30);
		salary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.add(salary);
		
		textfieldsalary = new JTextField();
		textfieldsalary.setBounds(180,280,150,30);
		frame.add(textfieldsalary);
		
		phone = new JLabel("PHONE");
		phone.setBounds(60,330,120,30);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.add(phone);
		
	    textfieldphone = new JTextField();
		textfieldphone.setBounds(180,330,150,30);
		frame.add(textfieldphone);
		
		email = new JLabel("E-MAIL");
		email.setBounds(60,380,120,30);
		email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.add(email);
		
		textfieldemail = new JTextField();
		textfieldemail.setBounds(180,380,150,30);
		frame.add(textfieldemail);
		
		submit = new JButton("Submit");
		submit.setForeground(Color.white);
        submit.setBackground(Color.black);
		submit.setBounds(60,450,150,30);
		frame.add(submit);
		
		back = new JButton("Back");
		back.setForeground(Color.white);
        back.setBackground(Color.black);
		back.setBounds(250,450,150,30);
		frame.add(back);
		
		back.addActionListener(this);
		submit.addActionListener(this);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("image\\hotelemployee.png"));
	    JLabel label = new JLabel(i1);
		label.setBounds(380,60,450,300);
		frame.add(label);
		
		
		
		
		
		frame.setSize(850,550);
	    frame.getContentPane().setBackground(Color.WHITE); 
        frame.setLocationRelativeTo(null);   
	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);	
        frame.setLayout(null);  
        frame.setVisible(true);
	}
    public void actionPerformed(ActionEvent e) 
	 {  
	    String s1 = textfieldname.getText();
	   String s2 = textfieldage.getText();
	   String s3 = textfieldsalary.getText();
	   String s4 = textfieldphone.getText();
	   String s5 = textfieldemail.getText();
	   String s6 = jobBox.getSelectedItem().toString();
         if(e.getSource()== back)
		 {
			 new AdminDashboard();
			 frame.setVisible(false);
		 }
		 else if(e.getSource()==submit)
		 {
			 if(s1.isEmpty()|| s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()|| s6.isEmpty() )
			{
				 JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",JOptionPane.WARNING_MESSAGE);
			}
		    try
		   {
			  long l=Long.parseLong(s4);
			  double d=Double.parseDouble(s3);
			  int i=Integer.parseInt(s2);
			  File myObj = new File("F:/Desktop 24-09-2022/java project/hotel/data/addemployee.txt");
			if (myObj.createNewFile())
			{
			System.out.println("File created: " + myObj.getName());
			} 
			else {
			System.out.println("File already exists.");
			}			
            
			
			
			 String all = "";
			 all+= "Name : "+s1 +"\n";
			 all+= "Age : "+i+"\n";
			 all+= "Job Position : "+s6+"\n";
			 all+= "Salary : "+d+"\n";
			 all+= "Phone : "+l+"\n";
			 all+= "Email : "+s5+"\n";
			 all+= "\n";
			Files.write(Paths.get("F:/Desktop 24-09-2022/java project/hotel/data/addemployee.txt"), all.getBytes(), StandardOpenOption.APPEND);
            showMessageDialog(null, "Employee added successfully!");
			
			  
		   }catch(Exception ae)
		   {
			   JOptionPane.showMessageDialog(null, "Please enter mobile number or salary or age  correctly.", "Warning!"
			                                ,JOptionPane.WARNING_MESSAGE);
		   }
		
		
		}
		
		 }
     }
	
