package day0429.ifelse;

import java.util.Scanner;

public class IfEx3 {
	public static void main(String[] args) {
		// 입력받은 숫자가 짝수라면 "짝수", 홀수라면 "홀수"라고 출력한다.
		System.out.print("숫자를 입력하세요 : ");
		
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		if(number%2==0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		System.out.println("프로그램 종료");
	}
}
