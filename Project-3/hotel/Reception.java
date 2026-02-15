import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Reception implements ActionListener
{
	private JButton newCustomer;
	private JButton rooms;
	private JButton department;
	private JButton allEmployee;
	private JButton customerInfo;
	private JButton foods;
	private JButton checkout;
	private JButton update;
	private JButton roomStatus;
	private JButton logout;
	
	
	JFrame frame;
	public Reception()
	{
		frame = new JFrame(); 
		newCustomer = new JButton("New Customer Form");
		rooms = new JButton("Rooms");
		allEmployee = new JButton("All Employee");
		customerInfo = new JButton("Customer Information");
		checkout = new JButton("Checkout");
		
		logout = new JButton("Logout");
		
		
		newCustomer.setBounds(10,30,200,30);
		rooms.setBounds(10,80,200,30);
		allEmployee.setBounds(10,130,200,30);
		customerInfo.setBounds(10,180,200,30);
		checkout.setBounds(10,230,200,30);
		
		
		//roomStatus.setBounds(10,380,200,30);
		logout.setBounds(10,430,200,30);
		
		
		frame.add(newCustomer);
		frame.add(rooms);
		
		frame.add(allEmployee);
		frame.add(customerInfo);

		frame.add(checkout);
		
		frame.add(logout);
		
		logout.addActionListener(this);
		newCustomer.addActionListener(this);
		rooms.addActionListener(this);
		customerInfo.addActionListener(this);
		checkout.addActionListener(this);
		
		newCustomer.setForeground(Color.white);
        newCustomer.setBackground(Color.black);
		
		rooms.setForeground(Color.white);
        rooms.setBackground(Color.black);
		
		
		
		allEmployee.setForeground(Color.white);
        allEmployee.setBackground(Color.black);
		
		customerInfo.setForeground(Color.white);
        customerInfo.setBackground(Color.black);
		
		
		
		checkout.setForeground(Color.white);
        checkout.setBackground(Color.black);
		
		
		
		logout.setForeground(Color.white);
        logout.setBackground(Color.black);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("reception.png"));
	    JLabel label = new JLabel(i1);
		label.setBounds(0,0,800,500);
		frame.add(label);
		
		
		frame.setSize(800,500);
	    frame.getContentPane().setBackground(Color.WHITE); 
        frame.setLocationRelativeTo(null);   
	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);	
        frame.setLayout(null);  
        frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	 {  
         if(e.getSource()== logout)
		 {
			 new Login();
			 frame.setVisible(false);
			 showMessageDialog(null, "Logout Successfully!");
		 }
		 else if(e.getSource()==newCustomer)
		 {
			 new NewCustomer();
			 frame.setVisible(false);
		 }
		 else if(e.getSource()==rooms)
		 {
			 new Rooms();
			 frame.setVisible(false);
		 } 
		 else if(e.getSource()==customerInfo)
		 {
			 new CusInfo();
			 frame.setVisible(false);
		 } else if(e.getSource()==checkout)
		 {
			 new Checkout();
			 frame.setVisible(false);
		 } 
     }
}	