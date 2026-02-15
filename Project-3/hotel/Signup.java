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
public class Signup implements ActionListener
{
	private JButton register;
	private JButton back;
    private JLabel username;
    private JLabel pass;
    private JTextField uname;
    private JPasswordField upass;

	JFrame frame;
	
	Signup()
	{
		frame = new JFrame ("System");
        //construct components
        register = new JButton ("Register");
        back = new JButton ("Back");
       
        username = new JLabel ("Username");
        pass = new JLabel ("Password");
        uname = new JTextField ();
        upass = new JPasswordField ();
		
		
		
        register.setBounds (150, 235, 140, 30);
        back.setBounds (305, 235, 140, 30);
        username.setBounds (150, 105, 100, 25);
        pass.setBounds (150, 145, 100, 25);
        uname.setBounds (305, 105, 100, 25);
        upass.setBounds (305, 145, 100, 25);
		
		
		
		frame.add (register);
		frame.add (back);
        frame.add (username);
        frame.add (pass);
        frame.add (uname);
        frame.add (upass);
		
		
		frame.setSize (624, 400);
		frame.setLocationRelativeTo(null);//to center screen gui
        frame.setLayout (null);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        frame.setVisible (true);
         register.addActionListener(this);
		back.addActionListener(this);		
	}
	public void actionPerformed(ActionEvent e) 
	{
		String s1 = uname.getText();
		String s2 = upass.getText();
		
		if (e.getSource()== register)
		{
			try
			{
				 File myObj = new File("signup.txt");
			if (myObj.createNewFile())
			{
			System.out.println("File created: " + myObj.getName());
			} 
			else {
			System.out.println("File already exists.");
			}			
           
			
			
				String all = "";
			 all+= "Name : "+s1 +"\n";
			all+= "Password : "+s2+"\n";
			 Files.write(Paths.get("signup.txt"), all.getBytes(), StandardOpenOption.APPEND);
             showMessageDialog(null, "Sing up successfull!");


		}
		
			catch(Exception ae)
			{
				showMessageDialog(null, "Fill up all the informatiom");
			}
		}
		 else if(e.getSource()==back)
		 {
			 new Login();
			 frame.setVisible(false);
		 }
			
			
		}
		
	
	
	
}
 
