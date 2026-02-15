import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class FirstPage implements ActionListener
{
	private JButton next;
	private JLabel label;
	private JLabel text;
	JFrame frame;
	
	
	public FirstPage()
	{
	    frame=new JFrame();
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("hotel6.jpg"));
		label = new JLabel(i1);
		text=new JLabel("Hotel Management System "); 
		next=new JButton("Next");
		

		label.setBounds(0,0,900,600);
		text.setBounds(20,400,700,50);
		next.setBounds(700,450,100,50);
		
		next.addActionListener(this);
		
		frame.add(text);
		frame.add(label);
		frame.add(next);
		
		text.setForeground(Color.white);
		text.setFont(new Font("serif", Font.PLAIN, 50));
		
		next.setForeground(Color.white);
        next.setBackground(Color.BLACK);
		next.setFont(new Font("Raleway", Font.BOLD, 20));
		 
	    frame.setSize(900,600);
	    frame.getContentPane().setBackground(Color.WHITE); 
        frame.setLocationRelativeTo(null);   
	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);	
        frame.setLayout(null);  
        frame.setVisible(true);
		
		/*while(true)
		{
			text.setVisible(false);
			try
			{
				Thread.sleep(1000);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			text.setVisible(true);
			try
			{
				Thread.sleep(1000);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}*/
		
	}
	 public void actionPerformed(ActionEvent e) 
	 {  
         
        if(e.getSource()==next)
		{
			new Login();
			frame.setVisible(false);
		}  
			
    }
}

