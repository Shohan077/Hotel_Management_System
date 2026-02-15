package myClasses;
import java.lang.*;
import myInterfaces.IAccountOperation;

public class FixedAccount extends Account
{
	private int tenureYear;
	
	public void setTenureYear(int tenureYear)
	{
		this.tenureYear = tenureYear;
	}
	public int getTenureYear()
	{
		return tenureYear;
	}
}