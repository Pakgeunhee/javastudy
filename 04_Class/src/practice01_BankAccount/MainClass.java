package practice01_BankAccount;

public class MainClass {

	public static void main(String[] args) {
		
		BankAccount myAcc = new BankAccount("010-1111-1111", 50_000);
		
		BankAccount youAcc = new BankAccount("010-9999-9999", 100_000);
		
		myAcc.transfer(youAcc, 100_000);
		
		myAcc.inquiry();
		youAcc.inquiry();

	}

}
