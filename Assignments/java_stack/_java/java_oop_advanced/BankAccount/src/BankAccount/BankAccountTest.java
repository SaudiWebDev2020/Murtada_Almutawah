package BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount acc1 = new BankAccount();
		acc1.depositToChecking(100);
		acc1.depositToChecking(1050);
		acc1.depositToChecking(500);
		acc1.withdrawFromChecking(500);
		
		BankAccount acc2 = new BankAccount();
		acc2.depositToSaving(100);
		acc2.depositToChecking(1050);
		acc2.withdrawFromChecking(50);
		
		System.out.println(acc1);
		System.out.println(acc2);
		System.out.println(String.format("Total Number of Accounts = %d",BankAccount.getNumberOfAccounts()));
		System.out.println(String.format("Total Balance in the bank = $%.2f",BankAccount.getTotalAmountStored()));
	}

}
