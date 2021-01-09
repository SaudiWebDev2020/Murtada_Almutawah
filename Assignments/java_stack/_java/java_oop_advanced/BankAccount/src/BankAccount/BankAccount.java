package BankAccount;

import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
	private static int numberOfAccounts = 0;
	private static double totalAmountStored = 0.0;
	
	public BankAccount() {
		this.setAccountNumber(createRandomAccountNumber());
		this.setCheckingBalance(0.0);
		setNumberOfAccounts(getNumberOfAccounts() + 1);
	}
	
	
	private String createRandomAccountNumber() {
		String account = "";
		Random r = new Random();
		
		for(int i =0;i<10;i++) {
			account += r.nextInt(10);
		}
		
		return account;
	}

	public void depositToChecking(double amount) {
		if (amount < 0) {
			throw new Error("Amount must be positive");
		} else {
			this.setCheckingBalance(this.getCheckingBalance() + amount);
			setTotalAmountStored(getTotalAmountStored() + amount);
		}
	}
	
	public double withdrawFromChecking(double amount) {
		if(this.getCheckingBalance() < amount) {
			throw new Error("Insufficient funds");
		} else {
			this.setCheckingBalance(this.getCheckingBalance() - amount);
			setTotalAmountStored(getTotalAmountStored() - amount);
		}
		
		return amount;
	}
	
	public double withdrawFromSaving(double amount) {
		if(this.getSavingsBalance() < amount) {
			throw new Error("Insufficient funds");
		} else {
			this.setSavingsBalance(this.getSavingsBalance() - amount);
			setTotalAmountStored(getTotalAmountStored() - amount);
		}
		
		return amount;
	}
	
	public void depositToSaving(double amount) {
		if (amount < 0) {
			throw new Error("Amount must be positive");
		} else {
			this.setSavingsBalance(this.getSavingsBalance() + amount);
			setTotalAmountStored(getTotalAmountStored() + amount);
		}
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	private void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getCheckingBalance() {
		return checkingBalance;
	}
	private void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}


	public double getSavingsBalance() {
		return savingsBalance;
	}
	private void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}


	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	private static void setNumberOfAccounts(int numberOfAccounts) {
		BankAccount.numberOfAccounts = numberOfAccounts;
	}

	public static double getTotalAmountStored() {
		return totalAmountStored;
	}
	private static void setTotalAmountStored(double totalAmountStored) {
		BankAccount.totalAmountStored = totalAmountStored;
	}


	public String toString(){
		String str = String.format("Account no: %s, Checking Balance = $%7.2f, Saving Balance = $%7.2f,", this.getAccountNumber(),this.getCheckingBalance(),this.getSavingsBalance());
		return str;
	}
}
