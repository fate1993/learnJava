package day0430.whileex;

import java.util.Scanner;
/*키보드로 입력된 데이터로 예금, 출금, 조회, 종료의 기능을 제공하는 프로그램을 작성하세요.*/
public class BankEx {
	public static void main(String[] args) {
		boolean run = true;		
		
		int balance = 0; //잔액
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			
			System.out.println("-------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			
			int menuNum = scanner.nextInt();
			
			if(menuNum==1) {
				System.out.print("예금할 금액을 입력하세요 : ");
				//balance +=scanner.nextInt();
				int input = scanner.nextInt();
				balance+=input;
			}
			
			if(menuNum==2) {
				System.out.print("출금할 금액을 입력하세요 : ");
				int output = scanner.nextInt();
				if(balance<output) {
					System.out.println("잔액이 부족합니다");
				} else {
					balance-=output;
				}
			}
			
			if(menuNum==3) {
				System.out.println("잔고 : "+balance+"원");
			}
			
			if(menuNum==4) {
				run=false; // while 조건식을 false로 만들면 종료.
			}
			
			/*코드 작성
			 * 1. 예금 - 사용자 입금금액, balance에서 더하기
			 * 2. 출금 - 사용자 출금금액, balance에서 빼기(-가 되선 안됨)
			 * 3. 잔고 - balance 출력
			 * 4. 종료 - 반복 끝
			 * */			
		}
		System.out.println("프로그램 종료");
	}
}