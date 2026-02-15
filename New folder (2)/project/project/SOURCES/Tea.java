import javax.swing.JOptionPane;

public class Tea extends Beverage {
	private boolean sugar;

	public Tea(String size,int amount,Label lbl) {
		super(size,amount);
		if(JOptionPane.showConfirmDialog(lbl, "Would you like sugar?","Sugar",JOptionPane.YES_NO_OPTION)==0) sugar=true;
		else sugar=false;
		double price;
		if(size.equals("Red")) price=80;
		else if (size.equals("Milk")) price=50;
		else price= 120;
		if(sugar) price+=5;
		setPrice(price);
	}
	
	@Override
	public String toString() {
		if(sugar) return super.toString()+"Tea with sugar";
		else return super.toString() + "Tea";
	}
}