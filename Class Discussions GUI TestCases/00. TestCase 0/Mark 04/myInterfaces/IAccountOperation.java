package myInterfaces;
import myClasses.Account;

public interface IAccountOperation{
	public void addAccount(Account a);
	public void removeAccount(Account a);
	public void showAllAccounts();
	public Account getAccbyAccNo(int accountNumber);
}

