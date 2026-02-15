

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;




public class About2 extends JFrame 

{
	private ImageIcon icon,image;
	private Container c;
	private JLabel imageText;
	private JButton back;
	
	  About2()
	   {
			
			this.setSize(800,800);;
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("ONLINE BANKING ");
			this.setLayout(null);
			this.setLocationRelativeTo(null);
	        this.setResizable(false);                   
	   
	   
	   

	   
	   
	     //icon image 
		   
		   icon = new ImageIcon(getClass().getResource("image/LOGO1.png"));
		   this.setIconImage(icon.getImage());
		   
		     c = this.getContentPane();
				c.setLayout(null);
			
			c.setBackground(Color.decode("#FFFFFF"));
			
			
			
			
			
		//	picture
			
			 image = new ImageIcon(getClass().getResource("image/about11.png"));
			imageText = new JLabel(image);
			imageText.setBounds(0,0,800,800);
			c.add(imageText);
			
			imageText.setVisible(true);
			
					
			//back button
					back = new JButton("Back");
				back.setFont(new Font("Raleway",Font.BOLD,14));
				back.setBounds(0,0,80,30);
				back.setBackground(Color.BLACK);
				back.setForeground(Color.WHITE);
					back.addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent ae)
						{
							setVisible(false);
						
						new AdminLogin().setVisible(true);
							
							
						}
					}
					);		
				
				
				this.add(back);
				
			
			
			
			
			
			
			
			
			
			
			
	   }
	   
	   public static void main (String []args)
	   {
		  About2 frame22 = new About2();
		   frame22.setVisible(true);
		   
	   }
	   
}
