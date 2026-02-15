import javax.swing.JOptionPane;

public class Juice extends Beverage {
    private String fruit;
    String[] fruits = { "Apple", "Orange", "Pineapple" };

    public Juice(String size, int amount, Label lbl) {
        super(size, amount);
        try {
            fruit = (String) JOptionPane.showInputDialog(lbl, "Select a fruit.", "Select a fruit",
                    JOptionPane.QUESTION_MESSAGE, null, fruits, fruits[0]);
            double price;
            if (size.equals("Apple"))
                price = 80;
            else if (size.equals("Orange"))
                price = 100;
            else
                price = 70;
            if (fruit.equals("Orange"))
                price *= 1.2;
            if (fruit.equals("Pineapple"))
                price *= 1.2;
            setPrice(price);
        } catch (NullPointerException e) {
        }
    }

    @Override
	public String toString() {
		return super.toString()+fruit+" juice";
	}
}
