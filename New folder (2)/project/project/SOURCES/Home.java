import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Home extends JFrame{
	
	private Container c;
	private JLabel lbl,lbl1, lbl2, lbl3,lbl4,lblImageBg;
    private Font f1, f2, f3, f4, f5, f6;
    private ImageIcon imgbg;
    private JButton btn1, btn2, btn3,btn4,btn5,nBtn;
    private Cursor cursor;
	
	Home(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Home");
        this.setSize(933, 700);
		c = this.getContentPane();
        c.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		f1 = new Font("Segoe UI Black", Font.PLAIN, 23);
        f2 = new Font("Segoe UI Semibold", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 25);
        f4 = new Font("Segoe UI", Font.PLAIN, 15);
        f5 = new Font("Segoe UI Black", Font.PLAIN, 15);
        f6 = new Font("Segoe UI Black", Font.PLAIN, 25);
		
		lbl = new JLabel();
        lbl.setText("Choose your option!");
        lbl.setBounds(110,170, 500, 50);
        lbl.setFont(f3);
        c.add(lbl);
		
		
		//Coffee
		btn1 = new JButton("Coffee");
        btn1.setBounds(110,240, 150, 40);
		btn1.setFont(f1);
		btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2E75B6"));
        c.add(btn1);
		
		//Tea
		btn2 = new JButton("Tea");
        btn2.setBounds(110,310, 150, 40);
		btn2.setFont(f1);
		btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        c.add(btn2);
		
		//Juice
		btn3 = new JButton("Juice");
        btn3.setBounds(110,380, 150, 40);
		btn3.setFont(f1);
		btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        c.add(btn3);
		
		//About us
		btn4 = new JButton("About us");
        btn4.setBounds(110,450, 150, 40);
		btn4.setFont(f1);
		btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#2E75B6"));
        c.add(btn4);
		
		
		nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);
		
		this.imgbg = new ImageIcon("H:\\New folder (2)\\project\\project\\Bg.jpg");
		this.lblImageBg = new JLabel("", imgbg, JLabel.CENTER);
		this.lblImageBg.setBounds(0,0,933,700);
		this.add(lblImageBg);
		
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
				
				setVisible(false);
                CoffeePage CP = new CoffeePage();
                CP.setVisible(true);
			}
		 });
		 
		 btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
				
				setVisible(false);
                TeaPage TP = new TeaPage();
                TP.setVisible(true);
			}
		 });
		 
		 btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
				
				setVisible(false);
                JuicePage JP = new JuicePage();
                JP.setVisible(true);
			}
		 });
		 
		 btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
				
				setVisible(false);
                AboutUs Au = new AboutUs();
                Au.setVisible(true);
			}
		 });
		 
		 
	}
	
	public static void main(String[] args) {

        Home H = new Home();
        H.setVisible(true);
    }
}