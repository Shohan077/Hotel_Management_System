import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Label extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
    private JLabel lblSize,lblBev,lblGlass,lblReport,lblImage,lblImage2,lblImage3,lblImage4,lblImage5;
	private JComboBox<String> size;
	private JRadioButton rdJuice,rdWater,rdTea,rdCoffee;
	private ButtonGroup btnGroup;
	private JTextField txtGlass;
	private JButton btnAdd,btnOrder,btnBack;
	private ImageIcon img,img2,img3,img4,img5;
	private Font f1, f2, f3, f4, f5, f6;
	int amount_of;
	ArrayList<Beverage> list_of_bvr = new ArrayList<Beverage>();
	
	public Label() {
		setLayout(null);
		setSize(933,700);
		setLocationRelativeTo(null);
		setTitle("Order");
		init();
		btnAdd.addActionListener(this); 
		btnOrder.addActionListener(this);
		setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		f1 = new Font("Segoe UI Black", Font.PLAIN, 23);
        f2 = new Font("Segoe UI Semibold", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);
        f4 = new Font("Segoe UI", Font.PLAIN, 15);
        f5 = new Font("Segoe UI Black", Font.PLAIN, 15);
        f6 = new Font("Segoe UI Black", Font.PLAIN, 25);
	}
	
	public void init() {
		
		
		lblBev = new JLabel("Select which type of beverage you want to order:");//a JLabel that labels the radioButtons 
		lblBev.setBounds(100,20,500,50);
		lblBev.setFont(f3);
		add(lblBev);
		
		btnGroup = new ButtonGroup();
		
		//Coffee
		rdCoffee = new JRadioButton("Coffee");
		rdCoffee.setBounds(40,240,75,50);
		add(rdCoffee);
		
		String[] sizes1 = {"Hot","Cold","Black","Cappuccino"};
		size = new JComboBox<String>(sizes1);//
		size.setSelectedIndex(0);//default selection is hot
		size.setBounds(120,255,100, 25);
		add(size);
		
		this.img = new ImageIcon("H:\\New folder (2)\\project\\project\\Coffee.jpg");
		this.lblImage = new JLabel("", img, JLabel.CENTER);
		this.lblImage.setBounds(50,70,150,150);
		this.add(lblImage);
		
		//Tea
		rdTea = new JRadioButton("Tea");
		rdTea.setBounds(260, 240,75, 50);
		add(rdTea);
		
		String[] sizes2 = {"Milk","Red","Green"};
		size = new JComboBox<String>(sizes2);//
		size.setSelectedIndex(0);//default selection is Milk
		size.setBounds(340,255,100, 25);
		add(size);
		
		this.img2 = new ImageIcon("H:\\New folder (2)\\project\\project\\Tea.jpg");
		this.lblImage2 = new JLabel("", img2, JLabel.CENTER);
		this.lblImage2.setBounds(270,70,150,150);
		this.add(lblImage2);
		
		//Juice
		rdJuice = new JRadioButton("Juice");
		rdJuice.setBounds(480,240,75, 50);
		add(rdJuice);
		
		String[] sizes3 = {"Apple","Orange","Pineapple"};
		size = new JComboBox<String>(sizes3);//
		size.setSelectedIndex(0);//default selection is Apple
		size.setBounds(560,255,100, 25);
		add(size);
		
		this.img3 = new ImageIcon("H:\\New folder (2)\\project\\project\\Juice.jpg");
		this.lblImage3 = new JLabel("", img3, JLabel.CENTER);
		this.lblImage3.setBounds(490,70,150,150);
		this.add(lblImage3);
		
		//Water
		rdWater = new JRadioButton("Water");
		rdWater.setBounds(700,240,75,50);
		add(rdWater);
		
		String[] sizes4 = {"Small","Medium","Large"};
		size = new JComboBox<String>(sizes4);//
		size.setSelectedIndex(0);//default selection is Small
		size.setBounds(780,255,100, 25);
		add(size);
		
		this.img4 = new ImageIcon("H:\\New folder (2)\\project\\project\\Water.jpg");
		this.lblImage4 = new JLabel("", img4, JLabel.CENTER);
		this.lblImage4.setBounds(710,70,150,150);
		this.add(lblImage4);
		
		btnGroup.add(rdJuice);
		btnGroup.add(rdWater);
		btnGroup.add(rdTea);
		btnGroup.add(rdCoffee);
		
		lblGlass = new JLabel("Type how many glasses you want to order:");//a JLabel that labels the Text Field
		lblGlass.setBounds(100,330,500, 50);
		add(lblGlass);
		
		txtGlass = new JTextField();//a JTextField to get how many glasses of beverage is the user want
		txtGlass.setBounds(100,370,300, 25);
		add(txtGlass);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(100, 450,120, 40);
		add(btnBack);
		
		btnAdd = new JButton("Add");
		btnAdd.setSize(120, 40);
		btnAdd.setLocation(280, 450);
		add(btnAdd);
		
		btnOrder = new JButton("Order");
		btnOrder.setSize(120, 40);
		btnOrder.setLocation(460, 450);
		btnOrder.setEnabled(false);
		add(btnOrder);
		
		
		btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
				
				setVisible(false);
                Home H = new Home();
                H.setVisible(true);
			}
		 });
		
		
		lblReport = new JLabel();//will be showing report of the beverages that added.
		lblReport.setSize(500, 50);
		lblReport.setLocation(100, 500);
		add(lblReport);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String size_of = (String)size.getSelectedItem();
		if(e.getSource().equals(btnAdd)) {
			if( rdJuice.isSelected() || rdTea.isSelected() || rdCoffee.isSelected() || rdWater.isSelected() && !(txtGlass.getText().isEmpty())) {
				try {
					amount_of  = Integer.parseInt(txtGlass.getText().trim());
					Beverage bvg;
					if(rdJuice.isSelected())  { bvg = new Juice(size_of,amount_of,this); }
					else if(rdWater.isSelected())  { bvg = new Water(size_of,amount_of,this); }
					else if(rdTea.isSelected())    { bvg = new Tea(size_of,amount_of,this); }
					else { bvg = new Coffee(size_of,amount_of,this); }
					txtGlass.setText(null);
					list_of_bvr.add(bvg);
					lblReport.setText(bvg.toString()+" added");
					btnGroup.clearSelection();
					btnOrder.setEnabled(true);
				}
				catch(NumberFormatException e1) {//if written data in TextField can't be converted to an integer[String,char,double etc...]
					JOptionPane.showMessageDialog(this, "Enter an integer as amount");
				}
			}	
			else { JOptionPane.showMessageDialog(this, "Choose a beverage type and enter an amount"); 
			//if none of the radio buttons are selected or the textField is empty
			}
		}
		if(e.getSource().equals(btnOrder)) {
			String report = "";
			double pay=0.0;
			for(int i=0;i<list_of_bvr.size();i++) {
				Beverage bvgi = list_of_bvr.get(i);
				report += bvgi.toString();
				double totalprice_of_bvg = bvgi.getAmount() * bvgi.getPrice();
				pay += totalprice_of_bvg; // add the total amount to be paid
				report = report + " - "+totalprice_of_bvg+" Taka\n";
			}
			JOptionPane.showMessageDialog(this, report);
			JOptionPane.showMessageDialog(this,	 "You should pay "+pay+" Taka");
			lblReport.setText(null);
			btnOrder.setEnabled(false);
			list_of_bvr.clear();
			setVisible(false);
            Payment p = new Payment();
            p.setVisible(true);
			
		}	
	}

	public static void main(String[] args) {
		new Label();
	}
}
