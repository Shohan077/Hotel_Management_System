package javaclasses;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.*;
import java.nio.file.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.Scanner;


public class Login implements ActionListener
{ 
   
	 private JButton login;
     private JButton quit;
     private JButton signup;
     private JLabel name;
     private JLabel pass;
	 private JLabel label;
	 private JLabel categoryLabel;
	
     private JTextField uname;
     private JPasswordField upass;
	 private String cr[];
	 private JComboBox<String> category;
	 JFrame frame;
	
	public Login()
	{
	
	
    frame= new JFrame();  
     
	uname=new JTextField(); 
	upass=new JPasswordField ();
	login=new JButton("Login");
	quit=new JButton("QUIT");
	signup=new JButton("SignUp");
	name=new JLabel("Username");
	pass=new JLabel("Password"); 
	categoryLabel=new JLabel("Category"); 
	
	cr   = new String [] {"Admin","Employee"};
	category = new JComboBox<>(cr);
	
    
	
	ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("image\\hotelman1.jpg"));
	label = new JLabel(i1);
	
	label.setBounds(280,5,300,300);
	uname.setBounds(160,50, 150,30);
	upass.setBounds(160,100, 150,30);
	category.setBounds(160,150, 100,30);
    login.setBounds(50,200,95,30); 
	quit.setBounds(160,200,95,30);
	signup.setBounds(105,250,95,30);
	name.setBounds(50,50, 300,30);
	pass.setBounds(50,100, 300,30); 
	categoryLabel.setBounds(50,150,300,30);
	
		
	
	
	quit.addActionListener(this);
	login.addActionListener(this);
	signup.addActionListener(this);
	
	
	frame.add(uname);  
    frame.add(upass); 
    frame.add(login);
    frame.add(quit);  
    frame.add(signup);  
	frame.add(name); 
	frame.add(pass); 
	frame.add(label);
	
	frame.add(categoryLabel);
	frame.add(category);
		
	name.setFont(new Font("Raleway", Font.BOLD, 20));
	pass.setFont(new Font("Raleway", Font.BOLD, 20));
	categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
 
	
	quit.setForeground(Color.white);
    quit.setBackground(Color.RED);
    
	new TextPrompt("James Pater", uname);	
    new TextPrompt("Password (*Java17#@)", upass);
   
	frame.setSize(600,400);
	frame.getContentPane().setBackground(Color.WHITE); 
    frame.setLocationRelativeTo(null);   
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);	
    frame.setLayout(null);  
    frame.setVisible(true);
	
     }
	 public void actionPerformed(ActionEvent e) 
	 {  
	     
	      
         if(e.getSource()==quit)
		 {
			 System.exit(0);
		 }
		 else if(e.getSource()== signup)
	   {
		   new Registration();
		   frame.setVisible(false);
	   }
		 else if(e.getSource()==login)
		{  
			String user = uname.getText();
			String pass = upass.getText();
			String text = category.getSelectedItem().toString();
			String fileData = "";
           // boolean validCredentials = false;
			if(user.isEmpty()||pass.isEmpty()||text.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please fill up the boxes!", "Warning!",
					JOptionPane.WARNING_MESSAGE);
					return;
			}
			if (text.equals("Admin"))
			{   
		        if(user.equals("Admin") && pass.equals("admin"))
				{
					new AdminDashboard();
					frame.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You are not admin!.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
				}
				
			}
			else if (text.equals("Employee"))
			{
			try {
            File file = new File("F:/Desktop 24-09-2022/java project/hotel/data/singup.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fileData += scanner.nextLine() + "\n";
            }

            scanner.close();

            // Check if username and password match any registration data
            if (fileData.contains("Name :"+user) && fileData.contains("Password :"+pass)) {
               // validCredentials = true;
				new EmplyeeDashboard();
			    frame.setVisible(false);
            }
			else
			{
				showMessageDialog(null, "Invalid name or password !");
			}
			

        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
			
        }

       
			}
	}
	   
	 }
	
 
} 