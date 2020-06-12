// Jason Aaron Escobar Escoto
/*
 * This class manages the 'acctNum', 'balance' and 'rewards of each object
 * of RewardsAccount made.
 */
package assg3_Escobar;

public class RewardsAccount extends StudentAccount{

	private double rewards;

	/* 
	 * This will make a RewardsAccount with the acctNum being the
	 * next integer available, starting with 1. If 2 accounts are already
	 * made, then this acctNum will be 3. The balance and the rewards will
	 * equal 0.
	 *  
	 * @param
	 * @param	
	 * @return	
	 */

	public RewardsAccount()
	{
		super();
		rewards = 0;
	}

	/* 
	 * This will make a RewardsAccount with the acctNum being the
	 * next integer available, starting with 1. If 2 accounts are already
	 * made, then this acctNum will be 3. The balance will equal x. If x is
	 * greater than or equal to 100, then the reward will equal 5, if not,
	 * rewards will equal 0.
	 * 
	 * @param	x	the initial balance of the new RewardsAccount.	
	 */

	public RewardsAccount(double x)
	{
		super(x);
		if(x >= 100)
		{
			rewards = 5;
		}
		else
		{
			rewards = 0;
		}
	}

	/* 
	 * This method returns the rewards of 'this'.
	 * 	
	 * @return		the rewards	of 'this'.
	 */

	public double getRewards()
	{
		return rewards;
	}

	/* 
	 * This method will add the rewards of 'this' to the balance of 'this'
	 * and set that as the new balance. The rewards will be reset to 0.
	 * 
	 * The 'rewards' must be greater than or equal to 25. If the 'rewards' is 
	 * not, then this method will display an error message and the balance
	 * of 'this' will remain intact.
	 * 	
	 */

	public void redeemRewards()
	{

		if (rewards >= 25)
		{
			super.deposit(rewards);
			rewards = 0;
		}
		else
		{
			System.out.println("There is insufficient amount for redeeming" +
					" the rewards.\n");
		}
	}

	/* 
	 * This method will return a string with the information of 'this' 
	 * account. The string will contain the account number and the current 
	 * balance and the rewards of 'this' account
	 * 
	 * @return		a string with the information of 'this'.
	 */

	public String toString()
	{

		return "Account number: " + getAcctNo() +
				"\nCurrent balance: " + getBalance() +
				"\nRewards balance: " + getRewards() +
				"\n";
	}

	/*
	 * This method will add x to the balance of 'this' and make that the
	 * new balance of 'this'. If x is greater than 100, then 5 will be added
	 * to 'rewards'.
	 * 
	 * x must be greater than or equal to 0 in order to be added to the 
	 * balance. If x is negative, then an error message will be displayed 
	 * and the balance will remain the same.
	 * 
	 * @param	x	the amount that will be added to the balance of 'this'	
	 */

	public void deposit (double x)
	{
		super.deposit(x);
		if(x >= 100)
		{
			rewards += 5;
		}
	}

	/* 
	 * This method will print, on the system output, the account number of 'this'
	 * followed by the current balance and the 'rewards' of 'this' account.
	 * 
	 */

	public void printInfo()
	{
		System.out.println("Account number: " + getAcctNo());
		System.out.println("Current balance: " + getBalance());
		System.out.println("Rewards balance: " + getRewards() + "\n");
	}


}
