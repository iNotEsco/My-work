// Jason Aaron Escobar Escoto
/*
 * This class manages the 'acctNum' and 'balance' of each object of 
 * StudentAccount made and keeps track of how many StudentAccount's were
 * made.
 */
package assg3_Escobar;

public class StudentAccount {
	private long acctNum;
	private double balance;
	static int counter = 0;

	/*
	 * This will make a StudentAccount with the acctNum being the
	 * next integer available, starting with 1. If 2 accounts are already
	 * made, then this acctNum will be 3. The balance will equal 0.
	 */

	public StudentAccount()
	{
		counter++;
		setBalance(0);
		acctNum = counter;
	}

	/*
	 * This will make a StudentAccount with the acctNum being the
	 * next integer available, starting with 1. If 2 accounts are already
	 * made, then this acctNum will be 3. The balance will equal x.
	 * 
	 * @param	x	the initial balance of the new StudentAccount.	
	 */

	public StudentAccount(double x)
	{
		counter++;
		setBalance(x);
		acctNum = counter;
	}
	/*
	 * This method will return the account number of 'this'.
	 * 	
	 * @return		the account number of 'this'.
	 */
	public long getAcctNo()
	{
		return acctNum;
	}

	/*
	 * This method will return the balance of 'this'.
	 * 
	 * @return		the balance of 'this'.
	 */

	public double getBalance()
	{
		return balance;
	}

	/*
	 * This method will return the counter in this class. The counter counts
	 * how many objects of type StudentAccount have been made.
	 * 	
	 * @return		the counter of how many object have been made.
	 */

	public int getCounter ()
	{
		return counter;
	}

	/*
	 * This method will set the balance of 'this' equal to x.
	 * 
	 * @param	x	the amount that will be set for the balance of 'this'.
	 */

	public void setBalance(double x)
	{
		balance = x;
	}

	/*
	 * This method will add x to the balance of 'this' and make that the
	 * new balance of 'this'.
	 * 
	 * x must be greater than or equal to 0 in order to be added to the 
	 * balance. If x is negative, then an error message will be displayed 
	 * and the balance will remain the same.
	 * 
	 * @param	x	the amount that will be added to the balance of 'this'	
	 */

	public void deposit(double x)
	{
		if(x < 0)
		{
			System.out.println("must deposit a positive number\n");
			return;
		}
		setBalance(balance + x);
	}

	/*
	 * This method will subtract x from the balance of 'this' and make that
	 * the new balance of 'this'.
	 * 
	 * x must be greater than or equal to 0 in order for it to be subtracted 
	 * from the balance. If x is negative, then an error message will be 
	 * displayed and the balance will remain the same.
	 * 	
	 * @param	x	the amount that will be deducted from the balance of 'this'
	 */

	public void charge(double x)
	{
		if(x < 0)
		{
			System.out.print("must charge a positive number");
			return;
		}
		setBalance(balance - x);
	}

	/* 
	 * This method will take away 'amount' from the balance of x and set 
	 * that as the new balance of x. This method will also add 'amount' to
	 * the balance of 'this' and set that to the new balance of 'this'.
	 * 
	 * 'amount' must be greater than 0. If 'amount' is 0 or less, then 
	 * this method will do nothing.
	 * 
	 * @param	x		the account that the 'amount' will be transferred from.
	 * @param	amount	the amount that will be transfered from x to 'this.
	 */

	public void transferIn (StudentAccount x, double amount)
	{
		if(amount > 0)
		{
			setBalance(balance + amount);
			x.setBalance(x.balance - amount);
		}
	}

	/* 
	 * This method will take away 'amount' from the balance of 'this and set 
	 * that as the new balance of 'this'. This method will also add 'amount' to
	 * the balance of x and set that to the new balance of x.
	 * 
	 * 'amount' must be greater than 0. If 'amount' is 0 or less, then 
	 * this method will do nothing.
	 * 
	 * @param	x		the account that the 'amount' will be transfered to from 'this'
	 * @param	amount	the amount that will  be transfered from 'this' to x.
	 */

	public void transferOut (StudentAccount x, double amount)
	{
		if(amount > 0)
		{
			setBalance(balance - amount);
			x.setBalance(x.balance + amount);
		}
	}

	/* 
	 * This method will print, on the system output, the account number of 'this'
	 * followed by the current balance of 'this' account.
	 * 
	 */

	public void printInfo ()
	{
		System.out.println("Account number: " + acctNum);
		System.out.println("Current balance: " + balance + "\n");
	}

	/* 
	 * This method will return a string with the information of 'this' account. The
	 * string will contain the account number and the current balance of that account.
	 * 
	 * @return		a string with the information of 'this'.
	 */

	public String toString()
	{
		return "Account number: " + acctNum + "\nCurrent balance: " 
				+ balance + "\n";
	}
}
