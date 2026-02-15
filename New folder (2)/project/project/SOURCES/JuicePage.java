import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JuicePage extends JFrame{
	
	private Container c;
	private JLabel lblImage;
    private Font f1;
    private ImageIcon img ;
    private JButton btn1,nbtn;
    private Cursor cursor;
	
	JuicePage(){
		
		f1 = new Font("Segoe UI Black", Font.PLAIN, 40);
		
	 // Frame Layout
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("JuicePage");
    this.setSize(933,700);
    c = this.getContentPane();
    c.setLayout(null);
	this.setLocationRelativeTo(null);
		this.setResizable(false);
	
	this.img = new ImageIcon("H:\\New folder (2)\\project\\project\\JuicePage.jpg");
    this.lblImage = new JLabel("", img, JLabel.CENTER);
    this.lblImage.setBounds(0,0,933,700);
    this.add(lblImage);
	
	    btn1 = new JButton("Order");
        btn1.setBounds(680,580, 150, 50);
        btn1.setFont(f1);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);
		
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
				
				setVisible(false);
                Label l = new Label();
                l.setVisible(true);
			}
		 });
	
	}
	
	public static void main(String[] args) {

        JuicePage JP = new JuicePage();
        JP.setVisible(true);
    }
}