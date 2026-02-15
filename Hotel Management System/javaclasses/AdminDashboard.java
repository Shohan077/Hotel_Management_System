package javaclasses;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class AdminDashboard implements ActionListener
{
	
	private JLabel text;
	private JMenuBar menubar;
	private JMenu hotel;
	
	private JMenuItem reception;
	private JMenu admin;
	private JMenuItem addemployee;
	private JMenuItem allemployee;
	private JMenuItem allRooms;
	private JMenuItem allDrivers;
	private JMenuItem logout;
	
	private JMenuItem adddrivers;
	private JMenuItem addrooms;
	
	JFrame frame;
	public AdminDashboard()
	{
		frame = new JFrame();
		
		text= new JLabel("GRANDVIEW HOTEL WELCOMES YOU");
		menubar = new JMenuBar();
		hotel = new JMenu("HOTEL MANAGEMENT");
		reception = new JMenuItem("RECEPTION");
		admin = new JMenu("ADMIN");
		
		addemployee = new JMenuItem("ADD EMPLOYEE");
		allemployee = new JMenuItem("EMPLOYEE DATA");
		allRooms = new JMenuItem("ALL ROOMS IMFORMATION");
		allDrivers = new JMenuItem("DRIVERS DATA");
		logout = new JMenuItem("LOGOUT");
		JMenuItem addrooms = new JMenuItem("ADD ROOMS");
		adddrivers = new JMenuItem("ADD DRIVERS");
		
		
		text.setBounds(450,80,1000,50);
		menubar.setBounds(0,0,1500,30);
		
		
		addemployee.addActionListener(this);
	    addrooms.addActionListener(this);
	    reception.addActionListener(this);
	    allemployee.addActionListener(this);
	    allRooms.addActionListener(this);
	    allDrivers.addActionListener(this);
	    adddrivers.addActionListener(this);
	    logout.addActionListener(this);
	  
		
		text.setForeground(Color.white);
		text.setFont(new Font("Tahoma", Font.PLAIN, 40));
		hotel.setForeground(Color.red);
		
		admin.setForeground(Color.blue);
		
		
		frame.add(text);
		frame.add(menubar);
		menubar.add(hotel);
		hotel.add(reception);
		hotel.add(logout);
		menubar.add(admin);
		admin.add(addemployee);
		admin.add(addrooms);
		admin.add(adddrivers);
		admin.add(allemployee);
		admin.add(allRooms);
		admin.add(allDrivers);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("image\\dashboard.jpg"));
	    JLabel label = new JLabel(i1);
		label.setBounds(0,0,1500,1000);
		frame.add(label);
		
		
		frame.setSize(1500,1000);
	    frame.getContentPane().setBackground(Color.WHITE); 
        frame.setLocationRelativeTo(null);   
	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);	
        frame.setLayout(null);  
        frame.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) 
	 {  
         if(e.getActionCommand().equals("ADD EMPLOYEE"))
		 {
			 new AddEmployee();
			 frame.setVisible(false);
		 }
		 else if(e.getActionCommand().equals("ADD ROOMS"))
		{  
			
			new AddRooms();
			frame.setVisible(false);
  
	    } 
		else if(e.getActionCommand().equals("ADD DRIVERS"))
		{  
	         new AddDrivers();
			frame.setVisible(false);
  
	    } 
		else if(e.getActionCommand().equals("ALL ROOMS IMFORMATION"))
		{  
				frame.setVisible(false);
			    new AllRooms();
		
  
	    }
        else if(e.getActionCommand().equals("EMPLOYEE DATA"))
		{  
			frame.setVisible(false);
			    new AllEmployee();
  
	    }
        else if(e.getActionCommand().equals("DRIVERS DATA"))
		{  
			frame.setVisible(false);
			    new AllDrivers();
  
	    }
		else if(e.getActionCommand().equals("RECEPTION"))
		{  
			new Reception();
			frame.setVisible(false);
  
	    } 
		else if(e.getActionCommand().equals("LOGOUT"))
		{  
			new Login();
			frame.setVisible(false);
  
	    } 
		
	
      }
}


	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	    