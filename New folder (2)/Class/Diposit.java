


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;


public class Diposit extends JFrame{
	
	
	
	private ImageIcon icon;
	private Container c;
	
	private JButton back,ok;
	private JLabel amount,lName,lTitle1,lTitle2,under,pass,form,lnum,pin;
	private JTextField amount1,number,pin11;
	private JRadioButton bkash , nagad;
	
	
	private String textUser,pass11;
	private int a;
	
	private double money;
	
	
	
	
	
	Diposit(String textUser,int a,double money)
	{
					
					this.textUser = textUser;
					this.a = a;
					this.money=money;
					
					try{
					pass11 =  Files.readAllLines(Paths.get("E:\\Java Project 2\\data\\user_data.txt")).get(a+1);
					
					
					
					
					
					}
					
					
					catch (Exception ex)
					{
						System.out.println(ex);
						
					}
					
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
			
		
			
			
				lTitle1 = new JLabel ("      Diposit   ");
			lTitle1.setFont(new Font("osward",Font.BOLD,28));
			lTitle1.setBounds(350,100,250,40);
			
			this.add(lTitle1);
			
			
			
				under = new JLabel ("      ______");
			under.setFont(new Font("osward",Font.BOLD,28));
			under.setBounds(348,100,250,40);
			
			this.add(under);
			
			
			
				lName = new JLabel ("Username:"+textUser);
			lName.setFont(new Font("osward",Font.BOLD,19));
			lName.setBounds(250,200,250,30);
			
			this.add(lName);
			
			
			
				amount = new JLabel (" Amount:");
			amount.setFont(new Font("osward",Font.BOLD,19));
			amount.setBounds(250,400,250,30);
			
			this.add(amount);
			
			
			form = new JLabel ("Diposit from :");
			form.setFont(new Font("osward",Font.BOLD,19));
			form.setBounds(250,250,250,30);
			
			this.add(form);
			
			
				lnum = new JLabel ("Enter bkash/nagad number:");
			lnum.setFont(new Font("osward",Font.BOLD,19));
			lnum.setBounds(120,300,350,30);
			
			this.add(lnum);
			
			
			pin = new JLabel ("  Enter bkash/nagad pin :");
			pin.setFont(new Font("osward",Font.BOLD,19));
			pin.setBounds(120,350,350,30);
			
			this.add(pin);
			
			
			
			
			
			
			
			
			
			// text Field
			
			
			amount1 = new JTextField();
			
			amount1.setFont(new Font("osward",Font.BOLD,19));
			amount1.setBounds(400,400,250,30);
			
			this.add(amount1);
			
			
				number = new JTextField();
			
			number.setFont(new Font("osward",Font.BOLD,19));
			number.setBounds(400,300,250,30);
			
			this.add(number);
			
			
				pin11 = new JTextField();
			
			pin11.setFont(new Font("osward",Font.BOLD,19));
			pin11.setBounds(400,350,250,30);
			
			this.add(pin11);
			
			
			
			
			
			
			
			
			// Ratio button
			
			
			
			bkash = new JRadioButton ("Bkash");
			bkash.setBackground(Color.decode("#FFFFFF"));
			bkash.setBounds(400,250,80,30);
			
			this.add(bkash);
			
			
				nagad = new JRadioButton ("nagad");
			
			nagad.setBackground(Color.decode("#FFFFFF"));
			nagad.setBounds(500,250,80,30);
			
			this.add(nagad);
			
			
			
					// group of baksh and nagad
					
					
					
					ButtonGroup option = new ButtonGroup();
					
					option.add(bkash);
					option.add(nagad);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			// button
			
			// ok
			ok = new JButton("Ok");
				ok.setFont(new Font("Raleway",Font.BOLD,14));
				ok.setBounds(400,500,80,30);
				ok.setBackground(Color.BLACK);
				ok.setForeground(Color.WHITE);
					ok.addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent ae)
						{
							 //amount1,number,pin11;
							
							String text1= amount1.getText();
							String text2= number.getText();
							String text3= pin11.getText();
								String text4= "";
								
								try{
									
									if(bkash.isSelected())
									{
										text4 = "Bkash";
									}
									else if(nagad.isSelected())
									{
										
										text4= "nagad";
									}
									else{
										
										text4 = "";
									}
								
						if(text1.isEmpty()||text2.isEmpty()||text3.isEmpty()||text4.isEmpty()){
							
							
							JOptionPane.showMessageDialog(null,"Fill All information");
							
							
							
						}
						
						else{
								//double money1 =amount1.getText();
								//money = money+money1;
								JOptionPane.showMessageDialog(null,"Diposit Successful");
								setVisible(false);
						 new UserDashboard(textUser,a).setVisible(true);;
							
								
							
						}
							
						
						
						
									
									
								}
								
								catch (Exception ex)
								{
									System.out.println(ex);
									
								}
								
							
							
							
							
							
							
							
							
							
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
			Diposit dipo = new Diposit("",0,0.0);
			dipo.setVisible(true);
		
		}










}