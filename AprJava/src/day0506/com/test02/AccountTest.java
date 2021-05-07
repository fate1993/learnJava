package day0506.com.test02;

public class AccountTest {

	public static void main(String[] args) {
		Account account;
		account = new Account("441-0290-1203",500000,7.3);
		System.out.print("계좌정보: "+account.getAccount()+" ");
		System.out.print("현재잔액: "+account.getBalance()+" ");
		System.out.println();
		
		account.deposit(20000);
		System.out.print("계좌정보: "+account.getAccount()+" ");
		System.out.print("현재잔액: "+account.getBalance()+" ");
		System.out.println();
		System.out.print("이자: "+account.calculateInterest()+" ");
	}
}