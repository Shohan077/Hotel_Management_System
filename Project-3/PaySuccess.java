import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PaySuccess extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1,label2, imgLabel;
    private ImageIcon logo;
    private JButton Fbtn, nBtn;
    private Cursor cursor;

    PaySuccess() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hotel Management System");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        

        /*/ Icon
        icon = new ImageIcon(getClass().getResource("/Hotel-Management-System pic.png"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("/Hotel-Management-System pic.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(30, 82, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);*/


        // Set Component
        label1 = new JLabel("Your Payment Has");
		label2 = new JLabel("Successfully Completed.");
        Fbtn = new JButton("Finish");
		nBtn = new JButton("");
		
		
		
		// SetBounds
		label1.setBounds(430, 80, 500, 50);
		label2.setBounds(430, 130, 500, 50);
		Fbtn.setBounds(475, 310, 300, 50);
		nBtn.setBounds(0, 0, 0, 0); 
        
		// Add Component        
        c.add(label1);
		c.add(label2);
		c.add(Fbtn);
		c.add(nBtn);

        
        
        // Fonts
		label1.setFont(new Font("Segoe UI Black", Font.PLAIN, 35));
        label2.setFont(new Font("Segoe UI Black", Font.PLAIN, 35));
		Fbtn.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
        
        
        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);
        Fbtn.setCursor(cursor);
        Fbtn.setForeground(Color.WHITE);
        Fbtn.setBackground(Color.decode("#2E75B6"));
        c.setBackground(Color.decode("#F2F2F2"));
        
        Fbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {			
				System.exit(0);			
            }
        });
    }
    
    public static void main(String[] args) {

        PaySuccess frame = new PaySuccess();
        frame.setVisible(true);
    }
}
