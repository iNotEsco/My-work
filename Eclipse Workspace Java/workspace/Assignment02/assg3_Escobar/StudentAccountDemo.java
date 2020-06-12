// Jason Aaron Escobar Escoto
/*
 * made to test 'StudentAccount.java' and 'RewardsAccount.java'.
 */
package assg3_Escobar;

public class StudentAccountDemo {

	public static void main(String[] args) {

		StudentAccount x = new StudentAccount ();
		System.out.println("account num: " + x.getAcctNo());

		System.out.println("balance: " + x.getBalance());
		x.setBalance(100);

		System.out.println("balance: " + x.getBalance());
		x.deposit(50);

		System.out.println("balance: " + x.getBalance());
		x.charge(25);

		System.out.println("balance: " + x.getBalance() + "\n");

		System.out.println(x);
		x.printInfo();

		RewardsAccount y = new RewardsAccount (1000);

		System.out.println(y);

		y.deposit(-5);
		System.out.println(y);

		y.redeemRewards();
		System.out.println(y);

		y.deposit(100);
		System.out.println(y);

		y.deposit(100);
		System.out.println(y);

		y.deposit(100);
		System.out.println(y);

		y.deposit(100);
		System.out.println(y);

		y.deposit(100);
		System.out.println(y);

		y.redeemRewards();
		y.printInfo();
		
		y.deposit(70);
		y.printInfo();


		RewardsAccount z = new RewardsAccount(500);
		z.printInfo();
		y.transferIn(z, 200);
		y.printInfo();
		z.printInfo();
		
		y.transferOut(z, 200);
		y.printInfo();
		z.printInfo();
		
		System.out.println("counter: " + x.getCounter() + " accts made");

	}

}
