package day0506.com.test02;

public class Account {
	
	String account;
	int balance;
	double interestRate;
	
	Account(){}
	Account(String account, int balance, double interestRate){
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate * 0.01;
	}
	
	void setAccount(String account) {
		this.account = account;
	}
	
	String getAccount() {
		return account;
	}
	
	int getBalance() {
		return balance;
	}
	
	double calculateInterest() {
		return balance*interestRate;
	}
	
	void deposit(int money) {
		balance+=money;
	}
	
	void withdraw(int money) {
		balance-=money;
	}
}