



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;



public class UserDashboard extends JFrame 

{
	private ImageIcon icon;
	private Container c;
	private JButton profile,withdraw,diposit,transfer,balance,back; 
	private JLabel lName,lTitle1,lTitle2,under;
	
	private JPasswordField passwordField;
	
	private String textUser,pass;
	
	private int a;
	
	private  double  money;
	
	   UserDashboard( String textUser,int a)
	   {
			this.textUser= textUser;
			this.a= a;
			this.money=money;
			money = 500.0;
			
			
			try{
				
					pass = Files.readAllLines(Paths.get("C:\\Users\\Md.Tanjil Amin\\OneDrive\\Desktop\\New folder (2)\\data\\user_data.txt")).get(a+1);
					
					
				
				
				
				
				
				
				
				
				
				
				
				
				File file00 = new File("C:\\Users\\Md.Tanjil Amin\\OneDrive\\Desktop\\New folder (2)\\data\\data.txt");
							
							if(!file00.exists()){
								
								file00.createNewFile();
								
							}
							
							FileWriter fw = new FileWriter(file00,true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pw = new PrintWriter(bw);
			
					pw.println("Name:"+textUser);
					pw.println(pass);
					pw.println(money);
					pw.println("'''''''''''''''''''''''''''''''''''''");
					
					
					pw.close();


			}
			
			catch(Exception ex)
			{
				
				System.out.println(ex);
			}

			
			
			
			
		
			
			
			
			
			
			
			
			
			this.setSize(1000,700);
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



			// Label
			
			lName = new JLabel ("Username:"+textUser);
			lName.setFont(new Font("osward",Font.BOLD,19));
			lName.setBounds(750,30,250,30);
			
			this.add(lName);
			
		
			
			lTitle1 = new JLabel ("User Dashboard");
			lTitle1.setFont(new Font("osward",Font.BOLD,28));
			lTitle1.setBounds(350,100,250,40);
			
			this.add(lTitle1);
		
		
		
			  lTitle2 = new JLabel("XS BANK");			
			lTitle2.setFont(new Font("Serif Bold Italic",Font.BOLD,45));
			lTitle2.setBounds(350,30,400,40);
			this.add(lTitle2);
			

				under = new JLabel ("______________");
			under.setFont(new Font("osward",Font.BOLD,28));
			under.setBounds(348,100,250,40);
			
			this.add(under);
			
			// button
				try{
				
				// profile
				
				profile = new JButton("Profile");
				
				profile.setBounds(420,210,80,40);
				
				profile.setBackground(Color.BLACK);
				profile.setForeground(Color.WHITE);
			
			
					 profile.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{
						
						
						setVisible(false);
						
						Profile signup = new Profile(a,textUser);
		
						signup.setVisible(true);
		
						
						
						
					}
					} );
			
			
			
			
			
			
			
			
			
			
				this.add(profile);
				
				
				
				// diposit
				
				diposit = new JButton("Diposit");
				
				diposit.setBounds(170,300,100,40);
				
				diposit.setBackground(Color.BLACK);
				diposit.setForeground(Color.WHITE);
				
				 diposit.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent e)
					{
						
						
						setVisible(false);
						
						 new Diposit(textUser,a,money).setVisible(true);;
		
						
		
						
						
						
					}
					} );
			
				this.add(diposit);
				
				
				// withdraw
				
					withdraw = new JButton("Withdraw");
				
				withdraw.setBounds(320,300,100,40);
				
				withdraw.setBackground(Color.BLACK);
				withdraw.setForeground(Color.WHITE);
			
			 withdraw.addActionListener(new ActionListener() { 
				public void actionPerformed (ActionEvent e)
					{
						
						
						setVisible(false);
						
						 new Withdraw(textUser,a).setVisible(true);;
		
						
		
						
						
						
					}
					} );
			
				this.add(withdraw);
				
				
				// transfer 
				
				transfer = new JButton("Transfer");
				
				transfer.setBounds(470,300,100,40);
				
				transfer.setBackground(Color.BLACK);
				transfer.setForeground(Color.WHITE);
				
				 transfer.addActionListener(new ActionListener() { 
				public void actionPerformed (ActionEvent e)
					{
						
						
						new Transfer(textUser, a).setVisible(true);
						
						//JOptionPane.showMessageDialog(null,"Yet to work on this.......");
						setVisible(false);
						
						 //new Balance(textUser,a).setVisible(true);;
		
						
		
						
						
						
					}
					} );
			
				this.add(transfer);
				
				// balance
				
				balance = new JButton("Balance");
				
				balance.setBounds(620,300,100,40);
				
				balance.setBackground(Color.BLACK);
				balance.setForeground(Color.WHITE);
				
				 balance.addActionListener(new ActionListener() { 
				public void actionPerformed (ActionEvent e)
					{
						
						
						setVisible(false);
						
						 new Balance(textUser,a,money).setVisible(true);;
		
						
		
						
						
						
					}
					} );
			
				this.add(balance);
				
				
	
			
			
			
			// back button
				
					back = new JButton("Back");
				back.setFont(new Font("Raleway",Font.BOLD,14));
				back.setBounds(0,0,80,30);
				back.setBackground(Color.BLACK);
				back.setForeground(Color.WHITE);
					back.addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent ae)
						{
							setVisible(false);
							Login frame = new Login();
							frame.setVisible(true);
							
						}
					}
					);
				
				
				this.add(back);
			
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			
			
	   }
	
	
				public static void main (String[] args)
		{
		
		
		
		UserDashboard userFrame = new UserDashboard ("",0);
		
			userFrame.setVisible(true);
			

		}

















}