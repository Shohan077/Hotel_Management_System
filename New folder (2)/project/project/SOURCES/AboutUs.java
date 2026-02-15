import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AboutUs extends JFrame{
	
	private Container c;
	private JLabel lblImage;
    private Font f1;
    private ImageIcon img ;
    private JButton btn1;
    private Cursor cursor;
	
	AboutUs(){
		
		f1 = new Font("Segoe UI ", Font.PLAIN, 20);
		
	 // Frame Layout
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("About Us");
    this.setSize(933,700);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
	c = this.getContentPane();
    c.setLayout(null);
	
	this.img = new ImageIcon("H:\\New folder (2)\\project\\project\\AboutUs.jpg");
    this.lblImage = new JLabel("", img, JLabel.CENTER);
    this.lblImage.setBounds(0,0,933,700);
    this.add(lblImage);
	
	    btn1 = new JButton("<");
        btn1.setBounds(5,105, 50, 30);
        btn1.setFont(f1);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.BLACK);
        //btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);
		
		
		
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
				
				setVisible(false);
                Home H = new Home();
                H.setVisible(true);
			}
		 });
		
	
	}
	
	public static void main(String[] args) {

        AboutUs Au = new AboutUs();
        Au.setVisible(true);
    }
}