package day0429.ifelse;

import java.util.Scanner;

public class ElectricityBill {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("전기 사용량을 입력하세요 : ");
		int use = scan.nextInt(); // 사용량
		
		int fee = 0; // 기본요금
		double price = 0; // 단가
		double amountOfPay = 0; // 전기 요금
		
		if(use <= 200) {
			price = 99.3;
			fee = 910;
		} else if(use >= 201 && use < 400) {
			price = 187.9;
			fee = 1600;
		} else {
			price = 280.6;
			fee = 7300;
		}
		
		amountOfPay = use * price + fee; // 전기요금 : 사용량*단가+기본요금
		System.out.println("사용량 : "+use+" kwh");
		System.out.println("기본요금 : "+fee+ " 원");
		System.out.println("단가 : "+price+ " 원");
		System.out.println("전기 요금 : "+amountOfPay+ " 원");
	}
}
