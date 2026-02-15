

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;




public class Login extends JFrame 

{
	private ImageIcon icon;
	private Container c;
	private JButton name,password,about,clear,admin,login,register;
	private JLabel lname,lpassword,title,image1;
	private JTextField nameField;
	private JPasswordField passwordField;
	
	
	private  int a;
	
	
	   Login()
	   {
			
			this.setSize(800,500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("ONLINE BANKING ");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
	        this.setResizable(false);                   
	   
	   
	   

	   
	   
	     //icon image 
		   
		   icon = new ImageIcon(getClass().getResource("/image/LOGO1.png"));
		   this.setIconImage(icon.getImage());
		   
		     c = this.getContentPane();
				c.setLayout(null);
			
			c.setBackground(Color.decode("#FFFFFF"));


		
		 
	
			//  name label part
			
			
			
		    lname	= new JLabel ("UserName:");
			lname.setFont(new Font("osward",Font.BOLD,22));
			lname.setBounds(200,145,250,40);
			this.add(lname);
			// password label part
			
			
			
			lpassword = new JLabel ("password:");
			lpassword.setFont(new Font("osward",Font.BOLD,22));
			lpassword.setBounds(200,185,250,40);
			this.add(lpassword);
			// title label part
			
			
		    title = new JLabel("XS BANK");			
			title.setFont(new Font("Serif Bold Italic",Font.BOLD,42));
			title.setBounds(250,70,400,40);
			this.add(title);
			//  name TEXT Field part
			
			
		    nameField = new JTextField();
			nameField.setBounds(330,150,150,30);
			nameField.setFont(new Font("Arial",Font.BOLD,14));
			this.add(nameField);
			
			//password Text field part
			
			
			
		    passwordField = new JPasswordField();	
			passwordField.setBounds(330,190,150,30);
			this.add(passwordField);
			
			
			// login button part
			
			
			
			 login = new JButton("Login");
			login.setBounds(170,240,90,30);
			login.setBackground(Color.BLACK);
			login.setForeground(Color.WHITE);
			
					login.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{
						String textUser = nameField.getText();
						String textPass = passwordField.getText();
						
						
						if(textUser.isEmpty()||textPass.isEmpty())
						{
							JOptionPane.showMessageDialog(null,"Please Fill All Field");
						}
						else{
							
							
							try{
								
								
								String userNames = "UserName = " +textUser;
								String userPasswords= "Password = "+textPass;
								BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Md.Tanjil Amin\\OneDrive\\Desktop\\New folder (2)\\data\\user_data.txt"));
								
								
								
								int totalLines = 0;
								
								while(reader.readLine()!=null)
									totalLines++;
								
								
									reader.close();
									
								for(int i= 0 ; i<=totalLines;i++)
								{
								String line = Files.readAllLines(Paths.get("C:\\Users\\Md.Tanjil Amin\\OneDrive\\Desktop\\New folder (2)\\data\\user_data.txt")).get(i);
										
															
															
									   if(line.equals(userNames)){
													
										  String line2 = Files.readAllLines(Paths.get("C:\\Users\\Md.Tanjil Amin\\OneDrive\\Desktop\\New folder (2)\\data\\user_data.txt")).get(i+1);
										   
										   if(line2.equals(userPasswords)){
											   
											 
													
													a=i;
											   		//new Profile(a);
						
																setVisible(false);
														new UserDashboard (textUser,a).setVisible(true);
														
														  
											 
											  
															
											   		
														  
														
		
															
															
															
															
															break;
															
													

														
					   
										   }
										   
										   
									   }
									
									
								}
							
								
								
								
								
								
								
							}
							
							catch(Exception ex)
							{		
							
								JOptionPane.showMessageDialog(null,"Incorrect username or Password");
								
							}
							
							
							
							
							
							
							
						}
						

						
						
				
						
					}
					} );
			
			
			
			
			
			
			this.add(login);
			
			// claer button part
			
			
			 clear = new JButton("Clear");
			clear.setBounds(310,240,90,30);
			clear.setBackground(Color.BLACK);
			clear.setForeground(Color.WHITE);
			
			
						clear.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{
						nameField.setText("");
						passwordField.setText("");
						
						
						JOptionPane.showMessageDialog(null,"clear");
						
					}
					} );
			
			this.add(clear);
			
			
			
			// register button 
			
			
			 register = new JButton("Register");
			register.setBounds(440,240,90,30);
			register.setBackground(Color.BLACK);
			register.setForeground(Color.WHITE);
			
				register.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{
						
						
						setVisible(false);
						Register signup = new Register();
						
						
						signup.setVisible(true);
						
					}
					} );
					
					
					
			this.add(register);
			
			
			// about button part
			
			 about = new JButton("about us");
			 about.setBounds(690,410,90,30);
			about.setBackground(Color.BLACK);
			about.setForeground(Color.WHITE);
			
					about.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{
						setVisible(false);
						
						About frame11 = new About();
						frame11.setVisible(true);
						
					}
					} );
					
					
					
			
			this.add(about);
			
			
			
			
			
			// admin button part
			 admin = new JButton("Admin Login");
			admin.setBounds(0,0,150,30);
			admin.setBackground(Color.BLACK);
			admin.setForeground(Color.WHITE);
			
			
				admin.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{
						//JOptionPane.showMessageDialog(null,"opening admin login page");
						setVisible(false);
						AdminLogin adminFrame = new AdminLogin ();
						adminFrame.setVisible(true);
					}
					} );
			
			
			
			this.add(admin);
                 }
				public static void main (String[] args)
		{
		
		
		
		Login frame = new Login ();
		
			frame.setVisible(true);
			

		}

















}