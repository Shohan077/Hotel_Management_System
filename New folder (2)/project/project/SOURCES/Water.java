import javax.swing.JOptionPane;

public class Water extends Beverage {
	private boolean iced;

	public Water(String size,int amount,Label lbl) {
		super(size,amount);
		if(JOptionPane.showConfirmDialog(lbl, "Would you like ice?","Ice",JOptionPane.YES_NO_OPTION)==0) iced=true;
		else iced=false;
		double price;
		if(size.equals("Small")) price = 15;
		else if(size.equals("Medium")) price = 25;
		else price = 35;
		if(iced) price += 10; 
		setPrice(price);
	}

    @Override
	public String toString() {
		if(iced) return super.toString()+"Water with ice";
		else return super.toString() + "Water";
	}
}