 import javax.swing.JOptionPane;

public class Coffee extends Beverage {
	private boolean milk,ice; 

	public Coffee(String size,int amount,Label lbl) {
		super(size, amount);
        if(JOptionPane.showConfirmDialog(lbl, "Would you like milk?","Milk",JOptionPane.YES_NO_OPTION)==0) milk=true;
		else if(JOptionPane.showConfirmDialog(lbl, "Would you like ice?","ice",JOptionPane.YES_NO_OPTION)==0) ice=true;
		else milk=false;
		ice=false;

        double price;
        if(size.equals("Hot")) price=50;
		else if(size.equals("Cold")) price = 80;
		else if(size.equals("Black"))price = 120;
		else price=150;
		if(milk) price += 20;
		setPrice(price);
    }

	@Override
	public String toString() {
		if(milk) return super.toString()+" Coffee with milk";
		else return super.toString()+" Coffee";
	}
}