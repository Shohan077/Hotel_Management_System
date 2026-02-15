import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font.*;

public class Payment extends JFrame {

    private Container c;

    private ImageIcon icon;
    private JLabel label1, label2, label3, label4, label5, label6, label7, imgLabel;
    private ImageIcon logo, img1, img2;
    private JTextField tf1, tf2, tf3;
    private JPasswordField pf;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;

    Payment() {
        
		// Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hotel Management System");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

        

        img1 = new ImageIcon(getClass().getResource("/Image/VisaCard.png"));
        imgLabel = new JLabel(img1);
        imgLabel.setBounds(620, 90, img1.getIconWidth(), img1.getIconHeight());
        c.add(imgLabel);

        img2 = new ImageIcon(getClass().getResource("/Image/MasterCard.png"));
        imgLabel = new JLabel(img2);
        imgLabel.setBounds(705, 90, img2.getIconWidth(), img2.getIconHeight());
        c.add(imgLabel);
        
		// Set Component
        label1 = new JLabel("Complete Your Payment");
		label2 = new JLabel("We Accept Only");
		label3 = new JLabel("Card Details");		
        label4 = new JLabel("Name On Card");
		label5 = new JLabel("Card Number");
		label6 = new JLabel("Valid On");
		label7 = new JLabel("CVV Code");
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		pf = new JPasswordField();
		btn1 = new JButton("Exit");
		btn2 = new JButton("Back");
		btn3 = new JButton("Confirm Payment");
		nBtn = new JButton("");
		
		
       // Add Component
        c.add(label1);
        c.add(label2);
		c.add(label3);
        c.add(label4);
		c.add(label5);
		c.add(label6);
		c.add(label7);
        c.add(tf1);
		c.add(tf2);
		c.add(tf3);
		c.add(pf);
		c.add(btn1);
		c.add(btn2);
		c.add(btn3);
		c.add(nBtn);
		
        // Fonts
		
        label1.setFont(new Font("Segoe UI Black", Font.PLAIN, 35));
        label2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
		label3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
        label4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		label7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        tf1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tf2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tf2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tf3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pf.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        btn1.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		btn2.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		btn3.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));

        
		
		// Set Bounds for all component
		label1.setBounds(400, 20, 500, 50);
        label2.setBounds(420, 85, 500, 50);
		label3.setBounds(420, 140, 500, 50);
		label4.setBounds(430, 180, 500, 50);
		label5.setBounds(430, 220, 500, 50);
		label6.setBounds(430, 260, 500, 50);
		label7.setBounds(620, 260, 500, 50);
		tf1.setBounds(570, 190, 235, 30);
		tf2.setBounds(570, 230, 235, 30);
		tf3.setBounds(520, 270, 90, 30);
		pf.setBounds(725, 270, 80, 30);
		btn1.setBounds(75, 325, 190, 50);
		btn2.setBounds(300, 325, 190, 50);
		btn3.setBounds(524, 325, 300, 50);
		nBtn.setBounds(0, 0, 0, 0);
		
		
		
		// Set Horizontal Alignment and Echo Chracter
        tf2.setHorizontalAlignment(JTextField.CENTER);
        tf3.setHorizontalAlignment(JTextField.CENTER);
		pf.setHorizontalAlignment(JPasswordField.CENTER);
		pf.setEchoChar('*');
		

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));        
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        btn2.setEnabled (false);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        
        
        
        
        

        // To limit characters
        tf1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tf1.getText().length() >= 10 )
                    e.consume();
            }
        });

        tf2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tf2.getText().length() >= 19 )
                    e.consume();
            }
        });

        tf3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tf3.getText().length() >= 7 )
                    e.consume();
            }
        });

        pf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (pf.getText().length() >= 3 )
                    e.consume();
            }
        });

        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", 0);
			if(a==0)
			{
				System.exit(0);
			}
            }
        });

        // Confirm Payment Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String nameOnCard = tf1.getText();
                String cardNumber = tf2.getText();
                String validOn = tf3.getText();
                String cvvCode = pf.getText();
                
                if (nameOnCard.isEmpty() || cardNumber.isEmpty() || validOn.isEmpty() || cvvCode.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    setVisible(false);
                    PaySuccess frame = new PaySuccess();
                    frame.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {

        Payment frame = new Payment();
        frame.setVisible(true);
    }
}
