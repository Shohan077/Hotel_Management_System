package myClasses;
import myInterfaces.IAccountOperationsCombined;
import java.lang.*;

public class Customer implements IAccountOperationsCombined{
	private String phnNumber;
	Account accounts[];
	int maxAccountSize = 0;
	int numberOfAccount = 0;
	
	//SavingsAccount sAccounts[];
	//FixedAccount fAccounts[];

	public Customer(){}
	public Customer(String phnNumber, int sizeOfArray)
	{
		this.phnNumber = phnNumber;
		this.accounts = new Account[sizeOfArray];
		this.maxAccountSize = sizeOfArray;
	}
	
	public int getAccountLeft(){return maxAccountSize-numberOfAccount;}
	
	public void addAccount(Account a)
	{
		boolean flag = false;
		
		for(int i=0; i<accounts.length; i++)
		{
			if(accounts[i] == null)
			{
				accounts[i] = a;
				flag = true;
				numberOfAccount++;
				break;
			}
		}
		
		if(flag){System.out.println("Inserted");}
		else {System.out.println("Can Not Insert");}
	}
	public void removeAccount(Account a)
	{
		int flag =0;
		for(int i=0; i<accounts.length; i++)
		{
			if(accounts[i] == a)
			{
				accounts[i] = null;
				flag = 1;
				numberOfAccount--;
				break;
			}
		}
		if(flag==1){System.out.println("-----Removed-----");}
		else{System.out.println("-----CanNot Remove-----");}
	}
	
	public void showAllAccounts()
	{
		System.out.println("Phn Number: "+phnNumber);
		for(int i=0; i<accounts.length; i++)
		{
			if(accounts[i] != null)
			{
				System.out.println("-----------------------");
				accounts[i].showDetails();
				System.out.println();
			}
		}
	
	}
	
	public Account getAccbyAccNo(int accountNumber)
	{
		Account a = null;
		for(int i=0; i<accounts.length; i++)
		{
			if(accounts[i] != null)
			{
				if(accounts[i].getAccountNumber() == accountNumber)
				{
					a=accounts[i];
					break;
				}
			}
		}
		return a;
	}
	
	public void showAllSavings()
	{
		System.out.println("Phn Number: "+phnNumber);
		for(int i=0; i<accounts.length; i++)
		{
			if(accounts[i] != null)
			{
				if(accounts[i] instanceof SavingsAccount){
		
					System.out.println("-----------------------");
					accounts[i].showDetails();
					System.out.println();
				}
			}
		}
	
	}
}




