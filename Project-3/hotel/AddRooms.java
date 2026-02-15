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



public class AddRooms implements ActionListener
{
	
	private JLabel heading;
	private JLabel roomno;
	private JTextField textfieldroomno;
	private JLabel available;
	private String availableRoom[];
	private JComboBox<String> availableOption;
	private JLabel bed;
	private String bedAvailable[];
	private JComboBox<String> bedTypes;
	private JLabel price;
	private JTextField textfieldprice;
	private JButton addRoom;
	private JButton back;
	private JLabel clean;
	private String cleaningRooms[];
	private JComboBox<String> cleanStatus;

	JFrame frame ;
	
	
	public AddRooms()
	{
		frame = new JFrame();
		heading = new JLabel("Add Rooms");
		roomno = new JLabel("Room Number");
		textfieldroomno = new JTextField();
		available = new JLabel("Room Status");
		availableRoom   = new String [] {"Available","Occupied"};
		availableOption = new JComboBox<>(availableRoom);
		clean = new JLabel("Cleaning Status");
		cleaningRooms   = new String [] {"Cleaned","Dirty"};
		cleanStatus = new JComboBox<>(cleaningRooms);
		bed = new JLabel("Available Bed");
		bedAvailable   = new String [] {"Single Bed","Double Bed"};
		bedTypes = new JComboBox<>(bedAvailable);
		price = new JLabel("Price");
		textfieldprice = new JTextField();
		addRoom = new JButton("Add Room");
		back = new JButton("Back");
		
		heading.setBounds(150,30,200,30);
		roomno.setBounds(60,80,120,30);
		textfieldroomno.setBounds(250,80,150,30);
		availableOption.setBounds(250,130,150,30);
		available.setBounds(60,130,120,30);
		clean.setBounds(60,180,120,30);
		cleanStatus.setBounds(250,180,150,30);
		bed.setBounds(60,230,120,30);
		bedTypes.setBounds(250,230,150,30);
		price.setBounds(60,280,120,30);
		textfieldprice.setBounds(250,280,150,30);
		addRoom.setBounds(60,350,150,30);
		back.setBounds(250,350,150,30);
		
		
		
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		available.setFont(new Font("Tahoma", Font.PLAIN, 18));
		roomno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		availableOption.setBackground(Color.WHITE);
		clean.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cleanStatus.setBackground(Color.WHITE);
		bed.setFont(new Font("Tahoma", Font.PLAIN, 17));
		bedTypes.setBackground(Color.WHITE);
		price.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addRoom.setForeground(Color.white);
        addRoom.setBackground(Color.black);
		back.setForeground(Color.white);
        back.setBackground(Color.red);
		
		back.addActionListener(this);
		addRoom.addActionListener(this);
		
		frame.add(heading);
		frame.add(roomno);
		frame.add(textfieldroomno);
		frame.add(available);
		frame.add(availableOption);
		frame.add(clean);
		frame.add(cleanStatus);
		frame.add(bed);
		frame.add(bedTypes);
		frame.add(price);
		frame.add(textfieldprice);
		frame.add(addRoom);
		frame.add(back);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Addroms1.jpg"));
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
		if(e.getSource()==back)
		{
			new AdminDashboard();
			frame.setVisible(false);
		}
		
		
		else if(e.getSource()==addRoom)
		{
			if(textfieldroomno.getText().isEmpty()|| availableOption.getSelectedItem().toString().equals("") || bedTypes.getSelectedItem().toString().equals("") || cleanStatus.getSelectedItem().toString().equals("") || textfieldprice.getText().isEmpty())
			{
				 JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",JOptionPane.WARNING_MESSAGE);
			}
		}
		try{
			String s1 =  textfieldroomno.getText();
			String s2 =  availableOption.getSelectedItem().toString();
			String s3 =  bedTypes.getSelectedItem().toString();
			String s4 =  cleanStatus.getSelectedItem().toString();
			String s5 =  textfieldprice.getText();
		
			
			Double d = Double.parseDouble(s5);
            File myObj = new File("addrooms.txt");
			if (myObj.createNewFile())
			{
			System.out.println("File created: " + myObj.getName());
			} 
			else {
			System.out.println("File already exists.");
			}			
            
			
			
				String all = "";
			 all+= "Room No : "+s1 +"\n";
			all+= "Room Status : "+s2+"\n";
			 all+= "Bed Types : "+s3+"\n";
			 all+= "Clean Status : "+s4+"\n";
			 all+= "Price : "+s5+"\n";
			 all+= "\n";
			// all+= "\n";
			 
			
			

			try {
    Files.write(Paths.get("addrooms.txt"), all.getBytes(), StandardOpenOption.APPEND);
         showMessageDialog(null, "Rooms added successfully!");
}catch (IOException ex) {
	System.out.println(ex);
    
}


		}
		catch(Exception ex){
			showMessageDialog(null, "Price should be integer or double value!");
		}
		
	}

     
	
}
	
