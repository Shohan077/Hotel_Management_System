


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;


public class Balance extends JFrame{
	
	
	
	private ImageIcon icon;
	private Container c;
	
	private JButton back,ok;
	private JLabel amount,lName,lTitle1,lTitle2,under;
	// private JTextField amount1;
	
	
	private String textUser;
	private int a;
	
	
	private double money;
	
	
	Balance(String textUser,int a,double money)
	{
					
					this.textUser = textUser;
					this.a = a;
					this.money= money;
					
					
					
			this.setSize(900,600);
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
			
			
			
			
			// label  
			
				  lTitle2 = new JLabel("XS BANK");			
			lTitle2.setFont(new Font("Serif Bold Italic",Font.BOLD,45));
			lTitle2.setBounds(350,30,400,40);
			this.add(lTitle2);
			
		
			
			
				lTitle1 = new JLabel ("      Balance   ");
			lTitle1.setFont(new Font("osward",Font.BOLD,28));
			lTitle1.setBounds(350,100,250,40);
			
			this.add(lTitle1);
			
			
			
				under = new JLabel ("      ________");
			under.setFont(new Font("osward",Font.BOLD,28));
			under.setBounds(348,100,250,40);
			
			this.add(under);
			
			
			
				lName = new JLabel ("Username:"+textUser);
			lName.setFont(new Font("osward",Font.BOLD,19));
			lName.setBounds(250,200,250,30);
			
			this.add(lName);
			
			
			
				amount = new JLabel ("Balance:   "+money);
			amount.setFont(new Font("osward",Font.BOLD,19));
			amount.setBounds(250,250,250,30);
			
			this.add(amount);
			
			
			
			
			
			
			
			
			
			// text Field
			
		/*	
			amount1 = new JTextField();
			
			amount1.setFont(new Font("osward",Font.BOLD,19));
			amount1.setBounds(350,250,250,30);
			
			this.add(amount1);
			
			*/
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			// button
			
			// ok
			ok = new JButton("Ok");
				ok.setFont(new Font("Raleway",Font.BOLD,14));
				ok.setBounds(400,300,80,30);
				ok.setBackground(Color.BLACK);
				ok.setForeground(Color.WHITE);
					ok.addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent ae)
						{
							
							setVisible(false);
						 new UserDashboard(textUser,a).setVisible(true);;
							
							
						}
					}
					);
				
				
				this.add(ok);
			
			
			
			
			
			
			
			
			
			
			
			
			//back
					back = new JButton("Back");
				back.setFont(new Font("Raleway",Font.BOLD,14));
				back.setBounds(0,0,80,30);
				back.setBackground(Color.BLACK);
				back.setForeground(Color.WHITE);
					back.addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent ae)
						{
							setVisible(false);
						 new UserDashboard(textUser,a).setVisible(true);;
							
							
						}
					}
					);
				
				
				this.add(back);
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}














		public static void main (String [] args)
		{
			Balance dipo = new Balance("",0,0.0);
			dipo.setVisible(true);
		
		}










}